package pe.egcc.app.prueba;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
public class Prueba02 {
  
  public static void main(String[] args) {
    Connection cn = null;
    try {
      // Dato
      String codSucu;
      codSucu = JOptionPane.showInputDialog("Ingreso codigo de sucursal");
      // Consulta
      String sql = "select * from cuenta where "
              + "chr_sucucodigo = '" + codSucu + "'";
      cn = AccesoDB.getConnection();
      Statement stm = cn.createStatement();
      ResultSet rs = stm.executeQuery(sql);
      while(rs.next()){
        String texto = rs.getString("chr_cuencodigo") + 
                " - " + rs.getDouble("dec_cuensaldo") + 
                " - " + rs.getString("vch_cuenestado");
        System.out.println(texto);
      }
      rs.close();
      stm.close();
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
