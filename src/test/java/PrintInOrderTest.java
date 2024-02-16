import org.example.InteractiveDictionary;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.Assert.assertTrue;
public class PrintInOrderTest {
    @Test
    public void printInOrderTest() {
        // connection data
        String url = "jdbc:mysql://localhost:3306/bd_diccionario";
        String usuario = "root";
        String contraseña = "";
        // capture standard output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // intent to establish the connection and perform the search
        try (Connection connection = DriverManager.getConnection(url, usuario, contraseña)) {
            InteractiveDictionary diccionario = new InteractiveDictionary();

            // print the words in order
            diccionario.printInOrder();

            // Analiyze the standard output to verify if it contains the expected words
            String output = outContent.toString();
            assertTrue(output.contains("Sublime: Excellent, grand, or of elevated beauty"));
            assertTrue(output.contains("Substantial: Important or relevant in terms of quantity, quality, or significance"));
            // Add more assertions as needed
        } catch (SQLException e) {
            // Drive any SQL exceptions
            e.printStackTrace();
        } finally {
            // Restore standard output
            System.setOut(System.out);
        }
    }
}
