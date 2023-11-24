class Solution {
    public int findCircleNum(int[][] matrix) {
        ArrayList<ArrayList<Integer>>list = new ArrayList<>();
        int n=matrix.length;
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==1 && i!=j){
                    list.get(i).add(j);
                    list.get(j).add(i);
                }
            }
        }
        boolean[] vis = new boolean[n];
        int cnt=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                cnt++;
                dfs(list,i,vis);
            }
        }
        return cnt;
    }
    void dfs(ArrayList<ArrayList<Integer>>list,int node,boolean[] vis){
        vis[node]=true;
        for(Integer it : list.get(node)){
            if(!vis[it]){
                dfs(list,it,vis);
            }
        }
    }
}