class Solution {
        public boolean isPathCrossing(String path) {
        Set<Integer> seen = new HashSet<>();
        seen.add(0);
        for (int i = 0, x = 0, y = 0; i < path.length(); ++i) {
            char c = path.charAt(i);
            if (c == 'N') {
                y += 1;
            }else if (c == 'S') {
                y -= 1;
            }else if (c == 'E') {
                x -= 1;
            }else {
                x += 1;
            }
            if (!seen.add(x * 20001 + y)) {
                return true;
            }
        }
        return false;
    }
}