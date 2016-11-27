package pe.egcc.eurekaapp.service.spec;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 */
public interface CuentaServiceSpec {
  
  double getSaldoCuenta(String cuenta);
  
  Map<String,Double> getSaldoSucursal(String codSucursal);
  
  List<Map<String,?>> getResumen001();
  
  int procRetiro(String cuenta, double importe, String clave, String codEmp);
    
}
