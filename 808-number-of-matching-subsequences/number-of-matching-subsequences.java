class Node {
    String word;
    int index;
    Node(String word, int index) {
        this.word = word;
        this.index = index;
    }
}
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        // Create an array of ArrayLists to store nodes for each starting character
        ArrayList<Node>[] buckets = new ArrayList[26];
        for (int i = 0; i < 26; ++i) buckets[i] = new ArrayList<>();

        // Populate buckets with the initial nodes of each word
        for (String word : words) {
            char startingChar = word.charAt(0);
            buckets[startingChar-'a'].add(new Node(word, 0));
        }

        // Initialize a variable to store the count of matching subsequences
        int ans = 0;

        // Iterate through each character in the string s
        for (char c : s.toCharArray()) {
            // Get the current bucket for the character c
            ArrayList<Node> currBucket = buckets[c-'a'];
            // Clear the current bucket for reuse
            buckets[c-'a'] = new ArrayList<>();

            // Iterate through nodes in the current bucket
            for (Node node : currBucket) {
                // Move the index to the next character in the word
                node.index += 1;

                // Check if the end of the word is reached
                if (node.index == node.word.length()) {
                    // If yes, increment the count of matching subsequences
                    ans += 1;
                } else {
                    // If no, get the next starting character and add the node to the corresponding bucket
                    char startingChar = node.word.charAt(node.index);
                    buckets[startingChar - 'a'].add(node);
                }
            }
        }

        // Return the final count of matching subsequences
        return ans;
    }
}
