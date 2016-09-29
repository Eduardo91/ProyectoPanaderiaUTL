package Controllers;
import Views.*;
import Model.*;
import Struct.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Struct.ClassPan;
import Model.ComandosPAN;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import javax.swing.table.DefaultTableModel;

public class ControllerPanes implements ActionListener, KeyListener{
    private VistaPanes      objVistaPanes;
    private VistaPrincipal  objVistaPrincipal;
    private MySQLconnection conexion;
    Statement st;
    ResultSet rt;
    String[] columnas;
    ClassPan  Pan = new ClassPan();
    ComandosPAN cmPan = new ComandosPAN();

    public ControllerPanes(VistaPanes objVistaPanes, VistaPrincipal objVistaPrincipal, MySQLconnection conexion) throws Exception {
        this.objVistaPanes = objVistaPanes;
        this.objVistaPrincipal = objVistaPrincipal;
        this.conexion = conexion;
        inicializaComponentesPanes();
        columnas = new String[] {   "idP",
                                    "Codigo Pan",
                                    "Nombre",
                                    "descripcion",
                                    "Precio Produccion",
                                    "Precio Venta"
                                };
        actualizarTablaPanes();
    }
    
      public void actualizarTablaPanes() throws Exception {
            String[][] datos = null;
            DefaultTableModel dtm = null;
            try{
            datos = cmPan.getAll();
            dtm = new DefaultTableModel(datos, columnas);
            objVistaPanes.jTablePanes.setModel(dtm);
            }
       catch (Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(objVistaPanes, "Ocurrió un error al cargar la tabla Productos.\n\nInténtelo más tarde.",
                                              "Error.", JOptionPane.ERROR_MESSAGE);
        }
                
    }
    
    
    public void inicializaComponentesPanes()throws Exception{
        
        objVistaPanes.btnCerrar.addActionListener(this);
        objVistaPanes.btnGuardar.addActionListener(this);
        objVistaPanes.btnActualizar.addActionListener(this);
        objVistaPanes.btnEliminar.addActionListener(this);
        
       objVistaPanes.jTablePanes.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e){
           PasarDatosText();
       }
           
        });
       
        
    }
    
    public void limpiarCajas(){
        objVistaPanes.txtIdPan.setText(null);
        objVistaPanes.txtCodigoPan.setText(null);
        objVistaPanes.txtNombre.setText(null);
        objVistaPanes.txtDescripcion.setText(null);
        objVistaPanes.txtPrecioProduccion.setText(null);
        objVistaPanes.txtPrecioVenta.setText(null);
        
    }
    
    private void guardarProducto() throws Exception {
       try
        {
       Pan.setCodigoPan(objVistaPanes.txtCodigoPan.getText());
       Pan.setNombre(objVistaPanes.txtNombre.getText());
       Pan.setDescripcion(objVistaPanes.txtDescripcion.getText());
       Pan.setPricep(Double.valueOf(objVistaPanes.txtPrecioProduccion.getText()));
       Pan.setPricev(Double.valueOf(objVistaPanes.txtPrecioVenta.getText()));
        
        cmPan.insertar(Pan);
        limpiarCajas();
        actualizarTablaPanes();
        }
        catch (Exception e)
            
        {
            e.printStackTrace();
            System.out.println("Error");
        }
    }
    
    
     private void eliminarPan()
    {
      
        try
        {
            Pan.setIdpan(Integer.valueOf(objVistaPanes.txtIdPan.getText()));
            cmPan.eliminarPan(Pan);
                 limpiarCajas();
                 actualizarTablaPanes();
                
        } 
        catch (Exception e)
        {
            System.out.println("Error al eliminar");
        }
    }
     
      
    private void actualizarPan()
    {
        try
        {
       Pan.setIdpan(Integer.valueOf(objVistaPanes.txtIdPan.getText()));
       Pan.setCodigoPan(objVistaPanes.txtCodigoPan.getText());
       Pan.setNombre(objVistaPanes.txtNombre.getText());
       Pan.setDescripcion(objVistaPanes.txtDescripcion.getText());
       Pan.setPricep(Double.valueOf(objVistaPanes.txtPrecioProduccion.getText()));
       Pan.setPricev(Double.valueOf(objVistaPanes.txtPrecioVenta.getText()));
           
           
                cmPan.actualizar(Pan);
               limpiarCajas();
                 actualizarTablaPanes();
                
            
                       
        } 
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Errror al Actualizar");
        }
    }
    
    
     private void BuscarPan()
    {
        String[][] datos = null;
        DefaultTableModel dtm = null;
        try
        {
            String valor = objVistaPanes.txtIdPan.getText();
            datos = cmPan.buscar(valor);
            dtm = new DefaultTableModel(datos, columnas);
            objVistaPanes.jTablePanes.setModel(dtm);
           
        } 
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Error al buscar");
        }
    }
    
     
     public void PasarDatosText(){
      int fila = objVistaPanes.jTablePanes.getSelectedRow();
      int id =Integer.valueOf(objVistaPanes.jTablePanes.getValueAt(fila, 0).toString());
      String codigo = objVistaPanes.jTablePanes.getValueAt(fila, 1).toString();
      String nombre = objVistaPanes.jTablePanes.getValueAt(fila, 2).toString();
      String Descripcion = objVistaPanes.jTablePanes.getValueAt(fila, 3).toString();
      String precioP= objVistaPanes.jTablePanes.getValueAt(fila, 4).toString();
      String precioV = objVistaPanes.jTablePanes.getValueAt(fila,5).toString();
      
      
      objVistaPanes.txtIdPan.setText(Integer.toString(id));
      objVistaPanes.txtCodigoPan.setText(codigo);
      objVistaPanes.txtNombre.setText(nombre);
      objVistaPanes.txtDescripcion.setText(Descripcion);
      objVistaPanes.txtPrecioProduccion.setText(precioP);
      objVistaPanes.txtPrecioVenta.setText(precioV);
            
    }
     
     
     
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
    /*------------------------------------------------------------------------*/                
            if (e.getActionCommand().equals("Cerrar")) {
    /*------------------------------------------------------------------------*/                
                objVistaPanes.dispose();
                objVistaPrincipal.jButtonPanes.setEnabled(true);
            }
            
            
    /*------------------------------------------------------------------------*/                
            if (e.getActionCommand().equals("Guardar")) {
    /*------------------------------------------------------------------------*/                
                guardarProducto();
            }
          
    /*------------------------------------------------------------------------*/                
            if (e.getActionCommand().equals("Eliminar")) {
    /*------------------------------------------------------------------------*/                
                eliminarPan();
            }
     /*------------------------------------------------------------------------*/                
            if (e.getActionCommand().equals("Actualizar")) {
    /*------------------------------------------------------------------------*/                
               actualizarPan();
            }         
   /*------------------------------------------------------------------------*/                
            if (e.getActionCommand().equals("Buscar")) {
    /*------------------------------------------------------------------------*/                
               BuscarPan();
            }
            
        } catch (Exception ex) {System.out.println(e);}
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    
}
