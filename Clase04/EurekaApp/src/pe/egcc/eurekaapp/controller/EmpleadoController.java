package pe.egcc.eurekaapp.controller;

import java.util.Calendar;
import pe.egcc.eurekaapp.model.Empleado;
import pe.egcc.eurekaapp.model.Tsession;
import pe.egcc.eurekaapp.service.spec.EmpleadoServiceSpec;
import pe.egcc.eurekaapp.service.spec.TsessionServiceSpec;
import pe.egcc.eurekaapp.service.impl.EmpleadoServiceImpl;
import pe.egcc.eurekaapp.service.impl.TsessionServiceImpl;
import pe.egcc.eurekaapp.util.Session;

/**
 *
 * @author Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 */
public class EmpleadoController {

  private EmpleadoServiceSpec empleadoService;
  private TsessionServiceSpec tsessionService;

  public EmpleadoController() {
    empleadoService = new EmpleadoServiceImpl();
    tsessionService = new TsessionServiceImpl();
  }

  public void validar(String usuario, String clave) {
    Empleado empBean = empleadoService.validar(usuario, clave);
//    Tsession tsessionBean;
//    tsessionBean = tsessionService.getSession(empBean.getCodigo());
//    if(tsessionBean != null){
//      throw new RuntimeException("Tienes una sesión activa en el equipo: " + tsessionBean.getEquipo());
//    }
//    tsessionBean = new Tsession();
//    tsessionBean.setCodemp(empBean.getCodigo());
//    tsessionBean.setEquipo("ALIANZA");
//    tsessionBean.setEstado(1);
//    tsessionBean.setFecini(Calendar.getInstance().getTime());
//    tsessionService.crear(tsessionBean);
    Session.put("usuario", empBean);
   // Session.put("tsession", tsessionBean);
  }
  
}
