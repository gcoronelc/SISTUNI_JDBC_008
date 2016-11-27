package pe.egcc.eurekaapp.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import pe.egcc.eurekaapp.db.AccesoDB;
import pe.egcc.eurekaapp.model.Empleado;
import pe.egcc.eurekaapp.service.spec.EmpleadoServiceSpec;
import pe.egcc.eurekaapp.service.mapper.EmpleadoMapper;

/**
 *
 * @author Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 */
public class EmpleadoServiceImpl implements EmpleadoServiceSpec{

  /**
   * Valida el usuario y la clase para un inicio de sesión.
   * 
   * @param usuario Usuario que inicia sesión.
   * @param clave Clave del usuario.
   * @return Retorna el objeto Empleado correspondiente al usuario.
   */
  @Override
  public Empleado validar(String usuario, String clave) {
    Empleado bean = null;
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select chr_emplcodigo, vch_emplpaterno,"
              + "vch_emplmaterno,vch_emplnombre,"
              + "vch_emplciudad,vch_empldireccion,"
              + "vch_emplusuario from empleado "
              + "where vch_emplusuario=? and vch_emplclave=?";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, usuario);
      pstm.setString(2, clave);
      ResultSet rs = pstm.executeQuery();
      if(rs.next()){
        EmpleadoMapper empleadoMapper = new EmpleadoMapper();
        bean = empleadoMapper.mapRow(rs);
      }
      rs.close();
      pstm.close();
      if(bean == null){
        throw new Exception("Datos incorrectos.");
      }
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    } finally{
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    return bean;
  }

  @Override
  public Empleado read(String code) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Empleado> read(Empleado bean) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void create(Empleado bean) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void update(Empleado bean) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void delete(String code) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
  
}
