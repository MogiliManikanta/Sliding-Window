import static java.util.stream.IntStream.range;

class Solution {
    public int numSimilarGroups(String[] a) {
        int n = a.length;
        UnionFind uFind = new UnionFind(n);
        range(0, n).forEach(i -> range(i+1, n).filter(j -> isSimilar(a[i], a[j])).forEach(j -> uFind.union(i, j)));
        return uFind.getNumGroups();
    }

    private boolean isSimilar(String a, String b) {
        long count = IntStream.range(0, a.length()).filter(i -> a.charAt(i) != b.charAt(i)).count();
        return count == 2 || count == 0;
    }
}


public class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(int n) {
        this.parent = range(0, n).toArray();
        this.rank = new int[n];
    }

    public void union(int x, int y) {
        int root1 = find(x);
        int root2 = find(y);
        if(root1 == root2)
            return;
        if(rank[root1] > rank[root2])
            parent[root2] = root1;
        else
            parent[root1] = root2;
        if(rank[root1] == rank[root2])
            rank[root2] += 1;
    }

    public int find(int x) {
        while(parent[x] != x) x = parent[x];
        return x;
    }

    public int getNumGroups() {
        return (int)range(0, parent.length).filter(i -> i == parent[i]).count();
    }
}