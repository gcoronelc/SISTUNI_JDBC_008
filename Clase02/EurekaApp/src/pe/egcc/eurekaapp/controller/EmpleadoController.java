package pe.egcc.eurekaapp.controller;

import pe.egcc.eurekaapp.service.espec.EmpleadoServiceEspec;
import pe.egcc.eurekaapp.service.impl.EmpleadoServiceImpl;

/**
 *
 * @author Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 */
public class EmpleadoController {

  private EmpleadoServiceEspec empleadoService;

  public EmpleadoController() {
    empleadoService = new EmpleadoServiceImpl();
  }

  public void validar(String usuario, String clave) {
    empleadoService.validar(usuario, clave);
  }
}
