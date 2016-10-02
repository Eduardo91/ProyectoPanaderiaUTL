package Controllers;
/**
 *
 * @author Eduardo
 */
import Model.ComandosLogin;
import Struct.ClassUsuario;
import Model.MySQLconnection;
import Views.VistaLogin;
import Views.VistaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ControllerLogin implements ActionListener, KeyListener{
    MySQLconnection conexion;
    ComandosLogin objComandosLogin;
    VistaLogin objVistaLogin;
    Statement st;
    ResultSet rt;
    ClassUsuario objClassUsuario;
    VistaPrincipal objVistaPrincipal;    

    public ControllerLogin(MySQLconnection conexion, ComandosLogin objComandosLogin, VistaLogin objVistaLogin) {
        this.conexion = conexion;
        this.objComandosLogin = objComandosLogin;
        this.objVistaLogin = objVistaLogin;
        objVistaPrincipal=new VistaPrincipal();
    }

    
/*----------------------------------------------------------------------------*/    
    public void iniciaComponentesViewLogin() {
/*----------------------------------------------------------------------------*/            
        objVistaLogin.jTextFieldUser.addKeyListener(this);
        objVistaLogin.jTextFieldPassword.addKeyListener(this);
        objVistaLogin.jButtonEntrar.addActionListener(this);
        objVistaLogin.jLabelMensajeFondo.setVisible(false);
        objVistaLogin.jLabelMensaje.setVisible(false);
    }
    public void bienvenidaInicioSesion(String nombre) 
    {
        objVistaPrincipal.jLabelUsuario.setText("   "+"Usuario: "+" "+nombre);
    }
    
    
    
/*============================================================================*/
    @Override
    public void actionPerformed(ActionEvent ae) {
/*============================================================================*/        
        try {
            if (ae.getActionCommand().equals("Entrar")) {
                try {
                    objClassUsuario = new ClassUsuario();
                    objClassUsuario.setUser(objVistaLogin.jTextFieldUser.getText());
                    objClassUsuario.setPassword(objVistaLogin.jTextFieldPassword.getText());
                    conexion.conectar();
                    st = conexion.getConnection().createStatement();
                    rt = st.executeQuery(objComandosLogin.validarUsuario(objClassUsuario));
                    rt.next();
                    if (rt.getString(2)!=null) {
                        ControllerPrincipal cp=new ControllerPrincipal(objVistaPrincipal, conexion);
                        cp.inicializarComponentesVistaPrincipal();
                        objVistaLogin.setVisible(false);
                        objVistaPrincipal.setVisible(true);
                        bienvenidaInicioSesion(rt.getString(2));
                    }
                } catch (SQLException e) {
                    objVistaLogin.jLabelMensajeFondo.setVisible(true);
                    objVistaLogin.jLabelMensaje.setVisible(true);
                    objVistaLogin.jLabelMensaje.setText("Error de validación");
                }
            }          
        } catch (Exception e) {
                    objVistaLogin.jLabelMensajeFondo.setVisible(true);
                    objVistaLogin.jLabelMensaje.setVisible(true);
                    objVistaLogin.jLabelMensaje.setText("Error de conexion");
        }
    }//fin de action performed

    /*============================================================================*/    
    @Override
    public void keyTyped(KeyEvent e) {
    /*============================================================================*/            
        try {
  
        } catch (Exception ekt) {System.out.println("Error en KeyTyped\n"+ekt);}
    }//fin de keytyped

    /*============================================================================*/                
    @Override
    public void keyPressed(KeyEvent e) {
    /*============================================================================*/                    
        try {
            if (e.getSource()==objVistaLogin.jTextFieldUser) {
                if (KeyEvent.VK_ENTER == e.getKeyCode()) 
                {
                    objVistaLogin.jTextFieldPassword.requestFocus();
                }
            }
        /*--------------------------------------------------------------------*/            
            if (e.getSource()==objVistaLogin.jTextFieldPassword) {
                if (KeyEvent.VK_ENTER == e.getKeyCode()) 
                {
                    objVistaLogin.jButtonEntrar.doClick();
                }
            }
        } catch (Exception ekp) {System.out.println("Error en keypressed\n"+ekp);}
    }//fin de keyPressed
    /*============================================================================*/                    
    @Override
    public void keyReleased(KeyEvent e) {
    /*============================================================================*/                            
        try {
            
        } catch (Exception ekr) {System.out.println("Error en keyreleased"+ekr);}
    }//fin de keyReleased
    
    
    
}
