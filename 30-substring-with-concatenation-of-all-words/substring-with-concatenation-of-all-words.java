class Solution {
    public List<Integer> findSubstring(String s, String[] l) {
       if(s==null || l==null){
           return new ArrayList<>();
       }
       List<Integer>res = new ArrayList<>();
       HashMap<String,Integer>map = new HashMap<>();
       for(String k : l){
           map.put(k,map.getOrDefault(k,0)+1);
       }
       System.out.println(map); 
       int len = l[0].length();
       for(int i=0;i<=s.length()-len*l.length;i++){
           HashMap<String,Integer>copy = new HashMap<>(map);
           for(int j=0;j<l.length;j++){
               String str = s.substring(i+j*len,i+j*len+len);
               if(copy.containsKey(str)){
                   int count = copy.get(str);
                   if(count==1){
                       copy.remove(str);
                   }
                   else{
                       copy.put(str,count-1);
                   }
                   if(copy.isEmpty()){
                       res.add(i);
                       break;
                   }
               }
               else{
                   break;
               }
           }
       }
       return res;
    }
}