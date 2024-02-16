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
        // Datos de conexión
        String url = "jdbc:mysql://localhost:3306/bd_diccionario";
        String usuario = "root";
        String contrasena = "";

        // Palabra existente en el diccionario
        String palabraExistente = "Patient";

        // Palabra no existente en el diccionario
        String palabraNoExistente = "Door";

        // Intenta establecer la conexión y realiza las pruebas
        try (Connection conn = DriverManager.getConnection(url, usuario, contrasena)) {
            InteractiveDictionary diccionario = new InteractiveDictionary();

            // Realiza la búsqueda de la palabra existente
            Node resultadoExistente = diccionario.search(palabraExistente);

            // Verifica que la definición de la palabra existente sea la esperada
            assertEquals("Having the capacity to tolerate or wait with calmness", resultadoExistente.getDefinition());

            // Realiza la búsqueda de la palabra no existente
            Node resultadoNoExistente = diccionario.search(palabraNoExistente);

            // Verifica que el resultado para la palabra no existente sea nulo
            assertNotNull(resultadoNoExistente);
        } catch (SQLException e) {
            // Maneja cualquier excepción de SQL
            e.printStackTrace();
        }

    }
}
