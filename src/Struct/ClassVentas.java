package Struct;

public class ClassVentas {

    private int folio;
    private String fecha;
    private double total;
    
    private int idP;
    private int cantidad;
    private double importe;

    public ClassVentas() {
    }
    public ClassVentas(int folio, String fecha, double total, int idP, int cantidad, double importe) {
        this.folio = folio;
        this.fecha = fecha;
        this.total = total;
        this.idP = idP;
        this.cantidad = cantidad;
        this.importe = importe;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

}
