package Struct;
/**
 *
 * @author Eduardo
 */
public class ClassUsuario {
private int id;
private String user;
private String password;
private String qr;

    public ClassUsuario() {
    }

    public ClassUsuario(int id, String user, String password, String qr) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.qr = qr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getQr() {
        return qr;
    }

    public void setQr(String qr) {
        this.qr = qr;
    }
    
    
    
}
