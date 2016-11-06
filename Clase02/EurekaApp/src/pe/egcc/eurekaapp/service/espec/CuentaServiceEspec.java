package pe.egcc.eurekaapp.service.espec;

import java.util.Map;

/**
 *
 * @author Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 */
public interface CuentaServiceEspec {
  
  double getSaldoCuenta(String cuenta);
  
  Map<String,Double> getSaldoSucursal(String codSucursal);
    
}
