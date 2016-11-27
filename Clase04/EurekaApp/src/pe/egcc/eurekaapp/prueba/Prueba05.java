package pe.egcc.eurekaapp.prueba;

import java.util.Map;
import pe.egcc.eurekaapp.service.spec.CuentaServiceSpec;
import pe.egcc.eurekaapp.service.impl.CuentaServiceImpl;

/**
 *
 * @author Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 */
public class Prueba05 {
  
  public static void main(String[] args) {
    try {
      CuentaServiceSpec service;
      service = new CuentaServiceImpl();
      for(Map<String,?> r: service.getResumen001()){
        String texto = "";
        texto += r.get("codsucursal").toString() + " - ";
        texto += r.get("nomsucursal").toString() + " - ";
        texto += r.get("soles").toString() + " - ";
        texto += r.get("dolares").toString();
        System.out.println(texto);
      }
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
}
