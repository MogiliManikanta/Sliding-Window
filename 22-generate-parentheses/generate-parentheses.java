class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        String temp="";
        generate(n,0,0,temp);
        return result;
    }
    public void generate(int n,int open,int close,String temp)
    {
        if(temp.length()==2*n){
            result.add(temp);
        }
        if(open < n){
            generate(n,open+1,close,temp+"(");
        }
        if(close<open){
            generate(n,open,close+1,temp+")");
        }
    }
}
/*String .length is always equal 2*N

Open is always less than N


Close is always less than Open
done
done
*/