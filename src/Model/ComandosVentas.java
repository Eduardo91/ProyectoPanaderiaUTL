package Model;
import Struct.ClassVentas;
public class ComandosVentas {
    
    public String insertarVenta(ClassVentas cv){
        return "INSERT INTO ventas (fecha,total) VALUES"
                +"('"+cv.getFecha()+"',"+cv.getTotal()+");";
    }
    
    public String insertarDetalleVenta(ClassVentas cv){
        return "INSERT INTO detalle (folio,idP,cantidad,importe,total) VALUES"
                +"("+cv.getFolio()+","+cv.getIdP()+","+cv.getCantidad()+","+cv.getImporte()+","+cv.getTotal()+");";
    }
    
    public  String ultimaVentaGenerada(){
        return "SELECT MAX(folio) AS folio FROM ventas;";
    }
    //
    public String obtenerNombrePan(ClassVentas cv){
        return "SELECT nombre FROM panes WHERE idP='"+cv.getIdP()+"';";
    }
    
    
}
