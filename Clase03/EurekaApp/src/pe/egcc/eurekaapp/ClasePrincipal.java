package pe.egcc.eurekaapp;

import pe.egcc.eurekaapp.view.LogonView;

/**
 *
 * @author Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 */
public class ClasePrincipal {

  public static void main(String[] args) {
    LogonView.main(args);
    /*
    // You should work with UI (including installing L&F) inside Event Dispatch Thread (EDT)
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        // Install WebLaF as application L&F
        WebLookAndFeel.install();

        // Create you Swing application here
        
        LogonView view = new LogonView(null, true);
        view.setVisible(true);
      }
    });*/

  }

}
