package pe.egcc.eurekaapp.service.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import pe.egcc.eurekaapp.model.Sucursal;
import pe.egcc.eurekaapp.service.spec.RowMapper;

/**
 *
 * @author Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 */
public class SucursalMapper implements RowMapper<Sucursal>{

  @Override
  public Sucursal mapRow(ResultSet rs) throws SQLException {
    Sucursal bean = new Sucursal();
    
    return bean;
  }
  
}
