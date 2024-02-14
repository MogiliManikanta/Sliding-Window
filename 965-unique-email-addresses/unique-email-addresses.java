class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String>set = new HashSet<>();
        for(String s : emails){
            String[] parts = s.split("@");
            String[] local = parts[0].split("[//+]");
            set.add(local[0].replace(".","")+"@"+parts[1]);
        }
        return set.size();
    }
}