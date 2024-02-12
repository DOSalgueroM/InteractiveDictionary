package org.example;

import java.util.ArrayList;
import java.util.List;

public class InteractiveDictionary {
    private Node root;

    public InteractiveDictionary() {
        this.root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void insert(String word, String definition) {
        root = insertRec(root, word, definition);
    }

    private Node insertRec(Node node, String word, String definition) {
        if (node == null) {
            return new Node(word, definition);
        }

        if (word.compareTo(node.word) < 0) {
            node.left = insertRec(node.left, word, definition);
        } else if (word.compareTo(node.word) > 0) {
            node.right = insertRec(node.right, word, definition);
        }

        return node;
    }

    public Node search(String word) {
        return searchRec(root, word);
    }

    private Node searchRec(Node node, String word) {
        if (node == null || node.word.equals(word)) {
            return node;
        }

        if (word.compareTo(node.word) < 0) {
            return searchRec(node.left, word);
        }

        return searchRec(node.right, word);
    }

    public void delete(String word) {
        root = deleteRec(root, word);
    }

    private Node deleteRec(Node node, String word) {
        if (node == null) {
            return node;
        }

        if (word.compareTo(node.word) < 0) {
            node.left = deleteRec(node.left, word);
        } else if (word.compareTo(node.word) > 0) {
            node.right = deleteRec(node.right, word);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            node.word = findMin(node.right).word;
            node.right = deleteRec(node.right, node.word);
        }

        return node;
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public void printInOrder() {
        System.out.println("\n------ Interactive Dictionary ------");
        printInOrderRec(root);
    }

    private void printInOrderRec(Node node) {
        if (node != null) {
            printInOrderRec(node.left);
            System.out.println(node.word + ": " + node.definition);
            printInOrderRec(node.right);
        }
    }
    public List<Node> searchInitialLetter(char initialLetter) {
        List<Node> wordsStartingWithLetter = new ArrayList<>();
        searchInitialLetterRec(root, initialLetter, "", wordsStartingWithLetter);
        return wordsStartingWithLetter;
    }
    private void searchInitialLetterRec(Node node, char targetLetter, String currentWord, List<Node> result) {
        if (node != null) {
            char nodeLetter = node.word.charAt(0);

            // Compara la letra del nodo con la letra objetivo
            if (nodeLetter == targetLetter) {
                result.add(node);
            }

            // Explora los nodos de manera recursiva
            searchInitialLetterRec(node.left, targetLetter, currentWord, result);
            searchInitialLetterRec(node.right, targetLetter, currentWord, result);
        }
    }
    /*public List<String> searchInitialLetter(char initialLetter) {
        List<String> wordsStartingWithLetter = new ArrayList<>();
        searchInitialLetterRec(root, initialLetter, "", wordsStartingWithLetter);
        return wordsStartingWithLetter;
    }

    private void searchInitialLetterRec(Node node, char targetLetter, String currentWord, List<String> result) {
        if (node != null) {
            char nodeLetter = node.word.charAt(0);

            // Compara la letra del nodo con la letra objetivo
            if (nodeLetter == targetLetter) {
                result.add(currentWord + node.word);
            }

            // Explora los nodos de manera recursiva
            searchInitialLetterRec(node.left, targetLetter, currentWord, result);
            searchInitialLetterRec(node.right, targetLetter, currentWord, result);
        }
    }*/
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

