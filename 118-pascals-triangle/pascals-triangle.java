class Solution {
    public List<Integer> generateRow(int row) {
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1); //inserting the 1st element
        //calculate the rest of the elements:
        for (int col = 1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / col;
            ansRow.add((int)ans);
        }
        return ansRow;
    }
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        //store the entire pascal's triangle:
        for (int row = 1; row <= n; row++) {
            ans.add(generateRow(row));
        }
        return ans;
    }
}
// class Solution {
//     public List<Integer> generateRow(int n) {
//         ArrayList<Long> pre = new ArrayList<>();
//         long mod = 1000000007;
//         for (int i = 0; i < n; i++) {
//             ArrayList<Long> current = new ArrayList<>();
//             for (int j = 0; j < i + 1; j++) {
//                 if (j == i | j == 0) {
//                     current.add(1l);
//                 } else {
//                     long num = (pre.get(j) + pre.get(j - 1)) % mod;
//                     current.add(num);
//                 }
//             }
//             pre = current;
//         }
        
//         // Convert ArrayList<Long> to List<Integer>
//         List<Integer> result = new ArrayList<>();
//         for (Long num : pre) {
//             result.add(num.intValue());
//         }
//         return result;
//     }

//     public List<List<Integer>> generate(int n) {
//         List<List<Integer>> ans = new ArrayList<>();
//         // Store the entire Pascal's triangle:
//         for (int row = 1; row <= n; row++) {
//             ans.add(generateRow(row));
//         }
//         return ans;
//     }
// }
