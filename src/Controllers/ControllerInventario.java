package Controllers;
import Views.*;
import Model.*;
import Struct.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

public class ControllerInventario implements ActionListener
{
    private VistaInventario objVistaInventario;
    private VistaPrincipal  objVistaPrincipal;
    private MySQLconnection conexion;
    Statement st;
    ResultSet rt;
    private ClassInventario objClassInventario;
    
    
    public ControllerInventario(VistaInventario objVistaInventario, VistaPrincipal objVistaPrincipal, MySQLconnection conexion) {
        this.objVistaInventario = objVistaInventario;
        this.objVistaPrincipal = objVistaPrincipal;
        this.conexion = conexion;
    }
    
    public void inicializaComponentesInventario(){
        objVistaInventario.jButtonCerrar.addActionListener(this);
        objVistaInventario.BTNBUSCAR.addActionListener(this);
        
    }
    

    
    
    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
    /*------------------------------------------------------------------------*/                
            if (e.getActionCommand().equals("Cerrar")) {
    /*------------------------------------------------------------------------*/                
                objVistaInventario.dispose();
                objVistaPrincipal.jButtonInventario.setEnabled(true);
            }
    /*------------------------------------------------------------------------*/                
            if (e.getActionCommand().equals("Buscar")) {
    /*------------------------------------------------------------------------*/                
                
            }            
        } catch (Exception ex) {System.out.println(e);}
    }
    
    

}
