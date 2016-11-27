package pe.egcc.eurekaapp.service.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pe.egcc.eurekaapp.db.AccesoDB;
import pe.egcc.eurekaapp.service.spec.CuentaServiceSpec;

/**
 *
 * @author Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 */
public class CuentaServiceImpl implements CuentaServiceSpec {

  @Override
  public double getSaldoCuenta(String cuenta) {
    double saldo = 0.0;
    Connection cn = null;
    try {
      // Procedimiento
      String sql = "{call usp_egcc_saldo_cuenta(?,?)}";
      // Conexión
      cn = AccesoDB.getConnection();
      // Paso 1: Preparar el procedimiento
      CallableStatement cstm = cn.prepareCall(sql);
      // Paso 2: Trabajando los parámetros
      cstm.setString(1, cuenta);
      cstm.registerOutParameter(2, Types.DECIMAL);
      // Paso 3: Ejecutar el procedimiento
      cstm.executeUpdate();
      // Leer paránetro de salida
      saldo = cstm.getDouble(2);
      // Fin
      cstm.close();
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    return saldo;
  }

  @Override
  public Map<String, Double> getSaldoSucursal(String codSucursal) {
    Map<String, Double> rpta = new HashMap<>();
    Connection cn = null;
    try {
      // Procedimiento
      String sql = "{call usp_egcc_saldo_sucursal(?,?,?)}";
      // Conexión
      cn = AccesoDB.getConnection();
      // Paso 1: Preparar el procedimiento
      CallableStatement cstm = cn.prepareCall(sql);
      // Paso 2: Trabajando los parámetros
      cstm.setString(1, codSucursal);
      cstm.registerOutParameter(2, Types.DECIMAL);
      cstm.registerOutParameter(3, Types.DECIMAL);
      // Paso 3: Ejecutar el procedimiento
      cstm.executeUpdate();
      // Leer paránetro de salida
      rpta.put("soles", cstm.getDouble(2));
      rpta.put("dolares", cstm.getDouble(3));
      // Fin
      cstm.close();
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }

    return rpta;
  }

  @Override
  public List<Map<String, ?>> getResumen001() {
    List<Map<String, ?>> lista = new ArrayList<>();
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select "
              + "	s.chr_sucucodigo codSucursal, "
              + "	s.vch_sucunombre nomSucursal, "
              + "	sum( case when c.chr_monecodigo = '01' "
              + "	     then c.dec_cuensaldo else 0.0 end ) soles, "
              + "	sum( case when c.chr_monecodigo = '02' "
              + "	     then c.dec_cuensaldo else 0.0 end ) dolares "
              + "  from cuenta c join sucursal s "
              + "  on c.chr_sucucodigo = s.chr_sucucodigo "
              + "  group by s.chr_sucucodigo, s.vch_sucunombre "
              + "  order by 1";
      PreparedStatement pstm = cn.prepareStatement(sql);
      ResultSet rs = pstm.executeQuery();
      while (rs.next()) {
        Map<String, Object> rec = new HashMap<>();
        rec.put("codsucursal", rs.getString("codsucursal"));
        rec.put("nomsucursal", rs.getString("nomsucursal"));
        rec.put("soles", rs.getString("soles"));
        rec.put("dolares", rs.getString("dolares"));
        lista.add(rec);
      }
      rs.close();
      pstm.close();
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    return lista;
  }

  @Override
  public int procRetiro(String cuenta, double importe, String clave, String codEmp) {
    int numOpera = 0;
    Connection cn = null;
    try {
      // Objeto Connection
      cn = AccesoDB.getConnection();
      // Inicio de Tx
      cn.setAutoCommit(false);
      // Paso 1: Leer datos de la cuenta
      String sql = "select dec_cuensaldo, int_cuencontmov "
              + "from cuenta where chr_cuencodigo = ? "
              + "and vch_cuenestado='ACTIVO' "
              + "for update";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, cuenta);
      ResultSet rs = pstm.executeQuery();
      if(!rs.next()){
        throw new Exception("Cuenta no existe o esta cancelada.");
      }
      double saldo = rs.getDouble("dec_cuensaldo");
      numOpera = rs.getInt("int_cuencontmov") + 1;
      rs.close();
      pstm.close();
      // Truquito
      Thread.currentThread().sleep(1000);
      // Paso 2: Verificar saldo
      saldo = saldo - importe;
      if(saldo < 0){
        throw new Exception("Cuenta no tiene saldo suficiente.");
      }
      // Actualizar cuenta
      sql = "update cuenta set dec_cuensaldo = ?, "
              + "int_cuencontmov = ? where chr_cuencodigo = ? ";
      pstm = cn.prepareStatement(sql);
      pstm.setDouble(1, saldo);
      pstm.setInt(2, numOpera);
      pstm.setString(3, cuenta);
      int filas = pstm.executeUpdate();
      pstm.close();
      if(filas != 1){
        throw new Exception("No se puede actualizar la cuenta.");
      }
      // Registrar el movimiento
      sql = "insert into movimiento(chr_cuencodigo,int_movinumero,dtt_movifecha,"
              + "chr_emplcodigo,chr_tipocodigo,dec_moviimporte) "
              + "values(?,?,SYSDATE,?,'004',?)";
      pstm = cn.prepareStatement(sql);
      pstm.setString(1, cuenta);
      pstm.setInt(2, numOpera);
      pstm.setString(3, codEmp);
      pstm.setDouble(4, importe);
      pstm.executeUpdate();
      // Confirmar Tx
      cn.commit();
    } catch (Exception e) {
      try {
        // Cancelar Tx
        cn.rollback();
      } catch (Exception e1) {
      }
      throw new RuntimeException(e.getMessage());
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    return numOpera;
  }

}
