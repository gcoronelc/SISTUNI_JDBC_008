package pe.egcc.eurekaapp.service.spec;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Solución tomada de Spring Framework.
 * 
 * @author Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 */
public interface RowMapper <T>{
  
  T mapRow(ResultSet rs) throws SQLException;
  
}
