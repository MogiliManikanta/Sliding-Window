class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            result.add(generateRows(i));
            // result.add(temp);
        }
        return result;
    }
    public List<Integer> generateRows(int row){
        List<Integer>temp=new ArrayList<>();
        temp.add(1);
        int res=1;
        for(int col=0;col<row;col++){
            res=res*(row-col);
            res=res/(col+1);
            temp.add(res);
        }
        return temp;
    }
}