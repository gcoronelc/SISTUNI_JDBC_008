package pe.egcc.app.prueba;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import javax.swing.JOptionPane;
import pe.egcc.app.db.AccesoDB;

/**
 * Prueba del objeto Statement.
 * Consulta de cuentas de una sucursal.
 * 
 * @author Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 */
public class Prueba04 {
  
  public static void main(String[] args) {
    Connection cn = null;
    try {
      // Dato
      String cuenta;
      cuenta = JOptionPane.showInputDialog(
              "Ingreso codigo de cuenta");
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
      double saldo = cstm.getDouble(2);
      // Resultado
      System.out.println("Saldo: " + saldo);
      // Fin
      cstm.close();
      System.out.println("SQL: " + sql);
    } catch (Exception e) {
      System.err.println(e.getMessage());
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
  }
  
}
