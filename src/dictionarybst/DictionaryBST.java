/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dictionarybst;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Node {

    String value;
    Node left;
    Node right;

    public Node(String value) {
        this.value = value;
        left = null;
        right = null;
    }
}

public class DictionaryBST {

    Node root;

    public DictionaryBST() {
        root = null;
    }

    public void insert(String word) {
        root = insertRecursive(root, word);
    }

    private Node insertRecursive(Node current, String word) {
        if (current == null) {
            return new Node(word);
        }       
        if (word.compareTo(current.value) < 0) {
            current.left = insertRecursive(current.left, word);
        } else if (word.compareTo(current.value) > 0) {
            current.right = insertRecursive(current.right, word);
        } else {
            return current;
        }
        return current;
    }

    public void buildTreeFromFile(String filename) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = br.readLine()) != null) {
                insert(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int levenshteinDistance(String s, String t) {
        int m = s.length();
        int n = t.length();

        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }

        int[][] matrix = new int[m + 1][n + 1];

        for (int j = 0; j <= n; j++) {
            matrix[0][j] = j;
        }

        for (int i = 0; i <= m; i++) {
            matrix[i][0] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int cost = s.charAt(i - 1) == t.charAt(j - 1) ? 0 : 1;

                int deletion = matrix[i - 1][j] + 1;
                int insertion = matrix[i][j - 1] + 1;
                int substitution = matrix[i - 1][j - 1] + cost;
                matrix[i][j] = Math.min(Math.min(deletion, insertion), substitution);
            }
        }

        return matrix[m][n];
    }

    public void addFirst(String a, String word) {
        Node newNode = new Node(a);
        if (root == null) {
            root = newNode;
            return;
        }
        buildLevenTree(root, newNode, word);
    }

    public static void buildLevenTree(Node node, Node newNode, String word) {
        if (levenshteinDistance(newNode.value, word) <= levenshteinDistance(node.value, word)) {
            if (node.left == null) {
                node.left = newNode;
                return;
            }
            buildLevenTree(node.left, newNode, word);
        } else {
            if (node.right == null) {
                node.right = newNode;
                return;
            }
            buildLevenTree(node.right, newNode, word);
        }
    }

    public String findMin() {
        if (root == null) {
            throw new NoSuchElementException("Binary Search Tree is empty.");
        }
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.value;
    }

    public void deleteMin() {
        if (root == null) {
            return;
        }
        if (root.left == null) {
            root = root.right;
            return;
        }
        Node parent = root;
        Node current = root.left;
        while (current.left != null) {
            parent = current;
            current = current.left;
        }
        parent.left = current.right;
    }

    public static List<String> searchTree(DictionaryBST node, String word, int k) {
        List<String> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        DictionaryBST newTree = new DictionaryBST();
        Node current = node.root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            String data = current.value;
            newTree.addFirst(data, word);
            current = current.right;
        }
        for (int i = 0; i < k; i++) {
            list.add(newTree.findMin());
            newTree.deleteMin();
        }
        return list;
    }
}
