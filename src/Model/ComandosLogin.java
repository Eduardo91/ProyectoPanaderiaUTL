package Model;
import Struct.ClassUsuario;
public class ComandosLogin {
    public String validarUsuario(ClassUsuario cu ){
        return "SELECT * FROM usuario WHERE user='"+cu.getUser()+"'AND password='"+cu.getPassword()+"';";
    }
}
