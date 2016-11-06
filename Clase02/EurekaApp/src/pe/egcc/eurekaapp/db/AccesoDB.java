package pe.egcc.eurekaapp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Permite obtener un objeto Connection
 * 
 * @author Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 */
public final class AccesoDB {

  private AccesoDB() {
  }
  
  /**
   * Permite obtener un objeto de tipo Connection con una conexión activa.
   * 
   * @return Un objeto Connection
   * @throws SQLException 
   */
  public static Connection getConnection() 
    throws SQLException{
    // Parámetros
    String driver = "oracle.jdbc.OracleDriver";
    String urlDB = "jdbc:oracle:thin:@localhost:1521:XE";
    String user = "eureka";
    String pass = "admin";
    // Variable Connection
    Connection cn = null;
    try {
      // Paso 1: Cargar el driver
      Class.forName(driver).newInstance();
      // Paso 2: Obtener Conexión
      cn = DriverManager.getConnection(urlDB, user, pass);
    } catch (ClassNotFoundException e) {
      throw new SQLException("No existe el driver.");
    } catch (SQLException e) {
      throw e;
    } catch (Exception e) {
      throw new SQLException("No se tiene acceso al servidor.");
    }
    return cn;
  }
  
}
