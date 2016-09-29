package Model;
import java.sql.*;

public class MySQLconnection {

    private static Connection con;
    private static Statement st;
    private static ResultSet rt;
    private static String ruta;
    private static String user;
    private static String pswd;

    public MySQLconnection() {
        ruta = "jdbc:mysql://localhost:3306/panaderiagil3";
        user = "root";
        pswd = "";
    }
    public void conectar() throws SQLException {
        try {
            con = DriverManager.getConnection(ruta, user, pswd);
            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            } catch (SQLException e) {System.out.println("Error de conexion"+e);}
    }

    public void desconectar() {
        if (con == null) {
            return;
        }
        try {
            con.close();
        } catch (Exception e) {
            
        }
        con = null;
    }
    public Connection getConnection() {
        return con;
    }
    public void transation() throws SQLException {
        con.setAutoCommit(false);
    }
    
    public void commit() throws SQLException{
        con.commit();
    }

    public void rollBlack() {
        try {
            con.rollback();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}//endClass
