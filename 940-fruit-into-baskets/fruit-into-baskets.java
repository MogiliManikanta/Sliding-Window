class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer>map=new HashMap<>();
        int left=0,right=0,maxi=0;
        while(right<fruits.length){
             map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
            if(map.size()>2){
                while(left<right && map.size()>2){
                    map.put(fruits[left],map.get(fruits[left])-1);
                    if(map.get(fruits[left])==0){
                        map.remove(fruits[left]);
                    }
                    left++;
                }
            }
            if(map.size()<=2){
                maxi=Math.max(maxi,right-left+1);
            }
            right++;
        }
        return maxi;
    }
}
/**class Solution {
    public int totalFruit(int[] fruits) {
        int maxi=0;
        for(int i=0;i<fruits.length;i++){
            Set<Integer> set = new HashSet<>();
            for(int j=i;j<fruits.length;j++){
                set.add(fruits[j]);
                if(set.size()>2){
                    break;
                }
                else{
                    maxi=Math.max(maxi,j-i+1);
                }
            }
        }
        return maxi;
    }
} */