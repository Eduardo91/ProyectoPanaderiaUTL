package Controllers;
import Views.*;
import Model.*;
import Struct.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
public class ControllerReporte implements ActionListener{
    private VistaReporte    objvisReporte;
    private VistaPrincipal  objVistaPrincipal;
    private MySQLconnection conexion;
    Statement st;
    ResultSet rt;
    private ClassReporte    objClassReporte;

    public ControllerReporte(VistaReporte objvisReporte, VistaPrincipal objVistaPrincipal, MySQLconnection conexion) {
        this.objvisReporte = objvisReporte;
        this.objVistaPrincipal = objVistaPrincipal;
        this.conexion = conexion;
    }
    public void inicializaComponentesReporte(){
        objvisReporte.jButtonCerrar.addActionListener(this);
    }

    
    
    
    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
    /*------------------------------------------------------------------------*/                
            if (e.getActionCommand().equals("Cerrar")) {
    /*------------------------------------------------------------------------*/                
                objvisReporte.dispose();
                objVistaPrincipal.jButtonReporte.setEnabled(true);
            }
        } catch (Exception ex) {System.out.println(e);}
    }
    
}
