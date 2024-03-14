class Solution {
    public String frequencySort(String s) {
        // Step 1: Count the frequency of each character in the string
        Map<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        // Step 2: Create a bucket array to group characters by their frequencies
        List<Character>[] bucket = new List[s.length()+1];
        for(char key :map.keySet()){
            int frequency = map.get(key);
            if(bucket[frequency]==null){
                bucket[frequency]=new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        // Step 3: Construct the sorted string by iterating through the bucket array
        StringBuilder sb = new StringBuilder();
        for(int i=bucket.length-1;i>=0;i--){
            if(bucket[i]!=null){
                for(char c : bucket[i]){
                    for(int j=0;j<i;j++){
                        sb.append(c); // Append the character 'i' times to the result string
                    }
                }
            }
        }
        
        // Step 4: Return the sorted string
        return sb.toString();
    }
}
