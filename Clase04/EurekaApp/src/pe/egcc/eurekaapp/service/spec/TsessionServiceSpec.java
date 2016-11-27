package pe.egcc.eurekaapp.service.spec;

import pe.egcc.eurekaapp.model.Tsession;

/**
 *
 * @author Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 */
public interface TsessionServiceSpec {
  
  /**
   * Crea una session en la base de datos.
   * @param bean 
   */
  void crear(Tsession bean);
  
  /**
   * Retorna la sesión abierta del empleado.
   * 
   * @param codEmp
   * @return Retorna la sesión abierta o null.
   */
  Tsession getSession(String codEmp);
  
  /**
   * Actualiza una sesión.
   * 
   * @param bean 
   */
  void actualiza(Tsession bean);
  
}
