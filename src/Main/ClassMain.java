package Main;

/**
 *
 * @author Eduardo
 */
import Controllers.ControllerPrincipal;
import Controllers.ControllerLogin;
import Model.ComandosPAN;
import Model.ComandosLogin;
import Model.MySQLconnection;
import Views.VistaPrincipal;
import Views.VistaLogin;
import de.javasoft.plaf.synthetica.SyntheticaBlueSteelLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaClassyLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaOrangeMetallicLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaSimple2DLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaWhiteVisionLookAndFeel;
import javax.swing.UIManager;

public class ClassMain {

    public static void main(String[] args) {
        try {
            //UIManager.setLookAndFeel(new SyntheticaClassyLookAndFeel());
            //UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel");
            UIManager.setLookAndFeel(new SyntheticaOrangeMetallicLookAndFeel());            
            //UIManager.setLookAndFeel(new SyntheticaSimple2DLookAndFeel());
            //UIManager.setLookAndFeel(new SyntheticaWhiteVisionLookAndFeel());
            //UIManager.setLookAndFeel(new SyntheticaBlueSteelLookAndFeel());
            //VistaPrincipal vp = new VistaPrincipal();
            VistaLogin vl=new VistaLogin();
            MySQLconnection con = new MySQLconnection();
            ComandosLogin coml=new ComandosLogin();
            //ComandosPAN comPan = new ComandosPAN();
            //ControllerPrincipal ctrlP = new ControllerPrincipal(vp, con);
            ControllerLogin ctrlL=new ControllerLogin(con, coml, vl);
            ctrlL.iniciaComponentesViewLogin();
            vl.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
