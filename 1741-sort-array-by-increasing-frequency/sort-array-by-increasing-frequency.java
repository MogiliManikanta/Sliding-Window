class Solution {
    public int[] frequencySort(int[] nums) {
        int[] result = new int[nums.length];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i : nums) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }
        
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(hm.entrySet());
        list.sort((e1, e2) -> {
            if (e1.getValue().equals(e2.getValue())) {
                return e2.getKey().compareTo(e1.getKey());
            } else {
                return e1.getValue().compareTo(e2.getValue());
            }
        });
        
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            int key = entry.getKey();
            int value = entry.getValue();
            while (value-- > 0) {
                result[i++] = key;
            }
        }
        return result;
    }
}
