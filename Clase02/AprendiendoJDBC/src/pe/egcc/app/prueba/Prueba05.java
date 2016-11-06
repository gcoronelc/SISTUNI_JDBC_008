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
public class Prueba05 {
  
  public static void main(String[] args) {
    Connection cn = null;
    try {
      // Dato
      String cuenta;
      cuenta = JOptionPane.showInputDialog(
              "Ingreso codigo de cuenta");
      // Procedimiento
      String sql = "{call usp_egcc_saldo_sucursal(?,?,?)}";
      // Conexión
      cn = AccesoDB.getConnection();
      // Paso 1: Preparar el procedimiento
      CallableStatement cstm = cn.prepareCall(sql);
      // Paso 2: Trabajando los parámetros
      cstm.setString(1, cuenta);
      cstm.registerOutParameter(2, Types.DECIMAL);
      cstm.registerOutParameter(3, Types.DECIMAL);
      // Paso 3: Ejecutar el procedimiento
      cstm.executeUpdate();
      // Leer paránetro de salida
      double saldo_soles = cstm.getDouble(2);
      double saldo_dolares = cstm.getDouble(3);
      // Resultado
      System.out.println("Saldo Soles: " + saldo_soles);
      System.out.println("Saldo Dolares: " + saldo_dolares);
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
