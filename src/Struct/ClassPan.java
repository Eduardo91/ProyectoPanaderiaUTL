package Struct;
public class ClassPan {
    
    private int idpan;
    private String codigoPan;
    private String nombre;
    private String descripcion;
    private double pricep;
    private double pricev;
    private String imagen;
    private int status;

    public ClassPan() {
    }
    public ClassPan(String codigoPan, String nombre, String descripcion, double pricep, double pricev, String imagen) {
        this.codigoPan = codigoPan;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.pricep = pricep;
        this.pricev = pricev;
        this.imagen = imagen;
    }

    public ClassPan(int idpan) {
        this.idpan = idpan;
    }

    

    
    public int getIdpan() {
        return idpan;
    }

    public void setIdpan(int idpan) {
        this.idpan = idpan;
    }

    public String getCodigoPan() {
        return codigoPan;
    }

    public void setCodigoPan(String codigoPan) {
        this.codigoPan = codigoPan;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPricep() {
        return pricep;
    }

    public void setPricep(double pricep) {
        this.pricep = pricep;
    }

    public double getPricev() {
        return pricev;
    }

    public void setPricev(double pricev) {
        this.pricev = pricev;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
    
}
