class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=1;i<=numRows;i++) {
            list.add(generateRows(i));
        }
        return list;
    }
    public List<Integer> generateRows(int row){
        int ans=1;
        List<Integer> temp = new ArrayList<>();
        temp.add(ans);
        for(int column=1;column<row;column++){
            ans=ans*(row-column);
            ans/=column;
            temp.add(ans);
        }
        return temp;
    }
}