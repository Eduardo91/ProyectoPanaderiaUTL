package Model;

import Struct.ClassInventario;

public class ComandosInventario {
    public String comprovarexistenciaPaquete(ClassInventario in) {
        return "SELECT existencia FROM inventario WHERE idP='"+in.getIdP()+"';";
    }
    
    public String mostrarTodosLosPanes() {
        return "SELECT * FROM inventario;";
    }

    public String buscarPan(ClassInventario ci) {
        String query = "select * from mostrar where idP=" + ci.getIdP();
        return query;
    }

    public String buscarPanN(String nombre) {
        String query = "select * from mostrar where nombre like '" +nombre+ "'";
        return query;
    }
    
    
}
