class Solution {
    public int minDeletions(String s) {
        int[] count = new int[26];
        int n = s.length();
        for(int i=0;i<n;i++){
            count[s.charAt(i)-'a']++;
        }
        int result=0;
        HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<26;i++){
            while(count[i]>0 && !set.add(count[i])){
                --count[i];
                result++;
            }
        }
        return result;
    }
}