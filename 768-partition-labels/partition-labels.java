class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char temp = s.charAt(i);
            map.put(temp,i); // storing the last index of the character in the map
        }
        List<Integer> result = new ArrayList<>(); // to store the result
        int prev = -1;
        int max=Integer.MIN_VALUE; // to store the maximum value of the substring
        for(int i=0;i<s.length();i++){
            char temp = s.charAt(i); // taking character from the string
            max=Math.max(max,map.get(temp)); // analyzing maximum length of substring from the previous and at present one
            if(max==i){ // if the maximum length reaches i then its enough string is come
                result.add(max-prev); // add the result to our max-prev
                prev=max; // previous to max
            }
        }
        return result; // return the result
    }
}
/**
    once see the discussion solution
    
    you can get the idea

 */