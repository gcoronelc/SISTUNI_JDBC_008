package pe.egcc.eurekaapp.service.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import pe.egcc.eurekaapp.model.Empleado;
import pe.egcc.eurekaapp.service.spec.RowMapper;

/**
 *
 * @author Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 */
public class EmpleadoMapper implements RowMapper<Empleado>{

  @Override
  public Empleado mapRow(ResultSet rs) throws SQLException {
    Empleado bean = new Empleado();
    bean.setCodigo(rs.getString("chr_emplcodigo"));
    bean.setPaterno(rs.getString("vch_emplpaterno"));
    bean.setMaterno(rs.getString("vch_emplmaterno"));
    bean.setNombre(rs.getString("vch_emplnombre"));
    bean.setCiudad(rs.getString("vch_emplciudad"));
    bean.setDireccion(rs.getString("vch_empldireccion"));
    bean.setUsuario(rs.getString("vch_emplusuario"));
    bean.setClave("*****");
    return bean;
  }

}
