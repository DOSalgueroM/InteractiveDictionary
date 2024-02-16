import org.example.InteractiveDictionary;
import org.example.Node;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class SearchInitialLetterTest {
    @Test
    public void searchInitialLetterInDatabaseTest() {
        // Datos de conexión
        String url = "jdbc:mysql://localhost:3306/bd_diccionario";
        String usuario = "root";
        String contraseña = "";

        // Letra para la búsqueda
        char letraBusqueda = 'S';

        // Capturar la salida estándar
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Intenta establecer la conexión y realizar la búsqueda
        try (Connection connection = DriverManager.getConnection(url, usuario, contraseña)) {
            InteractiveDictionary diccionario = new InteractiveDictionary();

            // Realiza la búsqueda de palabras que comienzan con la letra 'S' en la base de datos
            diccionario.searchInitialLetterInDatabase(letraBusqueda);

            // Analiza la salida estándar para verificar si contiene las palabras esperadas
            String output = outContent.toString();
            assertTrue(output.contains("Sublime: Excellent, grand, or of elevated beauty"));
            assertTrue(output.contains("Substantial: Important or relevant in terms of quantity, quality, or significance"));
            // Agrega más aserciones según sea necesario
        } catch (SQLException e) {
            // Maneja cualquier excepción de SQL
            e.printStackTrace();
        } finally {
            // Restaura la salida estándar
            System.setOut(System.out);
        }
    }
}
