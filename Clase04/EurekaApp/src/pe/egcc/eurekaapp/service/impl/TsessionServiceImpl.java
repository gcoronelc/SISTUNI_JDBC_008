package pe.egcc.eurekaapp.service.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import pe.egcc.eurekaapp.db.AccesoDB;
import pe.egcc.eurekaapp.model.Tsession;
import pe.egcc.eurekaapp.service.spec.TsessionServiceSpec;
import pe.egcc.eurekaapp.util.EurekaUtil;

/**
 *
 * @author Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 */
public class TsessionServiceImpl implements TsessionServiceSpec {

  @Override
  public void crear(Tsession bean) {
    Connection cn = null;
    try {
      // Conexion
      cn = AccesoDB.getConnection();
      // Inicio de TX
      cn.setAutoCommit(false);
      // Proceso
      // Leer el id
      String sql = "select seqSession.nextVal id from dual";
      PreparedStatement pstm = cn.prepareStatement(sql);
      ResultSet rs = pstm.executeQuery();
      rs.next();
      int id = rs.getInt("id");
      rs.close();
      pstm.close();
      // Insertar session
      sql = "insert into tsession(id,"
              + "codemp,equipo,fecini,estado) "
              + "values(?,?,?,?,?)";
      pstm = cn.prepareStatement(sql);
      pstm.setInt(1, id);
      pstm.setString(2, bean.getCodemp());
      pstm.setString(3, bean.getEquipo());
      pstm.setDate(4, EurekaUtil.utilDateToSqlDate(bean.getFecini()));
      pstm.setInt(5, bean.getEstado());
      pstm.executeUpdate();
      pstm.close();
      // Confirmar
      bean.setId(id);
      cn.commit();
    } catch (Exception e) {
      try {
        cn.rollback();
      } catch (Exception e1) {
      }
      throw new RuntimeException(e.getMessage());
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
  }

  @Override
  public Tsession getSession(String codEmp) {
    Tsession bean = null;
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select id, codemp, equipo, fecini, "
              + "fecfin, estado from tsession "
              + "where codemp = ? and estado = 1";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, codEmp);
      ResultSet rs = pstm.executeQuery();
      if(rs.next()){
        bean = new Tsession();
        bean.setId(rs.getInt("id"));
        bean.setCodemp(rs.getString("codemp"));
        bean.setEquipo(rs.getString("equipo"));
        bean.setFecini(rs.getDate("fecini"));
        bean.setFecfin(rs.getDate("fecfin"));
        bean.setEstado(rs.getInt("estado"));
      }
      rs.close();
      pstm.close();
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    return bean;
  }

  @Override
  public void actualiza(Tsession bean) {
    Connection cn = null;
    try {
      // Conexion
      cn = AccesoDB.getConnection();
      // Inicio de TX
      cn.setAutoCommit(false);
      // Proceso
      // Obtener fecha de la computadora
      java.util.Date utilDate;
      java.sql.Date sqlDate;
      utilDate =Calendar.getInstance().getTime();
      sqlDate = EurekaUtil.utilDateToSqlDate(utilDate);
      // Actualizar sesión
      String sql = "update tsession set fecfin = ?, "
              + "estado = 0 where id = ? ";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setDate(1, sqlDate);
      pstm.setInt(2, bean.getId());
      pstm.executeUpdate();
      pstm.close();
      // Confirmar
      bean.setFecfin(utilDate);
      bean.setEstado(0);
      cn.commit();
    } catch (Exception e) {
      try {
        cn.rollback();
      } catch (Exception e1) {
      }
      throw new RuntimeException(e.getMessage());
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
  }

}
