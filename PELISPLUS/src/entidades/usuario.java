
package entidades;

public class usuario {
    private int id_usuario;
    private String nombre;
    private String contrasena;
    private boolean activo;
    
    //Constructores
    public usuario() {
        
    }

    public usuario(int id_usuario, String nombre, String contrasena, boolean activo) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.activo = activo;
    }
    
    //Setter y getter

    public int getId() {
        return id_usuario;
    }

    public void setId(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getcontraseña() {
        return contrasena;
    }

    public void setcontraseña(String contraseña) {
        this.contrasena = contraseña;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    //Método toString

    @Override
    public String toString() {
        return "Categoria{" + "id=" + id_usuario + ", nombre=" + nombre + ", contraseña=" + contrasena + ", activo=" + activo + '}';
    }

    public String getcontrasena() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setcontrasena(String contrasena) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
