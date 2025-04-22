package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    // Definimos las variables que contienen los datos de conexión a la base de datos
    private final String DRIVER="com.mysql.jdbc.Driver";  // El driver necesario para conectar con MySQL
    private final String URL="jdbc:mysql://localhost:3306/";  // La URL donde está la base de datos (localhost, puerto 3306)
    private final String DB="tiendamascotas";  // Nombre de la base de datos a la que se quiere conectar
    private final String USER="root";  // El nombre de usuario para la conexión a la base de datos
    private final String PASSWORD="";  // La contraseña del usuario (vacía en este caso)
    
    public Connection cadena;  // Objeto para manejar la conexión a la base de datos
    public static Conexion instancia;  // Instancia única de la clase Conexion (patrón Singleton)
    
    // Constructor privado para evitar que se creen instancias fuera de la clase
    private Conexion(){
        this.cadena=null;  // Inicializamos la conexión a null
    }
    
    // Método para establecer la conexión a la base de datos
    public Connection conectar(){
        try {
            // Cargamos el driver de MySQL
            Class.forName(DRIVER);
            // Establecemos la conexión a la base de datos usando los datos anteriores
            this.cadena=DriverManager.getConnection(URL+DB,USER,PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            // Si ocurre algún error, mostramos un mensaje y cerramos la aplicación
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(0);
        }
        return this.cadena;  // Retornamos la conexión establecida
    }
    
    // Método para cerrar la conexión a la base de datos
    public void desconectar(){
        try {
            // Cerramos la conexión si está abierta
            this.cadena.close();
        } catch (SQLException e) {
            // Si ocurre algún error al cerrar la conexión, mostramos un mensaje
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    // Método estático que asegura que solo haya una instancia de la clase Conexion
    public synchronized static Conexion getInstancia(){
        // Si no se ha creado la instancia, la creamos
        if (instancia==null){
            instancia=new Conexion();
        }
        // Retornamos la única instancia de la clase
        return instancia;
    }
}
   