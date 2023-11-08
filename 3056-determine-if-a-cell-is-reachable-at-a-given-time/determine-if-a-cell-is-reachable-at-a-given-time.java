class Solution {
        public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int need = Math.max(Math.abs(sx - fx), Math.abs(sy - fy));
        return need > 0 ? t >= need : t != 1;
    }
}