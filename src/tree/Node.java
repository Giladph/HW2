package tree;

public class Node {
    private int count;
    private Node[] children = new Node[(int) 'z' - (int) 'a' + 1];

    // Returns the number of times the word s has appeared in the tree
    public int num(String s) {
        if (s.isEmpty()) {
            return count; // If the string is empty, return the count of the current node
        }

        Node current = this;
        char c = s.charAt(0);  // Take the first character
        int index = c - 'a';   // Convert the character to an index

        if (current.children[index] == null) {
            return 0; // If no matching child node exists, return 0
        }

        // Continue recursively, removing the first character from the string
        return current.children[index].num(s.substring(1));  // Using substring
    }

    // Adds the word s to the tree
    public void add(String s) {
        Node current = this;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);  // Get the current character
            int index = c - 'a';   // Convert the character to an index

            if (current.children[index] == null) {
                current.children[index] = new Node(); // Create a new node if it doesn't exist
            }

            current = current.children[index];  // Move to the next node
        }
        current.count++;  // Increment the count for the word at this node
    }
}