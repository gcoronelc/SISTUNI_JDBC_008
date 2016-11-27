package pe.egcc.eurekaapp.prueba;

import java.sql.Connection;
import java.util.Map;
import javax.swing.JOptionPane;
import pe.egcc.eurekaapp.service.spec.CuentaServiceSpec;
import pe.egcc.eurekaapp.service.impl.CuentaServiceImpl;

/**
 *
 * @author Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 */
public class Prueba02 {
  
  public static void main(String[] args) {
    Connection cn = null;
    try {
      // Dato
      String codSucursal;
      codSucursal = JOptionPane.showInputDialog(
              "Ingreso codigo de sucursal");
      // Proceso
      CuentaServiceSpec service = new CuentaServiceImpl();
      Map<String,Double> rec = service.getSaldoSucursal(codSucursal);
      // Resultado
      System.out.println("Saldo Soles: " + rec.get("soles"));
      System.out.println("Saldo Dolares: " + rec.get("dolares"));
    } catch (Exception e) {
      System.err.println(e.getMessage());
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
  }
}
