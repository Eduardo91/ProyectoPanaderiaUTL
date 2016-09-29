package Controllers;
import Views.*;
import Model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.Timer;



public class ControllerPrincipal implements ActionListener
{
    private VistaPrincipal  objVistPrincipal;
    private VistaInventario objVistaInventario;
    private VistaPanes      objVistaPanes;
    private VistaReporte    objVistaReporte;
    private VistaVentas     objVistaVentas;
    private ComandosPAN     comP;
    private Statement       st;
    private ResultSet       rt;
    MySQLconnection conexion;
    private ControllerInventario        objControllerInverntario;
    private ControllerPanes             objControllerPanes;
    private ControllerVentas            objControllerVentas;
    private ControllerReporte           objControllerReporte;
    Timer clock;

    public ControllerPrincipal(VistaPrincipal objVistPrincipal, MySQLconnection conexion) {
        this.objVistPrincipal = objVistPrincipal;        
        this.conexion = conexion;
        
        clock = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                bot(ae);
            }
        });
        clock.start();
    }
    /*________________________________________________________________________*/
    public void inicializarComponentesVistaPrincipal(){
    /*________________________________________________________________________*/        
        objVistPrincipal.jButtonInventario.addActionListener(this);
        objVistPrincipal.jButtonPanes.addActionListener(this);
        objVistPrincipal.jButtonVentas.addActionListener(this);
        objVistPrincipal.jButtonReporte.addActionListener(this);
    }    
    /*________________________________________________________________________*/        
    public void methodRefreshDatabase() throws SQLException {
    /*________________________________________________________________________*/                
        conexion.desconectar();
        conexion.conectar();
    }
    
   

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
    /*------------------------------------------------------------------------*/                
            if (e.getActionCommand().equals("Inventario")) {
    /*------------------------------------------------------------------------*/                
                objVistaInventario=new VistaInventario();
                objControllerInverntario=new ControllerInventario(objVistaInventario, objVistPrincipal, conexion);
                objControllerInverntario.inicializaComponentesInventario();
                objVistPrincipal.jDesktopPane1.add(objVistaInventario);
                objVistaInventario.setVisible(true);
                objVistaInventario.setLocation(280,80);
                objVistaInventario.setTitle("Gestion de Inventario");
                objVistPrincipal.jButtonInventario.setEnabled(false);
            }
    /*------------------------------------------------------------------------*/                
            if (e.getActionCommand().equals("Panes")) {
    /*------------------------------------------------------------------------*/                
                methodRefreshDatabase();
                objVistaPanes=new VistaPanes();
                objControllerPanes=new ControllerPanes(objVistaPanes, objVistPrincipal, conexion);
                objControllerPanes.inicializaComponentesPanes();
                objVistPrincipal.jDesktopPane1.add(objVistaPanes);
                objVistaPanes.setVisible(true);
                objVistaPanes.setLocation(280,80);
                objVistaPanes.setTitle("Gestion de panes");
                objVistaPanes.setMaximizable(true);
                objVistPrincipal.jButtonPanes.setEnabled(false);
            } 
    /*------------------------------------------------------------------------*/                
            if (e.getActionCommand().equals("Ventas")) {
    /*------------------------------------------------------------------------*/                
                methodRefreshDatabase();
                objVistaVentas=new VistaVentas();
                objControllerVentas=new ControllerVentas(objVistaVentas, objVistPrincipal, conexion);
                objControllerVentas.inicializaComponentesVentas();
                objVistPrincipal.jDesktopPane1.add(objVistaVentas);
                objVistaVentas.setVisible(true);
                objVistaVentas.setLocation(0,100);
                objVistaVentas.setResizable(true);
                objVistaVentas.setTitle("Punto de venta");
                objVistaVentas.setMaximizable(true);
                objVistaVentas.jTextFieldCodigoBarras.requestFocus();
                objVistPrincipal.jButtonVentas.setEnabled(false);
            } 
    /*------------------------------------------------------------------------*/                
            if (e.getActionCommand().equals("Reporte")) {
    /*------------------------------------------------------------------------*/                
                objVistaReporte=new VistaReporte();
                objControllerReporte=new ControllerReporte(objVistaReporte, objVistPrincipal, conexion);
                objControllerReporte.inicializaComponentesReporte();
                objVistPrincipal.jDesktopPane1.add(objVistaReporte);
                objVistaReporte.setVisible(true);
                objVistaReporte.setLocation(280,80);
                objVistaReporte.setTitle("Grafica de reporte");
                objVistPrincipal.jButtonReporte.setEnabled(false);
            } 
        } catch (Exception ex) {System.out.println("Ocurrio un error en controlador principal\n"+e);}
    }//FinActonPerformed
    
public void bot(ActionEvent ae) {
        java.util.Date d = new java.util.Date();
        String formatHour = "hh:mm";
        String formatDate = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(formatDate);
        SimpleDateFormat sdf2 = new SimpleDateFormat(formatHour);
        objVistPrincipal.jLabelFecha.setText(sdf.format(d));
        objVistPrincipal.jLabelHora.setText(" "+sdf2.format(d));
    }
    
}
