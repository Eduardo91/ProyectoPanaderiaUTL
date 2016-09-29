package Model;
import ConexionMSQL.ConexionMySQL;
import Struct.ClassPan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ComandosPAN {

    public String insertarPan(ClassPan cp) {
        return "INSERT INTO panes (codigoPan,nombre,descripción,precioP,precioV,imagen,estatus)"
                + "VALUES('" + cp.getCodigoPan()+ "'," + cp.getNombre()+ ","+ cp.getDescripcion()+","+cp.getPricep()+","+cp.getPricev()+","+cp.getImagen()+","+cp.getStatus()+");";
    }
    
    public String comprovarExistenciaPan(ClassPan cp){
        return "SELECT codigoPan FROM panes WHERE codigoPan='"+cp.getCodigoPan()+"';";
    }
    
    public String consultarTodo(ClassPan cp){
        return "SELECT * FROM panes";
        }
    public String consultarPorEstatus(ClassPan cp){
        return "SELECT * FROM panes WHERE status="+cp.getStatus();
        }
    
    public String actualizarPan(ClassPan cp) {
        return "UPDATE panes SET codigoPan='" + cp.getCodigoPan()
                +    "' , nombre='"+cp.getNombre()
                +   "' ,descripcion='"+cp.getDescripcion()
                +   "',precioP='"+cp.getPricep()
                +   "',precioV='"+cp.getPricev()
                +   "',imagen='"+cp.getImagen()
                +   "',estatus='"+cp.getStatus()
                + "' WHERE idpan = " + cp.getIdpan()+ ";";
    }
    public String buscarPan(ClassPan cp){
        return "SELECT * FROM panes WHERE codigoPan='"+cp.getCodigoPan();
    }
    public String obtenerIdPan(ClassPan cp){
        return "SELECT idP FROM panes WHERE codigoPan='"+cp.getCodigoPan()+"';";
    }
    public String obtenerNombrePan(ClassPan cp){
        return "SELECT nombre FROM panes WHERE codigoPan='"+cp.getCodigoPan()+"';";
    }
    public String obtenerPrecioVentaPan(ClassPan cp){
        return "SELECT precioV FROM panes WHERE codigoPan='"+cp.getCodigoPan()+"';";
    }
    public String obtenerImagenDePan(ClassPan cp){
        return "SELECT imagen FROM panes WHERE codigoPan='"+cp.getCodigoPan()+"';";
    }
    
    /*  */
     public boolean insertar(ClassPan p) throws Exception{
         String sql = "INSERT INTO panes (codigoPan,nombre,descripcion ,precioP,precioV) VALUES (?,?,?,?,?)";
   
        //Abre y cierra la conexion con la base de datos
        //Guarda un objeto de tipo java.sql Conecction
        ConexionMySQL connMySQL = new ConexionMySQL();
        
        //Este sirve para ejecutar la operacion o la consulta es como el rayito en MySQL
        //Crea un objeto de tipo Statement con la conexion ya hecha arriba
        Connection conn = connMySQL.abrir();
        PreparedStatement psmt = conn.prepareStatement(sql);
        
       //Asignamos el valor de cada parametro de la consulta
       psmt.setString(1, p.getCodigoPan());
       psmt.setString(2, p.getNombre());
       psmt.setString(3, p.getDescripcion());
       psmt.setDouble(4, p.getPricep());
       psmt.setDouble(5, p.getPricev());
       
      //Ejecutamos la constula SQL:
      psmt.executeUpdate();
      
      //Cerramos el PreparesStatenment
      psmt.close();
      
      //Cerramos la conexion con la BD:
      connMySQL.cerrar();
      
     return true;
    }
/*  */

    
     
/*  */     
     public boolean eliminarPan(ClassPan p) throws Exception{
        int eliminar = 0;
         String sql = "Update panes set estatus =  "+ eliminar +" where idP = (?)";
   
        //Abre y cierra la conexion con la base de datos
        //Guarda un objeto de tipo java.sql Conecction
        ConexionMySQL connMySQL = new ConexionMySQL();
        
        //Este sirve para ejecutar la operacion o la consulta es como el rayito en MySQL
        //Crea un objeto de tipo Statement con la conexion ya hecha arriba
        Connection conn = connMySQL.abrir();
        PreparedStatement psmt = conn.prepareStatement(sql);
        
       //Asignamos el valor de cada parametro de la consulta
       psmt.setInt(1, p.getIdpan());
       
      //Ejecutamos la constula SQL:
      psmt.executeUpdate();
      
      //Cerramos el PreparesStatenment
      psmt.close();
      
      //Cerramos la conexion con la BD:
      connMySQL.cerrar();
      
     return true;
    }
     
/*  */     
     
     
     
/*  */        
     public String[][] getAll() throws Exception
    {
        String[][] datos = null;
        int renglones = 0;
        int columnas = 6;
        int renglonActual = 0;
        String query = "SELECT * FROM panes ";        
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.abrir();        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        if (rs.last())
        {
            renglones = rs.getRow();
            datos = new String[renglones][columnas];
            rs.beforeFirst();
            while (rs.next())
            {    
                datos[renglonActual][0] = "" + rs.getInt("idP");
                datos[renglonActual][1] = rs.getString("codigoPan");
                datos[renglonActual][2] = rs.getString("nombre");
                datos[renglonActual][3] = rs.getString("descripcion");
                datos[renglonActual][4] = "" + rs.getDouble("precioP");
                datos[renglonActual][5] = "" + rs.getDouble("precioV");
                renglonActual ++;
            }
        }        
        rs.close();
        stmt.close();
        connMySQL.cerrar();
        return datos;
    }
/*  */        

     
     
     
          
/*  */        
     public String[][] getActivos() throws Exception
    {
        String[][] datos = null;
        int renglones = 0;
        int columnas = 6;
        int renglonActual = 0;
        String query = "SELECT * FROM panes where estatus = 1";        
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.abrir();        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        if (rs.last())
        {
            renglones = rs.getRow();
            datos = new String[renglones][columnas];
            rs.beforeFirst();
            while (rs.next())
            {    
                datos[renglonActual][0] = "" + rs.getInt("idP");
                datos[renglonActual][1] = rs.getString("codigoPan");
                datos[renglonActual][2] = rs.getString("nombre");
                datos[renglonActual][3] = rs.getString("descripcion ");
                datos[renglonActual][4] = "" + rs.getDouble("precioP");
                datos[renglonActual][5] = "" + rs.getDouble("preciV");
                renglonActual ++;
            }
        }        
        rs.close();
        stmt.close();
        connMySQL.cerrar();
        return datos;
    }
/*  */        

      
/*  */        
     public String[][] getEliminados() throws Exception
    {
        String[][] datos = null;
        int renglones = 0;
        int columnas = 6;
        int renglonActual = 0;
        String query = "SELECT * FROM panes where estatus = 0";        
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.abrir();        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        if (rs.last())
        {
            renglones = rs.getRow();
            datos = new String[renglones][columnas];
            rs.beforeFirst();
            while (rs.next())
            {    
                datos[renglonActual][0] = "" + rs.getInt("idP");
                datos[renglonActual][1] = rs.getString("codigoPan");
                datos[renglonActual][2] = rs.getString("nombre");
                datos[renglonActual][3] = rs.getString("descripcion ");
                datos[renglonActual][4] = "" + rs.getDouble("precioP");
                datos[renglonActual][5] = "" + rs.getDouble("preciV");
                renglonActual ++;
            }
        }        
        rs.close();
        stmt.close();
        connMySQL.cerrar();
        return datos;
    }
/*  */        

     
/*  */      
    public boolean actualizar(ClassPan p) throws Exception{
        
         String sql = "Call actualizarPan  (?,?,?,?,?,?)";
   
        //Abre y cierra la conexion con la base de datos
        //Guarda un objeto de tipo java.sql Conecction
        ConexionMySQL connMySQL = new ConexionMySQL();
        
        //Este sirve para ejecutar la operacion o la consulta es como el rayito en MySQL
        //Crea un objeto de tipo Statement con la conexion ya hecha arriba
        Connection conn = connMySQL.abrir();
        PreparedStatement psmt = conn.prepareStatement(sql);
        
        
       //Asignamos el valor de cada parametro de la consulta
       psmt.setInt(1,p.getIdpan()); 
       psmt.setString(2, p.getCodigoPan());
       psmt.setString(3, p.getNombre());
       psmt.setString(4, p.getDescripcion());
       psmt.setDouble(5, p.getPricep());
       psmt.setDouble(6, p.getPricev());
       
       
      //Ejecutamos la constula SQL:
      psmt.executeUpdate();
      
      //Cerramos el PreparesStatenment
      psmt.close();
      
      //Cerramos la conexion con la BD:
      connMySQL.cerrar();
      
     return true;
    }  
     
/*  */      
     
    
/*  */     
     public String[][] buscar(String valor) throws Exception
    {
        String[][] datos = null;
        int renglones = 0;
        int columnas = 6;
        int renglonActual = 0;
        String query = "SELECT * FROM panes  WHERE  idP = '"+valor+"' "; 
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.abrir();        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        if (rs.last())
        {
            renglones = rs.getRow();
            datos = new String[renglones][columnas];
            rs.beforeFirst();
            while (rs.next())
            {    
                datos[renglonActual][0] = "" + rs.getInt("idP");
                datos[renglonActual][1] = rs.getString("codigoPan");
                datos[renglonActual][2] = rs.getString("nombre");
                datos[renglonActual][3] = rs.getString("descripcion ");
                datos[renglonActual][4] = "" + rs.getDouble("precioP");
                datos[renglonActual][5] = "" + rs.getDouble("preciV");
                renglonActual ++;
            }
        }        
        rs.close();
        stmt.close();
        connMySQL.cerrar();
        return datos;
    }


}//fin de la clase

    
