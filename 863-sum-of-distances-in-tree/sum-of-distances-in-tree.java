class Solution {
    private int[] res,count;
    private ArrayList<HashSet<Integer>>tree;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        tree = new ArrayList<HashSet<Integer>>();
        res = new int[n];
        count = new int[n];
        for(int i=0;i<n;i++){
            tree.add(new HashSet<Integer>());
        }
        for(int[] e : edges){
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }
        postorder(0,-1);
        preorder(0,-1);
        return res;
    }

    private void postorder(int root,int pre){
        for(int i : tree.get(root)){
            if(i==pre){
                continue;
            }
            postorder(i,root);
            count[root]+=count[i];
            res[root]+=res[i]+count[i];
        }
        count[root]++;
    }

    private void preorder(int root,int pre){
        for(int i : tree.get(root)){
            if(i==pre){
                continue;
            }
            res[i] = res[root]-count[i]+(count.length-count[i]);
            preorder(i,root);
        }
    }
}