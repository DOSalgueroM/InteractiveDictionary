package org.example;

import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Conexion conn = new Conexion();
        conn.conectar();

        InteractiveDictionary dictionary = new InteractiveDictionary();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the input buffer
            //String userInput;

            switch (choice) {
                case 1:

                    System.out.print("Enter the word to search: ");
                    String wordToSearch = scanner.nextLine();
                    Node searchResult = dictionary.search(wordToSearch);

                    if (searchResult != null && searchResult.word.equals(wordToSearch)) {
                        System.out.println("Definition of '" + wordToSearch + "': " + searchResult.definition);
                    } else {
                        System.out.println("Word not found.");
                    }
                    break;

                case 2:

                    System.out.print("Enter the initial letter: ");
                    char initialLetter = scanner.next().charAt(0);
                    dictionary.searchInitialLetterInDatabase(initialLetter);
                    break;

                case 3:
                    System.out.println("Dictionary words: ");
                    dictionary.printInOrder();
                    break;

                case 4:
                    System.out.print("Enter the new word: ");
                    String newWord = scanner.nextLine();
                    System.out.print("Enter the definition of '" + newWord + "': ");
                    String newDefinition = scanner.nextLine();

                    dictionary.insert(newWord, newDefinition);
                    break;

                case 5:
                    System.out.print("Enter the word to delete: ");
                    String wordToDelete = scanner.nextLine();
                    dictionary.delete(wordToDelete);
                    break;

                case 6:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid option. Please try again.");
                    Main.main(null);
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Welcome to the Interactive Dictionary!");
        System.out.println("Choose an option in our Menu: ");
        System.out.println("\n------ Menu ------");
        System.out.println("1. Search for a word");
        System.out.println("2. Search for a Initial Letter");
        System.out.println("3. Show all the words in the dictionary");
        System.out.println("4. Add a new word");
        System.out.println("5. Delete a word");
        System.out.println("6. Exit");
        System.out.println("------------------");
    }
    private static void autoCompleteAndSearch(String userInput, InteractiveDictionary dictionary) {
        List<String> suggestions = dictionary.autoComplete(userInput);

        if (suggestions.isEmpty()) {
            System.out.println("No suggestions found.");
        } else if (suggestions.size() == 1 && suggestions.get(0).equalsIgnoreCase(userInput)) {
            // Si solo hay una sugerencia y es la misma que la entrada del usuario, buscar la palabra directamente
            dictionary.search(userInput);
        } else {
            System.out.println("Autocomplete suggestions: " + suggestions);
            System.out.print("Select suggestion or continue typing: ");
            String selectedSuggestion = scanner.nextLine(); // En este ejemplo, dejamos que el usuario seleccione la sugerencia
            dictionary.search(selectedSuggestion);
        }
    }
    /*private static String autoCompleteInput(String input, InteractiveDictionary dictionary) {
        List<String> suggestions = new ArrayList<>();
        autoCompleteRec(dictionary.getRoot(), input, "", suggestions);

        if (!suggestions.isEmpty()) {
            System.out.println("Autocomplete suggestions: " + suggestions);
            System.out.print("Select suggestion or continue typing: ");
            String selectedSuggestion = suggestions.get(0); // En este ejemplo, seleccionamos la primera sugerencia automáticamente
            return selectedSuggestion;
        }

        return input;
    }

    private static void autoCompleteRec(Node node, String prefix, String currentWord, List<String> suggestions) {
        if (node != null) {
            String newPrefix = currentWord + node.word.charAt(0);

            if (newPrefix.startsWith(prefix)) {
                suggestions.add(newPrefix);
            }

            autoCompleteRec(node.left, prefix, newPrefix, suggestions);
            autoCompleteRec(node.right, prefix, newPrefix, suggestions);
        }
    }

    private static void searchWord(String word, InteractiveDictionary dictionary) {
        Node searchResult = dictionary.search(word);

        if (searchResult != null) {
            System.out.println("Definition of '" + word + "': " + searchResult.definition);
        } else {
            System.out.println("Word not found.");
        }
    }*/
}
