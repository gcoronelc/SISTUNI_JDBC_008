package pe.egcc.eurekaapp.controller;

import java.util.List;
import java.util.Map;
import pe.egcc.eurekaapp.service.espec.CuentaServiceEspec;
import pe.egcc.eurekaapp.service.impl.CuentaServiceImpl;

/**
 *
 * @author Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 */
public class CuentaController {
  
  private CuentaServiceEspec cuentaService;

  public CuentaController() {
    cuentaService = new CuentaServiceImpl();
  }
  public List<Map<String,?>> getResumen001(){
    return cuentaService.getResumen001();
  }
  
}
