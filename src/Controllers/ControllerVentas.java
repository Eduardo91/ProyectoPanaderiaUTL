package Controllers;
import Views.*;
import Model.*;
import Struct.*;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Toolkit;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import Atxy2k.CustomTextField.RestrictedTextField;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JFrame;
import java.util.Base64;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ControllerVentas implements ActionListener, KeyListener, FocusListener
{
    VistaVentas     objVistaVentas;
    VistaPrincipal  objVistaPrincipal;
    MySQLconnection conexion;
    Statement st;
    ResultSet rt;
    DefaultTableModel mode;
    TableColumn      agregarcolumna;
    ClassVentas      objClassVentas;
    ClassInventario objClassInventario;
    ClassPan        objClassPan;
    ComandosPAN     objComandosPAN;
    ComandosVentas  objComandosVentas;
    ComandosInventario objComandosInventario;
    private Font fuenteBold=new Font(Font.FontFamily.COURIER, 3, Font.BOLD);
    private Font fuenteDatos=new Font(Font.FontFamily.COURIER, 3, Font.NORMAL,BaseColor.WHITE);
    private Font fuenteidVenta=new Font(Font.FontFamily.COURIER, 3, Font.NORMAL,BaseColor.RED);
    private Font fuenteNormal=new Font(Font.FontFamily.COURIER, 3, Font.NORMAL);
    private Font fuenteItalic=new Font(Font.FontFamily.COURIER, 3, Font.BOLD);
    
    public ControllerVentas(VistaVentas objVistaVentas, VistaPrincipal objVistaPrincipal, MySQLconnection conexion) {
        this.objVistaVentas = objVistaVentas;
        this.objVistaPrincipal = objVistaPrincipal;
        this.conexion = conexion;
        objClassVentas=new ClassVentas();
        objClassPan=new ClassPan();
        objClassInventario=new ClassInventario();
        objComandosPAN=new ComandosPAN();
        objComandosVentas=new ComandosVentas();
        objComandosInventario=new ComandosInventario();
    }
    /*------------------------------------------------------------------------*/        
    public void inicializaComponentesVentas(){
    /*------------------------------------------------------------------------*/        
        mostrarUltimaVenta();        
        objVistaVentas.jButtonCerrar.addActionListener(this);
        objVistaVentas.jButtonAgregar.addActionListener(this);
        objVistaVentas.jButtonConfirmar.addActionListener(this);
        objVistaVentas.jButtonQuitar.addActionListener(this);
        objVistaVentas.jTextFieldCodigoBarras.addKeyListener(this);
        objVistaVentas.jTextFieldCantidadProducto.addKeyListener(this);
        objVistaVentas.jTextFieldPrecioProducto.addKeyListener(this);
        mode = (DefaultTableModel) objVistaVentas.jTable.getModel();
        agregarcolumna = objVistaVentas.jTable.getColumnModel().getColumn(0);
        agregarcolumna.setPreferredWidth(10);
        agregarcolumna = objVistaVentas.jTable.getColumnModel().getColumn(2);
        agregarcolumna.setPreferredWidth(10);
        agregarcolumna = objVistaVentas.jTable.getColumnModel().getColumn(1);
        agregarcolumna.setPreferredWidth(150);
        objVistaVentas.jTable.setRowHeight(32);  
        objVistaVentas.jTextFieldCantidadProducto.setText("1");
        objVistaVentas.jTextFieldSumaCantidadPorPrecio.setEnabled(false);
        objVistaVentas.jButtonAgregar.setEnabled(false);
        objVistaVentas.jButtonConfirmar.setEnabled(false);
        objVistaVentas.jTextFieldCodigoBarras.requestFocus();
        RestrictedTextField limitTeCodigoBarras = new RestrictedTextField(objVistaVentas.jTextFieldCodigoBarras);
        limitTeCodigoBarras.setLimit(8);
        RestrictedTextField limiteCantidadProducto = new RestrictedTextField(objVistaVentas.jTextFieldCantidadProducto);
        limiteCantidadProducto.setLimit(3);
        RestrictedTextField limitePrecio = new RestrictedTextField(objVistaVentas.jTextFieldPrecioProducto);
        limitePrecio.setLimit(4);
        RestrictedTextField limiteMultiplicacion = new RestrictedTextField(objVistaVentas.jTextFieldSumaCantidadPorPrecio);
        limiteMultiplicacion.setLimit(5);
        objVistaVentas.addFocusListener(this);
        objVistaVentas.addKeyListener(this);
        objVistaVentas.jTextFieldCodigoBarras.addFocusListener(this);
        objVistaVentas.jTextFieldPrecioProducto.setEnabled(false);   
        objVistaVentas.jTable.addKeyListener(this);
        objVistaVentas.jTable.addFocusListener(this);
    }
    /*------------------------------------------------------------------------*/        
        public void insertarVenta(){
    /*------------------------------------------------------------------------*/        
        try {
            String sqli="";
            objClassVentas=new ClassVentas();
            
            objClassVentas.setFecha(objVistaPrincipal.jLabelFecha.getText());
            objClassVentas.setTotal(Double.parseDouble(objVistaVentas.jLabelTotal.getText()));
            sqli=objComandosVentas.insertarVenta(objClassVentas);
            conexion.conectar();
            st = conexion.getConnection().createStatement();
            st.executeUpdate(sqli);
            objVistaVentas.jLabelMensaje.setForeground(Color.GREEN);
            objVistaVentas.jLabelMensaje.setText("¡Venta registrada con exito!");
        } catch (Exception e) {System.out.println("Error al registar venta"+e);}
    }
    /*------------------------------------------------------------------------*/        
    public void insertDetalleVenta(){
    /*------------------------------------------------------------------------*/        
        try {
            int numFilas=objVistaVentas.jTable.getRowCount();
            int Con=0;
            for (int i = 0; i <numFilas; i++) 
                {
                    String sqli="";
                    objClassVentas=new ClassVentas();
                    objClassVentas.setFolio(Integer.parseInt(objVistaVentas.jLabelIdVenta.getText()));
                    objClassVentas.setIdP(Integer.parseInt(objVistaVentas.jTable.getValueAt(i, 0).toString()));
                    objClassVentas.setCantidad(Integer.parseInt(objVistaVentas.jTable.getValueAt(i, 2).toString()));
                    objClassVentas.setImporte(Double.parseDouble(objVistaVentas.jTable.getValueAt(i, 3).toString()));
                    objClassVentas.setTotal(Double.parseDouble(objVistaVentas.jTable.getValueAt(i, 4).toString()));            
                    sqli=objComandosVentas.insertarDetalleVenta(objClassVentas);
                    conexion.conectar();
                    st = conexion.getConnection().createStatement();
                    st.executeUpdate(sqli);
                }
        } catch (Exception e) {System.out.println("Error al registar Detalleventa"+e);}
    }
    /*------------------------------------------------------------------------*/        
    public void mostrarUltimaVenta(){
    /*------------------------------------------------------------------------*/        
        try {            
            ResultSet rem;
            String sql="";    
            
            sql=objComandosVentas.ultimaVentaGenerada();
            conexion.conectar();
            st = conexion.getConnection().createStatement();
            rem = st.executeQuery(sql);         
            while (rem.next()) 
                {
                  objVistaVentas.jLabelIdVenta.setText(String.valueOf(rem.getInt(1)+1));
                    
                }   
            } catch (Exception e) {System.out.println("Error al mostar la ultima venta\n"+e);} 
    }
    /*------------------------------------------------------------------------*/        
    public void insertarElementosAtabla(){
    /*------------------------------------------------------------------------*/         
        try {
            String [] dato=new String[5];
            dato[0]=objVistaVentas.jTextFieldIdPan.getText();
            dato[1]=objVistaVentas.jTextFieldNombreProducto.getText();
            dato[2]=objVistaVentas.jTextFieldCantidadProducto.getText();
            dato[3]=objVistaVentas.jTextFieldPrecioProducto.getText();
            dato[4]=objVistaVentas.jTextFieldSumaCantidadPorPrecio.getText();
            mode.addRow(dato);
            objVistaVentas.jTextFieldCodigoBarras.setText(null);
            objVistaVentas.jTextFieldCantidadProducto.setText(null);
            objVistaVentas.jTextFieldPrecioProducto.setText(null);
            objVistaVentas.jTextFieldNombreProducto.setText(null);
            objVistaVentas.jTextFieldSumaCantidadPorPrecio.setText(null); 
            objVistaVentas.jTextFieldIdPan.setText(null);
            objVistaVentas.jLabelMensaje.setText(null);
            objVistaVentas.jTextFieldCodigoBarras.requestFocus();
            objVistaVentas.jTextFieldCantidadProducto.setText("1");
        } catch (Exception e) {System.out.println("Error al inserat elementos a la tabla\n"+e);}
    }
    /*------------------------------------------------------------------------*/         
    public void obtenerIdPan(){
    /*------------------------------------------------------------------------*/             
        try {            
            objClassPan= new ClassPan();
            objClassPan.setCodigoPan(objVistaVentas.jTextFieldCodigoBarras.getText());
            String sqlObtenerId= objComandosPAN.obtenerIdPan(objClassPan);
            conexion.conectar();
            st = conexion.getConnection().createStatement();
            rt = st.executeQuery(sqlObtenerId);            
            while (rt.next()) 
                {
                    objVistaVentas.jTextFieldIdPan.setText(String.valueOf(rt.getInt(1)));
                }   
        } catch (Exception e) {System.out.println("Error al obtener IDPAN\n"+e);}
    }
    /*------------------------------------------------------------------------*/             
    public void obtenerNombrePan(){
    /*------------------------------------------------------------------------*/             
        try {            
            objClassPan= new ClassPan();
            objClassPan.setCodigoPan(objVistaVentas.jTextFieldCodigoBarras.getText());
            String sqlObtenerId= objComandosPAN.obtenerNombrePan(objClassPan);
            conexion.conectar();
            st = conexion.getConnection().createStatement();
            rt = st.executeQuery(sqlObtenerId);            
            while (rt.next()) 
                {
                    objVistaVentas.jTextFieldNombreProducto.setText(rt.getString(1));
                }   
        } catch (Exception e) {System.out.println("Error al obtener nombre del pan\n"+e);}
    }
    /*------------------------------------------------------------------------*/             
    public void obtenerPrecioVentaPan(){
    /*------------------------------------------------------------------------*/             
        try {            
            objClassPan= new ClassPan();
            objClassPan.setCodigoPan(objVistaVentas.jTextFieldCodigoBarras.getText());
            String sqlObtenerId= objComandosPAN.obtenerPrecioVentaPan(objClassPan);
            conexion.conectar();
            st = conexion.getConnection().createStatement();
            rt = st.executeQuery(sqlObtenerId);            
            while (rt.next()) 
                {
                    objVistaVentas.jTextFieldPrecioProducto.setText(rt.getString(1));
                }   
        } catch (Exception e) {System.out.println("Error al obtener precio de venta del pan\n"+e);}
    }
    /*------------------------------------------------------------------------*/             
    public void methodRefreshDatabase() throws SQLException{
    /*------------------------------------------------------------------------*/             
        conexion.desconectar();
        conexion.conectar();
    }
    /*------------------------------------------------------------------------*/             
    public void sumarTotalesDeTabla(){
    /*------------------------------------------------------------------------*/             
        objVistaVentas.jLabelTotal.setText("0");
        int numColumnas=objVistaVentas.jTable.getRowCount();
        int Cont=0;
        do 
            try {
                int Filas=Cont++;
                double n1=Double.parseDouble(objVistaVentas.jTable.getValueAt(Filas, 4).toString());
                String nu=objVistaVentas.jLabelTotal.getText();
                double nu2=Double.parseDouble(nu);
                double re= n1+nu2;
                objVistaVentas.jLabelTotal.setText(String.valueOf(re));
                } catch (Exception e) {System.out.println("Error al sumar totales de tabla\n"+e);}
        while (Cont<numColumnas);
    }
    /*------------------------------------------------------------------------*/             
    public void removerFila(){
    /*------------------------------------------------------------------------*/             
        int filaSeleccionada;
        int respuesta;
        try {
            filaSeleccionada=objVistaVentas.jTable.getSelectedRow();
            if (filaSeleccionada==-1) 
            {
             objVistaVentas.jLabelMensaje.setForeground(Color.orange);
             objVistaVentas.jLabelMensaje.setText("Debe seleccionar un producto de la tabla");
            }else{
                respuesta=JOptionPane.showConfirmDialog(null,"¿Esta seguro de eliminar este producto?","Eliminar",JOptionPane.YES_NO_OPTION);
                if (respuesta==JOptionPane.YES_OPTION) 
                    {
                        mode.removeRow(filaSeleccionada);
                        objVistaVentas.jLabelMensaje.setText(null);
                    }
                }
            } catch (Exception e) {System.out.println("Error al eliminar producto de la tabla\n"+e);}
    }
    /*------------------------------------------------------------------------*/             
    public void multiplicarCantidadPorPrecio(){
    /*------------------------------------------------------------------------*/                     
        try {
            String cs=objVistaVentas.jTextFieldCantidadProducto.getText();
            String ps=objVistaVentas.jTextFieldPrecioProducto.getText();
            double cd=Double.parseDouble(cs);
            double pd=Double.parseDouble(ps);
            double importe=cd*pd;
            objVistaVentas.jTextFieldSumaCantidadPorPrecio.setText(String.valueOf(importe));
        } catch (Exception e) {System.out.println("Error al multiplicar\n"+e);}
    }
    /*------------------------------------------------------------------------*/                     
    public void comprovarExistenciaDePanesEnInventario(int cant){
    /*------------------------------------------------------------------------*/                     
    try {
            String sqlc = "";    
            objClassInventario=new ClassInventario();
            objClassInventario.setIdP(Integer.parseInt(objVistaVentas.jTextFieldIdPan.getText()));
            sqlc= objComandosInventario.comprovarexistenciaPaquete(objClassInventario);
            conexion.conectar();
            st = conexion.getConnection().createStatement();
            rt = st.executeQuery(sqlc);
            rt.next();
            if (rt.getInt(1)>cant) 
                {
                    objVistaVentas.jLabelMensaje.setForeground(Color.green);
                    objVistaVentas.jLabelMensaje.setText("¡Puede vender este producto!");
                    objVistaVentas.jButtonAgregar.setEnabled(true);
                }else{
                    objVistaVentas.jLabelMensaje.setForeground(Color.red);
                    objVistaVentas.jLabelMensaje.setText("¡No existe producto suficiente!");
                    objVistaVentas.jButtonAgregar.setEnabled(false);
            }
    } catch (Exception e) {System.out.println("Error al comprovar existencia de producto en el inventario\n"+e);}
}
    /*------------------------------------------------------------------------*/                     
    public void comprobarExistenciaPan(){
    /*------------------------------------------------------------------------*/                     
    try {
            String sql = "";    
            objClassPan=new ClassPan();
            objClassPan.setCodigoPan(objVistaVentas.jTextFieldCodigoBarras.getText());
            sql= objComandosPAN.comprovarExistenciaPan(objClassPan);
            conexion.conectar();
            st = conexion.getConnection().createStatement();
            rt = st.executeQuery(sql);
            if (!rt.next()) 
                { 
                    objVistaVentas.jLabelMensaje.setForeground(Color.red);
                    objVistaVentas.jLabelMensaje.setText("¡Producto no registrado!");
                    objVistaVentas.jTextFieldNombreProducto.setText(null);
                    objVistaVentas.jButtonAgregar.setEnabled(false);
                    objVistaVentas.jTextFieldIdPan.setText(null);
                }else{
                    objVistaVentas.jLabelMensaje.setForeground(Color.green);
                    objVistaVentas.jLabelMensaje.setText("Ingrese la informacion");
                    objVistaVentas.jButtonAgregar.setEnabled(true);
            }

    } catch (Exception e) {System.out.println("Error al comprovar existencia de pan\n "+e);}    
}
    /*------------------------------------------------------------------------*/                     
    public void limpiartabla() {
    /*------------------------------------------------------------------------*/                     
        int filas = mode.getRowCount();
        if (filas >= 0) {
            for (int i = 0; i < objVistaVentas.jTable.getRowCount(); i++) {
                mode.removeRow(i);
                i -= 1;
            }
        }
    }
    /*------------------------------------------------------------------------*/                     
    public void limpiartodo(){
    /*------------------------------------------------------------------------*/                     
            objVistaVentas.jTextFieldCodigoBarras.setText(null);
            objVistaVentas.jTextFieldCantidadProducto.setText(null);
            objVistaVentas.jTextFieldPrecioProducto.setText(null);
            objVistaVentas.jTextFieldNombreProducto.setText(null);
            objVistaVentas.jTextFieldSumaCantidadPorPrecio.setText(null); 
            objVistaVentas.jTextFieldIdPan.setText(null);
            objVistaVentas.jLabelMensaje.setText(null);
            objVistaVentas.jLabelIdVenta.setText(null);
            objVistaVentas.jTextFieldCodigoBarras.requestFocus();
}
    /*============================================================================*/
    public void generarPdf(String idVenta,String fecha){
/*============================================================================*/        
        try {
            Document document=new Document(PageSize.A7,10,10,10,10);
            String ruta="C:\\Users\\Eduardo\\Documents\\NotasVenta2016\\";
            String nameFile=fecha+"_"+idVenta+"_";
            PdfWriter pd=PdfWriter.getInstance(document, new FileOutputStream(ruta+nameFile+".pdf"));            
            document.open();            
            Image ima=Image.getInstance("logo3.png");
            ima.scaleAbsolute(30, 30);
            ima.setAlignment(Element.ALIGN_CENTER);
            document.add(ima);
            /*---------------------------------------------------DATOS EMPRESA*/
            PdfPTable tablaDatosEmpresa=new PdfPTable(1);
            tablaDatosEmpresa.setWidthPercentage(40);
            tablaDatosEmpresa.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celdaDatosEmpresa;
            celdaDatosEmpresa=new PdfPCell(new Paragraph(getInfo("UNIVERSIDAD TECNOLOGICA DE LEON")));
            celdaDatosEmpresa.setBorder(0);
            celdaDatosEmpresa.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablaDatosEmpresa.addCell(celdaDatosEmpresa);
            /*----------------------------------------------TITULO DATOS VENTA*/
            PdfPTable tablaDatosVentas=new PdfPTable(2);
            tablaDatosVentas.setWidthPercentage(100);
            tablaDatosVentas.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celdaIDventa;
            PdfPCell celdafecha;
            //PdfPCell celdaNombreCliente;
            //PdfPCell celdaAtendido;
            
            celdaIDventa=new PdfPCell(new Paragraph(getDatos("ID VENTA")));
            celdafecha=new PdfPCell(new Paragraph(getDatos("FECHA")));
            //celdaNombreCliente=new PdfPCell(new Paragraph(getDatos("CLIENTE")));
            //celdaAtendido=new PdfPCell(new Paragraph(getDatos("EMPLEADO")));
            
            celdaIDventa.setHorizontalAlignment(Element.ALIGN_CENTER);
            celdafecha.setHorizontalAlignment(Element.ALIGN_CENTER);            
            //celdaNombreCliente.setHorizontalAlignment(Element.ALIGN_CENTER);
            //celdaAtendido.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            celdaIDventa.setBackgroundColor(BaseColor.DARK_GRAY);
            celdafecha.setBackgroundColor(BaseColor.DARK_GRAY);
            //celdaNombreCliente.setBackgroundColor(BaseColor.DARK_GRAY);
            //celdaAtendido.setBackgroundColor(BaseColor.DARK_GRAY);
            
            celdaIDventa.setBorderColor(BaseColor.WHITE);
            celdafecha.setBorderColor(BaseColor.WHITE);
            //celdaNombreCliente.setBorderColor(BaseColor.WHITE);
            //celdaAtendido.setBorderColor(BaseColor.WHITE);
            
            tablaDatosVentas.addCell(celdaIDventa);
            tablaDatosVentas.addCell(celdafecha);
            //tablaDatosVentas.addCell(celdaNombreCliente);
            //tablaDatosVentas.addCell(celdaAtendido);
            /*-----------------------------------------------------DATOS VENTA*/
            PdfPTable tablaDatosVentasContent=new PdfPTable(2);
            tablaDatosVentasContent.setWidthPercentage(100);
            tablaDatosVentasContent.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celdaIDventaCo;
            PdfPCell celdafechaCo;
            //PdfPCell celdaNombreClienteCo;
            //PdfPCell celdaAtendidoCo;
            celdaIDventaCo=new PdfPCell(new Paragraph(getfuenteIdv(idVenta)));
            celdafechaCo=new PdfPCell(new Paragraph(getInfo(fecha)));
            //celdaNombreClienteCo=new PdfPCell(new Paragraph(getInfo(nombreCliente)));
            //celdaAtendidoCo=new PdfPCell(new Paragraph(getInfo(idEmpleado)));
            celdaIDventaCo.setHorizontalAlignment(Element.ALIGN_CENTER);
            celdafechaCo.setHorizontalAlignment(Element.ALIGN_CENTER);            
            //celdaNombreClienteCo.setHorizontalAlignment(Element.ALIGN_CENTER);
            //celdaAtendidoCo.setHorizontalAlignment(Element.ALIGN_CENTER);
            celdaIDventaCo.setBorderColor(BaseColor.WHITE);
            celdafechaCo.setBorderColor(BaseColor.WHITE);
            //celdaNombreClienteCo.setBorderColor(BaseColor.WHITE);
            //celdaAtendidoCo.setBorderColor(BaseColor.WHITE);
            tablaDatosVentasContent.addCell(celdaIDventaCo);
            tablaDatosVentasContent.addCell(celdafechaCo);
            //tablaDatosVentasContent.addCell(celdaNombreClienteCo);
            //tablaDatosVentasContent.addCell(celdaAtendidoCo);
            /*------------------------------------------TITULO DATOS ARTICULOS*/
            PdfPTable tablaDatosArticulos=new PdfPTable(5);
            tablaDatosArticulos.setWidthPercentage(100);
            tablaDatosArticulos.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celdaIdArticulo;
            PdfPCell celdaArticulo;
            PdfPCell celdaCantidad;
            PdfPCell celdaPrecio;
            PdfPCell celdaImporte;
            celdaIdArticulo=new PdfPCell(new Paragraph(getDatos("ID")));
            celdaArticulo=new PdfPCell(new Paragraph(getDatos("ARTICULO")));
            celdaCantidad=new PdfPCell(new Paragraph(getDatos("CANTIDAD")));
            celdaPrecio=new PdfPCell(new Paragraph(getDatos("PRECIO")));
            celdaImporte=new PdfPCell(new Paragraph(getDatos("IMPORTE")));
            celdaIdArticulo.setHorizontalAlignment(Element.ALIGN_CENTER);
            celdaArticulo.setHorizontalAlignment(Element.ALIGN_CENTER);            
            celdaCantidad.setHorizontalAlignment(Element.ALIGN_CENTER);
            celdaPrecio.setHorizontalAlignment(Element.ALIGN_CENTER);
            celdaImporte.setHorizontalAlignment(Element.ALIGN_CENTER);
            celdaIdArticulo.setBackgroundColor(BaseColor.DARK_GRAY);
            celdaArticulo.setBackgroundColor(BaseColor.DARK_GRAY);
            celdaCantidad.setBackgroundColor(BaseColor.DARK_GRAY);
            celdaPrecio.setBackgroundColor(BaseColor.DARK_GRAY);
            celdaImporte.setBackgroundColor(BaseColor.DARK_GRAY);
            celdaIdArticulo.setBorderColor(BaseColor.WHITE);
            celdaArticulo.setBorderColor(BaseColor.WHITE);
            celdaCantidad.setBorderColor(BaseColor.WHITE);
            celdaPrecio.setBorderColor(BaseColor.WHITE);
            celdaImporte.setBorderColor(BaseColor.WHITE);
            tablaDatosArticulos.addCell(celdaIdArticulo);
            tablaDatosArticulos.addCell(celdaArticulo);
            tablaDatosArticulos.addCell(celdaCantidad);
            tablaDatosArticulos.addCell(celdaPrecio);
            tablaDatosArticulos.addCell(celdaImporte);
            /*-------------------------------------------------------ARTICULOS*/
            PdfPTable tablaArticulos=new PdfPTable(5);
            tablaArticulos.setWidthPercentage(100);
            tablaArticulos.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celdaIdArticuloCo;
            PdfPCell celdaArticuloCo;
            PdfPCell celdaCantidadCo;
            PdfPCell celdaPrecioCo;
            PdfPCell celdaImporteCo;
            int numFilas=objVistaVentas.jTable.getRowCount();
            int Con=0;
            for (int i = 0; i <numFilas; i++) {
                celdaIdArticuloCo=new PdfPCell(new Paragraph(getInfo(objVistaVentas.jTable.getValueAt(i, 0).toString())));
                celdaArticuloCo=new PdfPCell(new Paragraph(getInfo(objVistaVentas.jTable.getValueAt(i, 1).toString())));
                celdaCantidadCo=new PdfPCell(new Paragraph(getInfo(objVistaVentas.jTable.getValueAt(i, 2).toString())));
                celdaPrecioCo=new PdfPCell(new Paragraph(getInfo(objVistaVentas.jTable.getValueAt(i, 3).toString())));
                celdaImporteCo=new PdfPCell(new Paragraph(getInfo(objVistaVentas.jTable.getValueAt(i, 4).toString())));
                celdaIdArticuloCo.setHorizontalAlignment(Element.ALIGN_CENTER);
                celdaArticuloCo.setHorizontalAlignment(Element.ALIGN_CENTER);            
                celdaCantidadCo.setHorizontalAlignment(Element.ALIGN_CENTER);
                celdaPrecioCo.setHorizontalAlignment(Element.ALIGN_CENTER);
                celdaImporteCo.setHorizontalAlignment(Element.ALIGN_CENTER);
                celdaIdArticuloCo.setBorderColor(BaseColor.WHITE);
                celdaArticuloCo.setBorderColor(BaseColor.WHITE);
                celdaCantidadCo.setBorderColor(BaseColor.WHITE);
                celdaPrecioCo.setBorderColor(BaseColor.WHITE);
                celdaImporteCo.setBorderColor(BaseColor.WHITE);
                tablaArticulos.addCell(celdaIdArticuloCo);
                tablaArticulos.addCell(celdaArticuloCo);
                tablaArticulos.addCell(celdaCantidadCo);
                tablaArticulos.addCell(celdaPrecioCo);
                tablaArticulos.addCell(celdaImporteCo); 
                }
            /*-----------------------------------------------------TABLA TOTAL*/
            PdfPTable tablaTotal=new PdfPTable(2);
            tablaTotal.setWidthPercentage(40);
            tablaTotal.setHorizontalAlignment(Element.ALIGN_RIGHT);
            PdfPCell celdatituloTotal;
            PdfPCell celdaTotal;
            celdatituloTotal=new PdfPCell(new Paragraph(getDatos("TOTAL")));
            celdaTotal=new PdfPCell(new Paragraph(getInfo(objVistaVentas.jLabelTotal.getText())));
            celdatituloTotal.setHorizontalAlignment(Element.ALIGN_CENTER);
            celdaTotal.setHorizontalAlignment(Element.ALIGN_CENTER);            
            celdatituloTotal.setBackgroundColor(BaseColor.DARK_GRAY);
            tablaTotal.addCell(celdatituloTotal);
            tablaTotal.addCell(celdaTotal);
            /*------------------------------------------------TABLA SEPARACION*/
            PdfPTable tablaSeparacion=new PdfPTable(1);
            tablaSeparacion.setWidthPercentage(100);
            tablaSeparacion.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celdaSepara;
            celdaSepara=new PdfPCell(new Paragraph(getInfo("-------------------------------------------------------------------------------------------------------")));
            celdaSepara.setBorder(0);
            tablaSeparacion.addCell(celdaSepara);
            /*---------------------------------------------------TABLA MENSAJE*/
            PdfPTable tablaMensaje=new PdfPTable(1);
            tablaMensaje.setWidthPercentage(100);
            tablaMensaje.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celdaMensaje;
            celdaMensaje=new PdfPCell(new Paragraph(getInfo("GRACIAS POR SU COMPRA\nPANADERIA GIL AGRADECE SU PREFERENCIA")));
            celdaMensaje.setBorder(0);
            celdaMensaje.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablaMensaje.addCell(celdaMensaje);
            /*----------------------------------------------INSERSÓN DE TABLAS*/
            document.add(tablaDatosEmpresa);
            document.add(getInfo(" "));
            document.add(tablaDatosVentas);
            document.add(tablaDatosVentasContent);
            document.add(getFooter(" "));
            document.add(tablaDatosArticulos);
            document.add(tablaArticulos);
            document.add(tablaTotal);
            document.add(tablaSeparacion);
            document.add(tablaMensaje);
            document.add(tablaSeparacion);
            document.add(getbarcode(document, pd, "14002080"));
            document.close();
        } catch (Exception e) {System.out.println("Error al generar pdf"+e);}
    }
/*============================================================================*/    
    private Paragraph getTitulo(String texto){
/*============================================================================*/        
        Paragraph p=new Paragraph();
        Chunk c=new Chunk();
        p.setAlignment(Element.ALIGN_CENTER);
        c.append(texto);
        c.setFont(fuenteBold);
        p.add(c);
        return p;
    }
/*============================================================================*/    
    private Paragraph getDatos(String texto){
/*============================================================================*/        
        Paragraph p=new Paragraph();
        Chunk c=new Chunk();
        p.setAlignment(Element.ALIGN_CENTER);
        c.append(texto);
        c.setFont(fuenteDatos);
        p.add(c);
        return p;
    }
/*============================================================================*/    
    private Paragraph getfuenteIdv(String texto){
/*============================================================================*/        
        Paragraph p=new Paragraph();
        Chunk c=new Chunk();
        p.setAlignment(Element.ALIGN_CENTER);
        c.append(texto);
        c.setFont(fuenteidVenta);
        p.add(c);
        return p;
    }
/*============================================================================*/    
    private Paragraph getInfo(String texto){
/*============================================================================*/        
        Paragraph p=new Paragraph();
        Chunk c=new Chunk();
        p.setAlignment(Element.ALIGN_CENTER);
        c.append(texto);
        c.setFont(fuenteNormal);
        p.add(c);
        return p;
    }
/*============================================================================*/    
    private Paragraph getFooter(String texto){
/*============================================================================*/        
        Paragraph p=new Paragraph();
        Chunk c=new Chunk();
        p.setAlignment(Element.ALIGN_CENTER);
        c.append(texto);
        c.setFont(fuenteItalic);
        p.add(c);
        return p;
    }
/*============================================================================*/    
    private Image getbarcode(Document document, PdfWriter pw,String codigo ){
/*============================================================================*/        
        PdfContentByte cb=pw.getDirectContent();
        Barcode128 code128=new Barcode128();
        code128.setCode(formatoCodigo(codigo));
        code128.setCodeType(Barcode128.CODE128);
        code128.setTextAlignment(Element.ALIGN_CENTER);
        Image imagen=code128.createImageWithBarcode(cb, BaseColor.BLACK, BaseColor.BLACK);
        float scaler=((document.getPageSize().getWidth()-document.leftMargin()-document.rightMargin()-0/imagen.getWidth()*10));
        imagen.scalePercent(50);
        imagen.setAlignment(Element.ALIGN_CENTER);
        return imagen;
    }
    /*============================================================================*/    
    private String formatoCodigo(String num){
    /*============================================================================*/        
        NumberFormat form=new DecimalFormat("0000000");
        return form.format(num != null ? Integer.parseInt(num):0000000 );  
    }
    /*------------------------------------------------------------------------*/             
    public void obtenerImagen(String codigoPan){
    /*------------------------------------------------------------------------*/             
        try {            
            objClassPan= new ClassPan();
            objClassPan.setCodigoPan(codigoPan);
            String sqlObtenerId= objComandosPAN.obtenerImagenDePan(objClassPan);
            conexion.conectar();
            st = conexion.getConnection().createStatement();
            rt = st.executeQuery(sqlObtenerId);            
            if (!rt.next()) 
                { 
                    System.out.println("NO IMAGEN");
                    objVistaVentas.jLabelImagen.setIcon(null);
                }else{
                String Cadenabase64=rt.getString(1);
                InputStream in=null;
                byte[] imageBytes=null;
                BufferedImage bimage=null;
                imageBytes = Base64.getDecoder().decode(Cadenabase64);
                in= new ByteArrayInputStream(imageBytes);
                bimage= ImageIO.read(in);
                ImageIcon icon = new ImageIcon(bimage);  
                objVistaVentas.jLabelImagen.setIcon(icon);
                }       
                
                
               
        } catch (Exception e) {System.out.println("Error al obtener la imagen de la base de datos\n"+e);}
    }

    
    
    
    
    
    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
    /*------------------------------------------------------------------------*/                
            if (e.getActionCommand().equals("Cerrar")) {
    /*------------------------------------------------------------------------*/                
            if (JOptionPane.showConfirmDialog(new JFrame(),
                    "¿Desea cancelar la venta?","",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                    objVistaVentas.dispose();
                    objVistaPrincipal.jButtonVentas.setEnabled(true);
            }
    /*------------------------------------------------------------------------*/                
            if (e.getActionCommand().equals("Agregar")) {
    /*------------------------------------------------------------------------*/                
            if (objVistaVentas.jTextFieldCantidadProducto.getText().equals("") && objVistaVentas.jTextFieldPrecioProducto.getText().equals("")) 
                {
                    objVistaVentas.jLabelMensaje.setForeground(Color.red);
                    objVistaVentas.jLabelMensaje.setText("Debe Indicar la cant. de producto y su precio"); 
                }else if(objVistaVentas.jTextFieldPrecioProducto.getText().equals("")){   
                    objVistaVentas.jLabelMensaje.setForeground(Color.red);
                    objVistaVentas.jLabelMensaje.setText("Debe Indicar el precio del producto"); 
                }else if(objVistaVentas.jTextFieldCantidadProducto.getText().equals("")){
                    objVistaVentas.jLabelMensaje.setForeground(Color.red);
                    objVistaVentas.jLabelMensaje.setText("Debe indicar la cantidad de producto"); 
                }else if(objVistaVentas.jTextFieldCodigoBarras.getText().equals("")){
                    objVistaVentas.jLabelMensaje.setForeground(Color.red);
                    objVistaVentas.jLabelMensaje.setText("Debe indicar el codigo del producto"); 
                }else if (objVistaVentas.jTextFieldSumaCantidadPorPrecio.getText().equals("")){
                    objVistaVentas.jLabelMensaje.setForeground(Color.red);
                    objVistaVentas.jLabelMensaje.setText("Debe indicar el codigo del producto"); 
                }
                else{
                    objVistaVentas.jButtonAgregar.setEnabled(true);
                    objVistaVentas.jButtonConfirmar.setEnabled(true);
                    insertarElementosAtabla();
                    sumarTotalesDeTabla();  
                }
            }
    /*------------------------------------------------------------------------*/                
            if (e.getActionCommand().equals("Quitar")) {
    /*------------------------------------------------------------------------*/                
            removerFila();
            sumarTotalesDeTabla();
            objVistaVentas.jTextFieldCodigoBarras.requestFocus();
            int filas = mode.getRowCount();
               if (filas <= 0) 
                {
                objVistaVentas.jButtonConfirmar.setEnabled(false);
                }
            }
    /*------------------------------------------------------------------------*/                
            if (e.getActionCommand().equals("Confirmar")) {
    /*------------------------------------------------------------------------*/                
            try {
                    int respuesta = JOptionPane.showConfirmDialog(null,"CONFIRMAR VENTA", "Confirmación",JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) 
                {
                    String idventa=objVistaVentas.jLabelIdVenta.getText();
                    String fecha=objVistaPrincipal.jLabelFecha.getText();
                    insertarVenta();
                    insertDetalleVenta();
                    generarPdf(idventa, fecha);
                    objVistaVentas.jLabelTotal.setText(null);
                    int respuesta2 = JOptionPane.showConfirmDialog(null,"¿IMPRIMIR TICKET?", "Confirmación",JOptionPane.YES_NO_OPTION);
                if (respuesta2 == JOptionPane.YES_OPTION) 
                   {
                        String ruta="C:\\Users\\Eduardo\\Documents\\NotasVenta2016\\";
                        String nameFile=fecha+"_"+idventa+"_";
                        String urll=ruta+nameFile+".pdf";
                        ProcessBuilder p=new ProcessBuilder();
                        p.command("cmd.exe","/c",urll);
                        p.start(); 
                        limpiartabla();
                        limpiartodo();
                        objVistaVentas.jButtonConfirmar.setEnabled(false); 
                        methodRefreshDatabase();
                        mostrarUltimaVenta();
                        objVistaVentas.jTextFieldCantidadProducto.setText("1");
                   }else{
                        limpiartabla();
                        limpiartodo();
                        methodRefreshDatabase();
                        mostrarUltimaVenta();
                        objVistaVentas.jButtonConfirmar.setEnabled(false);     
                        objVistaVentas.jTextFieldCantidadProducto.setText("1");
                        }
                }else{
                    objVistaVentas.jTextFieldCodigoBarras.requestFocus();
                }   
                    } catch (Exception econfirmar) {System.out.println("Error al confirmar venta"+econfirmar);}
            }            
        } catch (Exception ex) {System.out.println(e);}//Catch de actionPerfomed
    }

    
    
    @Override
    public void keyTyped(KeyEvent e) {
        try {
    /*----------------------------------------------------------------------------*/        
        if (e.getSource()==objVistaVentas.jTextFieldCodigoBarras) {
    /*----------------------------------------------------------------------------*/                    
                if (!Character.isDigit(e.getKeyChar()) && !Character.isISOControl(e.getKeyChar())) 
                {
                    Toolkit.getDefaultToolkit().beep();
                    e.consume();
                }
            }
    /*----------------------------------------------------------------------------*/        
        if (e.getSource()==objVistaVentas.jTextFieldCantidadProducto) {
    /*----------------------------------------------------------------------------*/                    
                if (!Character.isDigit(e.getKeyChar()) && !Character.isISOControl(e.getKeyChar())) 
                {
                    Toolkit.getDefaultToolkit().beep();
                    e.consume();
                }
            }
    /*----------------------------------------------------------------------------*/        
        if (e.getSource()==objVistaVentas.jTextFieldCodigoBarras) {
    /*----------------------------------------------------------------------------*/                    
                comprobarExistenciaPan();        
                obtenerIdPan();
                obtenerNombrePan();
                obtenerPrecioVentaPan();
                multiplicarCantidadPorPrecio();
                String codigoPan=objVistaVentas.jTextFieldCodigoBarras.getText();
                obtenerImagen(codigoPan);
            }        
    /*----------------------------------------------------------------------------*/                
        if (e.getSource()==objVistaVentas.jTextFieldPrecioProducto) {
    /*----------------------------------------------------------------------------*/                
            if (!Character.isDigit(e.getKeyChar())&& e.getKeyChar()!='.'){
                e.consume();
            }
            
        }
        } catch (Exception ekt) {System.out.println("Error en typed\n"+e);}
    }

    @Override
    public void keyPressed(KeyEvent e) {
        try {
    /*----------------------------------------------------------------------------*/            
                if (e.getSource()==objVistaVentas.jTable) {
    /*----------------------------------------------------------------------------*/                                
                    if (KeyEvent.VK_Q == e.getKeyCode()) 
                    {
                        objVistaVentas.jButtonQuitar.doClick();
                    }
                }
    /*----------------------------------------------------------------------------*/            
                if (e.getSource()==objVistaVentas.jTextFieldCodigoBarras) {
    /*----------------------------------------------------------------------------*/                                
                    if (KeyEvent.VK_ENTER == e.getKeyCode()) 
                    {
                        objVistaVentas.jTextFieldCantidadProducto.requestFocus();
                    }
                }
    /*----------------------------------------------------------------------------*/            
                if (e.getSource()==objVistaVentas.jTextFieldCantidadProducto) {
    /*----------------------------------------------------------------------------*/                                
                    if (KeyEvent.VK_ENTER == e.getKeyCode()) 
                    {
                        objVistaVentas.jButtonAgregar.doClick();
                    }
                    if (KeyEvent.VK_UP == e.getKeyCode()) 
                    {
                        objVistaVentas.jTextFieldCodigoBarras.requestFocus();
                    }
                }
    /*----------------------------------------------------------------------------*/            
                if (e.getSource()==objVistaVentas.jTextFieldCodigoBarras) {
    /*----------------------------------------------------------------------------*/                                
                    if (KeyEvent.VK_F5 == e.getKeyCode()) 
                    {
                        objVistaVentas.jButtonConfirmar.doClick();
                    }
                }                
/*----------------------------------------------------------------------------*/            
                if (e.getSource()==objVistaVentas.jTextFieldCodigoBarras) {
    /*----------------------------------------------------------------------------*/                                
                    if (KeyEvent.VK_F2 == e.getKeyCode()) 
                    {
                        objVistaVentas.jTable.requestFocus();
                    }
                }                                
    /*----------------------------------------------------------------------------*/            
                if (e.getSource()==objVistaVentas.jTextFieldCantidadProducto) {
    /*----------------------------------------------------------------------------*/                                
                    if (KeyEvent.VK_F5 == e.getKeyCode()) 
                    {
                        objVistaVentas.jButtonConfirmar.doClick();
                    }
                }
    /*----------------------------------------------------------------------------*/            
                if (e.getSource()==objVistaVentas.jTextFieldPrecioProducto) {
    /*----------------------------------------------------------------------------*/                                
                    if (KeyEvent.VK_F5 == e.getKeyCode()) 
                    {
                        objVistaVentas.jButtonConfirmar.doClick();
                    }
                }                                
    
        } catch (Exception kp) {
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        try {
    /*------------------------------------------------------------------------*/                        
            if (e.getSource()==objVistaVentas.jTextFieldCodigoBarras) {
    /*------------------------------------------------------------------------*/                                                    
                try {
                    obtenerIdPan();
                    obtenerNombrePan();
                    comprobarExistenciaPan();
                    obtenerPrecioVentaPan();
                    String codigoPan=objVistaVentas.jTextFieldCodigoBarras.getText();
                    obtenerImagen(codigoPan);
                    } catch (Exception ekr) {System.out.println("Error al teclear codigo de barras\n"+e);}
                }
    /*----------------------------------------------------------------------------*/            
            if (e.getSource()==objVistaVentas.jTextFieldPrecioProducto){
    /*----------------------------------------------------------------------------*/                            
                    multiplicarCantidadPorPrecio();
                }     
    /*----------------------------------------------------------------------------*/                            
            if (e.getSource()==objVistaVentas.jTextFieldCantidadProducto){
    /*----------------------------------------------------------------------------*/                            
                    int cant=Integer.parseInt(objVistaVentas.jTextFieldCantidadProducto.getText());
                    comprovarExistenciaDePanesEnInventario(cant);
                    multiplicarCantidadPorPrecio();
                }            
        } catch (Exception kr) {System.out.println("Error en KeyReleased"+e);}
    
        
    }//FIN_KEYRELEASED

    @Override
    public void focusGained(FocusEvent e) {
        try {
            if (e.getSource()==objVistaVentas.jTable) {
                System.out.println("TABLA TU MAMA");
            }
            
        } catch (Exception efg) {}
    }

    @Override
    public void focusLost(FocusEvent e) {
        
    }
    
}
