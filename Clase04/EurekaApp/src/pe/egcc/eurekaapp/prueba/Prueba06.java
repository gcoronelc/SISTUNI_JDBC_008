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
public class Prueba06 {
  
  public static void main(String[] args) {
    try {
      // Datos
      String cuenta = "00100001";
      double importe = 100.0;
      String clave = "123456";
      String codEmp = "0002";
      // Proceso
      CuentaServiceSpec service;
      service = new CuentaServiceImpl();
      int numOpe = service.procRetiro(cuenta, importe, clave, codEmp);
      System.out.println("Nro. Ope. " + numOpe);
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
}
