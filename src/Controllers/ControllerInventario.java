package Controllers;
import Views.*;
import Model.*;
import Struct.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class ControllerInventario implements ActionListener
{
    DefaultTableModel mode;
    private VistaInventario objVistaInventario;
    private VistaPrincipal  objVistaPrincipal;
    private MySQLconnection conexion;
    Statement st;
    ResultSet rt;
    
    ComandosInventario objComandosInventario;
    
    
    public ControllerInventario(VistaInventario objVistaInventario, VistaPrincipal objVistaPrincipal, MySQLconnection conexion) {
        this.objVistaInventario = objVistaInventario;
        this.objVistaPrincipal = objVistaPrincipal;
        this.conexion = conexion;
        objComandosInventario=new ComandosInventario();
        
    }
    
    public void inicializaComponentesInventario() throws SQLException{
        
            objVistaInventario.jButtonCerrar.addActionListener(this);
            objVistaInventario.BTNBUSCAR.addActionListener(this);
            cargarTabla();
        
    }
    
    /*------------------------------------------------------------------------*/             
    public void methodRefreshDatabase() throws SQLException{
    /*------------------------------------------------------------------------*/             
        conexion.desconectar();
        conexion.conectar();
    }
    private void cargarTabla() throws SQLException {
        try {
        String sql="";
        sql=objComandosInventario.mostrarTodosLosPanes();
        st = conexion.getConnection().createStatement();
        rt = st.executeQuery(sql);
        while (rt.next()) {
            Object[] datos = {
                rt.getInt("idI"),
                rt.getInt("idP"),
                rt.getString("existencia"),
                rt.getString("fecha")
            };
            mode.addRow(datos);
        }
        objVistaInventario.jTable.setModel(mode);
        //conexion.desconectar();
        } catch (Exception e) {System.out.println(e);}
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
