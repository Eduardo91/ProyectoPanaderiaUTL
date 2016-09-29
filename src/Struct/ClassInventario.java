package Struct;


public class ClassInventario {
    private int idI;
    private int idP;
    private int existencia;
    private String fecha;

    public ClassInventario() {
    }

    public ClassInventario(int idI, int idP, int existencia, String fecha) {
        this.idI = idI;
        this.idP = idP;
        this.existencia = existencia;
        this.fecha = fecha;
    }

    public int getIdI() {
        return idI;
    }

    public void setIdI(int idI) {
        this.idI = idI;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}
