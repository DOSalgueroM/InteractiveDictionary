import org.example.InteractiveDictionary;
import org.example.Node;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
public class InsertTest {
    @Test
    public void insertTest() {
        // connection data
        String url = "jdbc:mysql://localhost:3306/bd_diccionario";
        String usuario = "root";
        String contraseña = "";
        // Word and definition to insert
        String palabra = "Programming";
        String definicion = "The process of writing computer programs. It is the act of creating software using a set of instructions.";

        // Intent to establish the connection and perform the search
        try (Connection connection = DriverManager.getConnection(url, usuario, contraseña)) {
            InteractiveDictionary diccionario = new InteractiveDictionary();

            // Insert the word and definition
            diccionario.insert(palabra, definicion);

            // Search for the word in the database
            Node resultadoInsercion = diccionario.search(palabra);

            // Verify that the result and the expected word and definition are the same
            assertEquals(palabra, resultadoInsercion.getWord());
            assertEquals(definicion, resultadoInsercion.getDefinition());
        } catch (SQLException e) {
            // Drive any SQL exceptions
            e.printStackTrace();
        }
    }
}
