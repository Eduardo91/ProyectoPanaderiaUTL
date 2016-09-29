package Main;
/**
 *
 * @author Eduardo
 */
import Controllers.ControllerPrincipal;
import Model.ComandosPAN;
import Model.MySQLconnection;
import Views.VistaPrincipal;
import javax.swing.UIManager;
public class ClassMain {

    public static void main(String[] args) 
    {
        try {
            UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel");
        } catch (Exception e) {
        e.printStackTrace();
        }
            VistaPrincipal vp=new VistaPrincipal();
            MySQLconnection con=new MySQLconnection();
            ComandosPAN comPan=new ComandosPAN();
            ControllerPrincipal ctrlP=new ControllerPrincipal(vp, con);
            ctrlP.inicializarComponentesVistaPrincipal();
            vp.setVisible(true);
    }
    
}
