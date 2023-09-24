class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if(s.length()==0 || s==null){
            return new ArrayList<>();
        }
        ArrayList<Integer>result= new ArrayList<>();
        int len = words.length;
        int wordlen = words[0].length();
        HashMap<String,Integer>map = new HashMap<>();
        for(String l : words){
            map.put(l,map.getOrDefault(l,0)+1);
        }
        for(int i=0;i<=s.length()-len*wordlen;i++){
            HashMap<String,Integer>copy = new HashMap<>(map);
            for(int j=0;j<len;j++){
                String str = s.substring(i+j*wordlen,i+j*wordlen+wordlen);
                if(copy.containsKey(str)){
                    int count = copy.get(str);
                    if(count==1){
                        copy.remove(str);
                    }
                    else{
                        copy.put(str,count-1);
                    }
                    if(copy.isEmpty()){
                        result.add(i);
                        break;
                    }
                }
                else{
                    break;
                }
            }
        }
        return result;
    }
}