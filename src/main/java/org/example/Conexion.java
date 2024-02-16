package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    // Método para establecer la conexión a MySQL
    public Connection conectar() {
        try {
            // Cargar el controlador JDBC de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Datos de conexión
            String url = "jdbc:mysql://localhost:3306/bd_diccionario";
            String usuario = "root";
            String contraseña = "";

            // Establecer la conexión
            return DriverManager.getConnection(url, usuario, contraseña);
        } catch (ClassNotFoundException | SQLException e) {
            // Manejar cualquier error que pueda ocurrir durante la conexión
            e.printStackTrace();
            return null;
        }
    }

    // Otros métodos de la clase de conexión si es necesario
}

