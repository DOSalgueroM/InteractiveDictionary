import org.example.InteractiveDictionary;
import org.example.Node;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class DeleteTest {
    @Test
    public void deleteTest() {
        // connection data
        String url = "jdbc:mysql://localhost:3306/bd_diccionario";
        String usuario = "root";
        String contraseña = "";

        // word and definition to insert and delete
        String palabra = "Programming";
        String definicion = "The process of writing computer programs. It is the act of creating software using a set of instructions.";

        // Intent to establish the connection and perform the search
        try (Connection connection = DriverManager.getConnection(url, usuario, contraseña)) {
            InteractiveDictionary diccionario = new InteractiveDictionary();

            // Insert the word and definition
            diccionario.insert(palabra, definicion);

            // Intent to delete the word
            diccionario.delete(palabra);

            // search for the word in the database
            Node resultadoEliminacion = diccionario.search(palabra);

            // verify that the result does not exist
            assertNotNull(resultadoEliminacion);
        } catch (SQLException e) {
            // drive any SQL exceptions
            e.printStackTrace();
        }
    }
}
