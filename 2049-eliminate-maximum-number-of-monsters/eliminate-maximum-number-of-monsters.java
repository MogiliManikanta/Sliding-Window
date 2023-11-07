class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
    for (int i = 0; i < dist.length; ++i)
        dist[i] = (dist[i] - 1) / speed[i];
    Arrays.sort(dist);
    for (int i = 0; i < dist.length; ++i)
        if (i > dist[i])
            return i;
    return dist.length;
}
}