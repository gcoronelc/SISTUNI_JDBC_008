package pe.egcc.eurekaapp.prueba;

import java.util.Calendar;
import pe.egcc.eurekaapp.model.Tsession;
import pe.egcc.eurekaapp.service.spec.TsessionServiceSpec;
import pe.egcc.eurekaapp.service.impl.TsessionServiceImpl;

/**
 *
 * @author Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 */
public class Prueba03 {
  
  public static void main(String[] args) {
    try {
      // Dato
      Tsession bean = new Tsession();
      bean.setCodemp("0003");
      bean.setEquipo("ALIANZA");
      bean.setEstado(1);
      bean.setFecini(Calendar.getInstance().getTime());
      // Proceso
      TsessionServiceSpec service;
      service = new TsessionServiceImpl();
      service.crear(bean);
      System.out.println("Ok. Id = " + bean.getId());
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
  
}
