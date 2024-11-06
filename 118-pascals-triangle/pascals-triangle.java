class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            list.add(generateRows(i));
        }
        return list;
    }
    public List<Integer> generateRows(int row){
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        int ans=1;
        for(int col=1;col<row;col++){
            ans=ans*(row-col);
            ans/=col;
            temp.add(ans);
        }
        return temp;
    }
}