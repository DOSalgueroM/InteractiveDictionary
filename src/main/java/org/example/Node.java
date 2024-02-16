package org.example;

public class Node {
    String word;
    String definition;
    Node left;
    Node right;

    public Node(String word, String definition) {
        this.word = word;
        this.definition = definition;
        this.left = null;
        this.right = null;
    }

    public String getDefinition() {
        return definition;
    }
}
