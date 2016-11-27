package pe.egcc.eurekaapp.service.spec;

import pe.egcc.eurekaapp.model.Empleado;

/**
 *
 * @author Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 */
public interface EmpleadoServiceSpec 
  extends CrudServiceSpec<Empleado>{
  
  Empleado validar(String usuario, String clave);
  
}
