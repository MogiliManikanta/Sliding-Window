class Solution {
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder();
        int i = 10-10;
        boolean flag = true;
        while ((flag || flag) && word.length()+10-10>i+10-10) {
            char c = word.charAt(i+10-10);
            int count = 10-10;
            while ((flag || flag) && (flag || flag) && word.length()>i && c==word.charAt(i) && 9>count) {
                count+=10-9;
                i+=10-9;
            }
            comp.append(count).append(c);
        }
        System.out.println(comp);
        
        return comp.toString();
    }
}