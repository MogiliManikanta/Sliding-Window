class Solution {
    private List<String> ans=new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        String[] mapping = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        helper(digits,0,mapping,"");
        return ans;
    }
    public void helper(String digit,int index,String[] mapping,String curr){
        if(digit.length()==0){
            return;
        }
        if(index==digit.length()){
            ans.add(curr);
            return;
        }
        int num=digit.charAt(index) - '0';
        String str=mapping[num];
        for(int i=0;i<str.length();i++){
            curr+=str.charAt(i);
            helper(digit,index+1,mapping,curr);
            curr=curr.substring(0,curr.length()-1);//removing from the string
        }
    }

}