package negocio;

import datos.datos;
import entidades.usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class negocio {
    private final datos DATOS;
    private final usuario obj;
    private DefaultTableModel modeloTabla;
    public int registrosMostrados;
    
    public negocio(){
        this.DATOS = new datos();
        this.obj = new usuario();
        this.registrosMostrados = 0;
    }
    
    public DefaultTableModel listar(String texto){
        List<usuario> lista = new ArrayList<>();
        lista.addAll(DATOS.usuario(texto));
        
        String[] titulos = {"Id", "Nombre", "Contraseña", "Estado"};
        this.modeloTabla = new DefaultTableModel(null, titulos);        
        
        String estado;
        String[] registro = new String[4];
        
        this.registrosMostrados = 0;
        for (usuario item : lista){
            if (item.isActivo()){
                estado = "Activo";
            } else{
                estado = "Inactivo";
            }
            registro[0] = Integer.toString(item.getId());
            registro[1] = item.getNombre();
            registro[2] = item.getcontrasena();  // Asegúrate de tener este método en la clase usuario
            registro[3] = estado;
            this.modeloTabla.addRow(registro);
            this.registrosMostrados++;
        }
        return this.modeloTabla;
    }
    
    public String insertar(String nombre, String contrasena){
        if (DATOS.existe(nombre)){
            return "El registro ya existe.";
        } else {
            obj.setNombre(nombre);
            obj.setcontrasena(contrasena);  // Cambié getcontrasena() por setContrasena()
            if (DATOS.insertar(obj)){
                return "OK";
            } else {
                return "Error en el registro.";
            }
        }
    }
    
    public String actualizar(int id, String nombre, String nombreAnt, String contrasena){
        if (nombre.equals(nombreAnt)){
            obj.setId(id);
            obj.setNombre(nombre);
            obj.setcontrasena(contrasena);  // Cambié getcontrasena() por setContrasena()
            if(DATOS.actualizar(obj)){
                return "OK";
            } else {
                return "Error en la actualización.";
            }
        } else {
            if (DATOS.existe(nombre)){
                return "El registro ya existe.";
            } else {
                obj.setId(id);
                obj.setNombre(nombre);
                obj.setcontrasena(contrasena);  // Cambié getcontrasena() por setContrasena()
                if (DATOS.actualizar(obj)){
                    return "OK";
                } else {
                    return "Error en la actualización.";
                }
            }
        }
    }
    
    public String desactivar(int id){
        if (DATOS.desactivar(id)){
            return "OK";
        } else {
            return "No se puede desactivar el registro";
        }
    }
    
    public String activar(int id){
        if (DATOS.activar(id)){
            return "OK";
        } else {
            return "No se puede activar el registro";
        }
    }
    
    public int total(){
        return DATOS.total();
    }
    
    public int totalMostrados(){
        return this.registrosMostrados;
    }
}
