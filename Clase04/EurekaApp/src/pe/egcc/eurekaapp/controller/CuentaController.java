package pe.egcc.eurekaapp.controller;

import java.util.List;
import java.util.Map;
import pe.egcc.eurekaapp.model.Empleado;
import pe.egcc.eurekaapp.service.spec.CuentaServiceSpec;
import pe.egcc.eurekaapp.service.impl.CuentaServiceImpl;
import pe.egcc.eurekaapp.util.Session;

/**
 *
 * @author Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 */
public class CuentaController {
  
  private CuentaServiceSpec cuentaService;

  public CuentaController() {
    cuentaService = new CuentaServiceImpl();
  }
  public List<Map<String,?>> getResumen001(){
    return cuentaService.getResumen001();
  }

  public int procRetiro(String cuenta, double importe, String clave) {
    // Empleado
    Empleado bean = (Empleado) Session.get("usuario");
    // Proceso
    return cuentaService.procRetiro(cuenta, importe, clave, bean.getCodigo());
  }
  
}
