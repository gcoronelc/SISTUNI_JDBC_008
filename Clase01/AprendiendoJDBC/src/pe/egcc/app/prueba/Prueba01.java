package pe.egcc.app.prueba;

import java.sql.Connection;
import pe.egcc.app.db.AccesoDB;

/**
 *
 * @author Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 */
public class Prueba01 {
  
  public static void main(String[] args) {
    try {
      Connection cn;
      cn = AccesoDB.getConnection();
      System.out.println("Proceso ok.");
      cn.close();
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
  
}
