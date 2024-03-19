public class Solution {
    final int MOD = 1000000007;

    public int uniqueLetterString(String s) {
        int n = s.length();
        List<List<Integer>> hashmap = new ArrayList<>(26);

        // Initialize lists with -1 for all keys
        for (int i = 0; i < 26; ++i) {
            List<Integer> list = new ArrayList<>();
            list.add(-1);
            hashmap.add(list);
        }

        // Store all indices
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            hashmap.get(c - 'A').add(i);
        }

        // Push the length of the string for all keys at the end of each value list
        for (int i = 0; i < 26; ++i) {
            List<Integer> list = hashmap.get(i);
            list.add(n);
        }

        long count = 0;
        for (int i = 0; i < 26; ++i) {
            List<Integer> list = hashmap.get(i);
            for (int j = 1; j < list.size() - 1; ++j) {
                count += (list.get(j) - list.get(j - 1)) * (list.get(j + 1) - list.get(j));
            }
        }

        return (int) (count % MOD);
    }
}