class Solution {
    private List<String> result = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        dfs(0,"",0,0,num,target);
        return result;
    }

    private void dfs(int i,String path,long ressoFar,long prevNum,String s,int target){
        if(i==s.length()){
            if(ressoFar==target){
                result.add(path);
                return;
            }
        }
        for(int j=i;j<s.length();j++){
            if(j>i && s.charAt(i)=='0'){
                break;
            }
            long currNum = Long.parseLong(s.substring(i,j+1));
            if(i==0){
                dfs(j+1,path+currNum,currNum,currNum,s,target);
            }
            else{
                dfs(j+1,path+"+"+currNum,ressoFar+currNum,currNum,s,target);
                dfs(j+1,path+"-"+currNum,ressoFar-currNum,-currNum,s,target);
                dfs(j+1,path+"*"+currNum,ressoFar-prevNum+prevNum*currNum,prevNum*currNum,s,target);
            }
        }
    }
}