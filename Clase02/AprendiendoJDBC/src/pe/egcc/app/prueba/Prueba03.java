package pe.egcc.app.prueba;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class Prueba03 {
  
  public static void main(String[] args) {
    Connection cn = null;
    try {
      // Dato
      String codSucu;
      codSucu = JOptionPane.showInputDialog(
              "Ingreso codigo de sucursal");
      // Consulta
      String sql = "select * from cuenta where "
              + "chr_sucucodigo = ?";
      cn = AccesoDB.getConnection();
      // Paso 1: Preparas tu sentencia
      PreparedStatement pstm = cn.prepareStatement(sql);
      // Paso 2: Asignas valores a los parámetros
      pstm.setString(1, codSucu);
      // Paso 3: Ejecutas la sentencia
      ResultSet rs = pstm.executeQuery();
      while(rs.next()){
        String texto = rs.getString("chr_cuencodigo") + 
                " - " + rs.getDouble("dec_cuensaldo") + 
                " - " + rs.getString("vch_cuenestado");
        System.out.println(texto);
      }
      rs.close();
      pstm.close();
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
