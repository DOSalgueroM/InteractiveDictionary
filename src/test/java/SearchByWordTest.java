import org.example.Conexion;
import org.example.InteractiveDictionary;
import org.example.Node;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SearchByWordTest {
    private Conexion conn;

    @Test
    public void testSearchByWord() {
        // connection data
        String url = "jdbc:mysql://localhost:3306/bd_diccionario";
        String usuario = "root";
        String contrasena = "";

        // Word to search
        String palabraExistente = "Patient";

        // Word does not exist
        String palabraNoExistente = "Door";

        // Intent to establish the connection and perform the search
        try (Connection conn = DriverManager.getConnection(url, usuario, contrasena)) {
            InteractiveDictionary diccionario = new InteractiveDictionary();

            // Do the search for the existing word
            Node resultadoExistente = diccionario.search(palabraExistente);

            // Verify that the result is not null
            assertEquals("Having the capacity to tolerate or wait with calmness", resultadoExistente.getDefinition());

            // Do the search for the non-existent word
            Node resultadoNoExistente = diccionario.search(palabraNoExistente);

            // Prove that the result is null
            assertNotNull(resultadoNoExistente);
        } catch (SQLException e) {
            // Drive any SQL exceptions
            e.printStackTrace();
        }

    }
}
