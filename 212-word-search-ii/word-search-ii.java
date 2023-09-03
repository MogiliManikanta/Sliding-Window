public class Solution {
    // Define a TrieNode class for implementing a Trie data structure.
    public class TrieNode {
        public boolean isWord = false; // Indicates whether a word ends at this node.
        public TrieNode[] child = new TrieNode[26]; // Array to store child nodes for each character.
        public TrieNode() {
        }
    }
    
    TrieNode root = new TrieNode(); // Create the root of the Trie.
    boolean[][] flag; // A 2D array to keep track of visited cells on the board.
    
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>(); // Use a set to store unique valid words.
        flag = new boolean[board.length][board[0].length]; // Initialize the flag array.
        
        addToTrie(words); // Add all the words to the Trie data structure.
        
        // Iterate through the board to search for words.
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                // Check if there is a word that starts with the current character on the board.
                if(root.child[board[i][j] - 'a'] != null){
                    search(board, i, j, root, "", result); // Start searching for words.
                }
            }
        }
        
        return new LinkedList<>(result); // Convert the set to a list and return.
    }
    
    // Helper method to add words to the Trie data structure.
    private void addToTrie(String[] words){
        for(String word: words){
            TrieNode node = root;
            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                if(node.child[ch - 'a'] == null){
                    node.child[ch - 'a'] = new TrieNode(); // Create a new node if it doesn't exist.
                }
                node = node.child[ch - 'a']; // Move to the next node.
            }
            node.isWord = true; // Mark the last node as the end of a word.
        }
    }
    
    // Recursive function to search for words on the board.
    private void search(char[][] board, int i, int j, TrieNode node, String word, Set<String> result){
        // Base cases to stop the recursion:
        // 1. If we are out of bounds on the board.
        // 2. If the cell has been visited before.
        // 3. If there is no matching child node in the Trie for the current character.
        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || flag[i][j] || node.child[board[i][j] - 'a'] == null){
            return;
        }
        
        flag[i][j] = true; // Mark the cell as visited.
        node = node.child[board[i][j] - 'a']; // Move to the corresponding child node.
        
        if(node.isWord){
            result.add(word + board[i][j]); // If a word ends at this node, add it to the result set.
        }
        
        // Recursively explore neighboring cells in all four directions.
        search(board, i-1, j, node, word + board[i][j], result);
        search(board, i+1, j, node, word + board[i][j], result);
        search(board, i, j-1, node, word + board[i][j], result);
        search(board, i, j+1, node, word + board[i][j], result);
        
        flag[i][j] = false; // Mark the cell as unvisited when backtracking.
    }
}