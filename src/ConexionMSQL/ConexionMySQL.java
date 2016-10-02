/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionMSQL;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Gus05aguilar
 */
public class ConexionMySQL {
    
    //Atributos de configuración de conexión:
    String host;
    int puerto;
    String nombreBd;
    String usuario;
    String contrasenia;
    String url;
    
    //Atributo que guarda la conexión con la BD:
    Connection conn;
    
    public ConexionMySQL()
    {        
        try
        {
            //Registramos el Driver de MySQL:
            Class.forName("com.mysql.jdbc.Driver");
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    public Connection abrir() throws Exception
    {
        //Verficamos si ya existe una conexión establecida:
        if (conn != null && !conn.isClosed())
            return conn;
        
        //Configuramos los datos de conexion:
        host = "127.0.0.1";
        puerto = 3306;
        nombreBd = "Panaderiagil5";
        usuario = "root";
        contrasenia = "";
        url = "jdbc:mysql://" + host + ":" + puerto + "/" + nombreBd;
        
        //Abrimos la conexión con la BD:
        conn = DriverManager.getConnection(url, usuario, contrasenia);
        
        //Regresamos la conexión establecida:
        return conn;
    }
    
     public Connection getConnection(){
        return conn;
    }
    
    public void cerrar()
    {
        if (conn == null)
            return;
        
        try
        {
            conn.close();
            conn = null;
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    
}
