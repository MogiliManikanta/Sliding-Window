import java.util.Arrays;

public class Solution {
    private  int findMaxValue(int[] arr) {
        if (arr == null || arr.length == 0) {
            // Return some default value, for example, Integer.MIN_VALUE
            return Integer.MIN_VALUE;
        }

        int max = arr[0];  // Assume the first element is the maximum

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }
    public long countSubarrays(int[] arr, int k) {
        int n = arr.length;
        int m = findMaxValue(arr);
        int i = 0;
        int cnt = 0;
        long ans = 0;
        int l1=0; 
        for(int j=0;j<n;j++){
            if(arr[j]<m){
                  l1++;  
            }
            else if(arr[j]>m){
                    l1--;
            }
            else{
                cnt++;
            }
            if (cnt < k) {
                continue;
            }else{
                int k1=0;
                int k2=0;
                while (k1==0 && cnt >= k && k2==0) {
                    ans += n - j;
                    if(arr[i]<m){
                        l1++;  
                    }
                    else if(arr[i]>m){
                        l1--;
                    }
                    else{
                        cnt--;
                    }
                    i++;
                }
            }
        }

        return ans;
    }
}
