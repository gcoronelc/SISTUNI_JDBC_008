package pe.egcc.eurekaapp.service.espec;

import pe.egcc.eurekaapp.model.Empleado;

/**
 *
 * @author Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 */
public interface EmpleadoServiceEspec 
  extends CrudServiceEspec<Empleado>{
  
  Empleado validar(String usuario, String clave);
  
}
