class Solution {
    public int findMinDifference(List<String> list) {
        int l = list.size();
        boolean[] arr = new boolean[24*60];
        for(int i=0;i<l;i++){
            String[] t=list.get(i).split(":");
            int x= Integer.parseInt(t[0]);
            int y=Integer.parseInt(t[1]);
            if(arr[x*60+y]){
                return 0;
            }
            arr[x*60+y]=true;
        }
        // wherever there is the position of minute according to index, we marked true in boolean array of total 1440 minutes(1 Day)
        int mindiff = Integer.MAX_VALUE;
        int prev=-24*60; // because we dont know the position of first true element
        int i=0;
        while(i<arr.length){
            if(arr[i]){
                mindiff=Math.min(mindiff,i-prev);
                prev=i;
            }
            i++;
        }
        int check=0; // extra condition to check last minute value with the very first occuring minute value, because that also can generate min diff.
        int j=0;
        while(true){
            
            if(arr[j]){
                check=1440+j;
                break;
            }
            j++;
        }
        return Math.min(mindiff,check-prev);
    }
}