class Solution {
    List<String> path = new ArrayList<>();
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtrack(0,s,path,result);
        return result;
    }
    public void backtrack(int index,String s,List<String>path,List<List<String>>result){
        if(index==s.length()){// if index reaches thelength of the string add to the result
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                path.add(s.substring(index,i+1));//add index to i+1
                backtrack(i+1,s,path,result);// start with i+1
                path.remove(path.size()-1);// to backtrack we are removing the element
            }
        }
    }
    public boolean isPalindrome(String s,int left,int right){
        while(left<=right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            right--;
            left++;
        }
        return true;
    }
}
/** 
1. Choose
2. Explore
3. Unchoose


 */