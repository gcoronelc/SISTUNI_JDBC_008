package pe.egcc.eurekaapp.util;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 */
public final class Mensaje {

  /**
   * Constructor privado para que no se puedan crear instancias.
   */
  private Mensaje() {
  }

  public static void showInfo(Component parent, String message) {
    JOptionPane.showMessageDialog(parent, message,
            "EUREKA - Info", JOptionPane.INFORMATION_MESSAGE);
  }

  public static void showError(Component parent, String message) {
    JOptionPane.showMessageDialog(parent, message,
            "EUREKA - Error", JOptionPane.ERROR_MESSAGE);
  }

}
