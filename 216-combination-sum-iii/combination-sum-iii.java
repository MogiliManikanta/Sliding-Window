class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        function(1, k, n, temp, list);

        return list;
    }

    public void function(int index, int k, int n, List<Integer> temp, List<List<Integer>> list) {
        if(temp.size() == k) {
            if(n == 0) {
                list.add(new ArrayList<>(temp));
            }
            return;
        }

        for(int i = index; i<=9; i++) {
            if(n >= i) {
                temp.add(i);
                function(i+1, k, n-i, temp, list);
                temp.remove(temp.size()-1);
            } else {
                break;
            }
        }
    }
}