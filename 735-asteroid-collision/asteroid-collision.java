class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> list = new ArrayList<>();
        for (int ele : asteroids) {
            if (ele > 0) {
                list.add(ele);
            } else {
                while (!list.isEmpty() && list.get(list.size() - 1) > 0 && list.get(list.size() - 1) < Math.abs(ele)) {
                    list.remove(list.size() - 1);  // Remove by index
                }
                if (!list.isEmpty() && list.get(list.size() - 1) == Math.abs(ele)) {
                    list.remove(list.size() - 1);  // Remove by index
                } else if (list.isEmpty() || list.get(list.size() - 1) < 0) {
                    list.add(ele);
                }
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
