package org.example;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InteractiveDictionary {
    private Node root;
    Conexion conn = new Conexion();
    public InteractiveDictionary() {
        this.root = null;
    }
    public InteractiveDictionary(Conexion conn) {
        this.root = null;
        this.conn = conn;
    }

    public Node getRoot() {
        return root;
    }

    public void insert(String word, String definition) {
        conn.conectar();

        // Sentencia SQL INSERT
        String sql = "INSERT INTO diccionario (palabra, descripcion) VALUES (?, ?)";
        PreparedStatement ps;

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, word);
            ps.setString(2, definition);
            ps.executeUpdate();
            System.out.println("¡Word added correctly!");
        } catch(SQLException e) {
            System.out.println("Error to insert in the database: " + e.getMessage());
        }
    }

    public Node search(String word) {
        conn.conectar();

        // Sentence SQL INSERT, UPDATE, DELETE, SELECT
        String sql = "SELECT * FROM diccionario WHERE palabra = ? ";
        Statement st;

        String wordResult = "";
        String descripcion = "";

        try {
            CallableStatement cs = conn.conectar().prepareCall(sql);
            cs.setString(1, word);
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                wordResult = rs.getString(2);
                descripcion = rs.getString(3);
            }
        } catch(Exception e) {
            System.out.println("Can´t connect to the database: " + e.getMessage());
        }

        return new Node(wordResult, descripcion);
        // return searchRec(root, word);
    }

    public void delete(String word) {
        conn.conectar();

        // Sentencia SQL DELETE
        String sql = "DELETE FROM diccionario WHERE palabra = ?";
        PreparedStatement ps;

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, word);
            int rowsDeleted = ps.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("¡The word '" + word + "' has been deleted successfully!");
            } else {
                System.out.println("The word '" + word + "' does´nt exist in the Dictionary.");
            }
        } catch(SQLException e) {
            System.out.println("Error to delete the word: " + e.getMessage());
        }
    }


    public void printInOrder() {
        conn.conectar();

        System.out.println("\n------ Interactive Dictionary ------");
        printInOrderRec(root);
    }

    private void printInOrderRec(Node node) {
        // Sentencia SQL SELECT
        String sql = "SELECT * FROM diccionario ORDER BY palabra";
        Statement st;

        try {
            st = conn.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String word = rs.getString("palabra");
                String definition = rs.getString("descripcion");
                System.out.println(word + ": " + definition);
            }
        } catch(SQLException e) {
            System.out.println("Error to show the words in dictionary: " + e.getMessage());
        }
    }

    public void searchInitialLetterInDatabase(char initialLetter) {
        System.out.println("\nWords starting with letter '" + initialLetter + "':");

        // Sentence SQL SELECT
        String sql = "SELECT palabra, descripcion FROM diccionario WHERE LEFT(palabra, 1) = ? ORDER BY palabra";
        try (PreparedStatement preparedStatement = conn.conectar().prepareStatement(sql)) {
            preparedStatement.setString(1, String.valueOf(initialLetter));
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                // Iter about results and print them
                while (resultSet.next()) {
                    String word = resultSet.getString("palabra");
                    String definition = resultSet.getString("descripcion");
                    System.out.println(word + ": " + definition);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error searching words in the database: " + e.getMessage());
        }
    }


    public List<String> autoComplete(String prefix) {
        List<String> suggestions = new ArrayList<>();
        autoCompleteRec(root, prefix, "", suggestions);
        return suggestions;
    }

    private void autoCompleteRec(Node node, String prefix, String currentWord, List<String> suggestions) {
        if (node != null) {
            String newPrefix = currentWord + node.word.charAt(0);

            if (newPrefix.startsWith(prefix)) {
                suggestions.add(newPrefix);
            }

            autoCompleteRec(node.left, prefix, newPrefix, suggestions);
            autoCompleteRec(node.right, prefix, newPrefix, suggestions);
        }
    }

    /*private String autoCompleteInput(String input, InteractiveDictionary dictionary) {
        List<String> suggestions = new ArrayList<>();
        autoCompleteRec(dictionary.root, input, "", suggestions);

        if (!suggestions.isEmpty()) {
            System.out.println("Autocomplete suggestions: " + suggestions);
            System.out.print("Select suggestion or continue typing: ");
            String selectedSuggestion = suggestions.get(0); // En este ejemplo, seleccionamos la primera sugerencia automáticamente
            return selectedSuggestion;
        }

        return input;
    }

    private void autoCompleteRec(Node node, String prefix, String currentWord, List<String> suggestions) {
        if (node != null) {
            String newPrefix = currentWord + node.word.charAt(0);

            if (newPrefix.startsWith(prefix)) {
                suggestions.add(newPrefix);
            }

            autoCompleteRec(node.left, prefix, newPrefix, suggestions);
            autoCompleteRec(node.right, prefix, newPrefix, suggestions);
        }
    }

    private void searchWord(String word, InteractiveDictionary dictionary) {
        Node searchResult = dictionary.search(word);

        if (searchResult != null) {
            System.out.println("Definition of '" + word + "': " + searchResult.definition);
        } else {
            System.out.println("Word not found.");
        }
    }*/
}
