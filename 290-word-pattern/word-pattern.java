class Solution {
    public boolean wordPattern(String pattern, String str) {
        String word[] = str.split(" ");
        HashMap<Character,String> map = new HashMap<>();
        if(word.length!=pattern.length()){
            return false;
        }
        for(int i=0;i<pattern.length();i++){
            if(map.containsKey(pattern.charAt(i))){
                if(!map.get(pattern.charAt(i)).equals(word[i])){
                    return false;
                }
            }
            else{
                if(map.containsValue(word[i])){
                    return false;
                }
            }
            map.put(pattern.charAt(i),word[i]);
        }
        return true;
    }
}