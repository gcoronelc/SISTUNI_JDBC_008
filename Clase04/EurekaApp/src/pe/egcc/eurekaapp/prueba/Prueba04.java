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
public class Prueba04 {
  
  public static void main(String[] args) {
    try {
      // Dato
      Tsession bean = new Tsession();
      bean.setId(8);
      // Proceso
      TsessionServiceSpec service;
      service = new TsessionServiceImpl();
      service.actualiza(bean);
      System.out.println("Fecha = " + bean.getFecfin());
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
  
}
