package pe.egcc.eurekaapp.service.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import pe.egcc.eurekaapp.model.Cliente;
import pe.egcc.eurekaapp.service.spec.RowMapper;

/**
 *
 * @author Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 */
public class ClienteMapper implements RowMapper<Cliente>{

  @Override
  public Cliente mapRow(ResultSet rs) throws SQLException {
    Cliente bean = new Cliente();
    
    return bean;
  }
  
}
