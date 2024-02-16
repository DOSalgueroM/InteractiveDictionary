package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private Connection connection;

    // Constructor que acepta la URL, usuario y contraseña
    public Conexion() {
        try {
            // Cargar el controlador JDBC de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Datos de conexión
            String url = "jdbc:mysql://localhost:3306/bd_diccionario";
            String usuario = "root";
            String contraseña = "";

            // Establecer la conexión
            this.connection = DriverManager.getConnection(url, usuario, contraseña);
        } catch (ClassNotFoundException | SQLException e) {
            // Manejar cualquier error que pueda ocurrir durante la conexión
            e.printStackTrace();
            // Puedes decidir si lanzar una excepción aquí o manejar el error de otra manera
        }
    }

    // Método para obtener la conexión
    public Connection conectar() {
        return this.connection;
    }


    // Otros métodos de la clase de conexión si es necesario
    // Método para establecer la conexión a MySQL
  /*  public Connection conectar() {
        try {
            // Cargar el controlador JDBC de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Datos de conexión
            String url = "jdbc:mysql://localhost:3306/bd_diccionario";
            String usuario = "root";
            String contrasena = "";

            // Establecer la conexión
            return DriverManager.getConnection(url, usuario, contrasena);
        } catch (ClassNotFoundException | SQLException e) {
            // Manejar cualquier error que pueda ocurrir durante la conexión
            e.printStackTrace();
            return null;
        }
    }*/
    /*public Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bd_diccionario";
            String usuario = "root";
            String contraseña = "";
            return DriverManager.getConnection(url, usuario, contraseña);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }*/
}


