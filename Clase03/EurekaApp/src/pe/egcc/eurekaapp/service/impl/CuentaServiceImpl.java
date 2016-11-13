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
import pe.egcc.eurekaapp.service.espec.CuentaServiceEspec;

/**
 *
 * @author Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 */
public class CuentaServiceImpl implements CuentaServiceEspec {

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
      while(rs.next()){
        Map<String,Object> rec = new HashMap<>();
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

}
