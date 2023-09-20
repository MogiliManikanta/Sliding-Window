class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int start=0,end=0,product=1;// initalize the end start product values
        int count=0; // to store the result
        if(k<=1){
            return 0;
        }
        while(end<nums.length){
            product*=nums[end]; // product the 
            while(start<nums.length && product>=k){
                product/=nums[start];
                start++;
            }
            if(product<k){
                count+=end-start+1;
            }
            end++;
        }
        return count;
    }
}
/**
// this res will have number of subarrays(windows) possible
			/* I/p: [ 10, 5, 2, 6 ], k = 100
				
				right = left = 0;
				prod = prod * 10 = 10; 
				res = res + 0 - 0 + 1 = 1;  // subarrays - [ 10 ]
				
				right = 1;
				prod = prod * 5 = 10 * 5 = 50
				res = res + 1 - 0 + 1 = 1 + 1 - 0 + 1 = 3; // subarrays - [ 10 ], [ 5 ], [ 10, 5 ]
				
				right = 2;
				prod = prod * 2 = 50 * 2 = 100;
				prod > k;
				prod = prod / nums[left] = prod / nums[0] = 100 / 10 = 10;
				left++;
				res = res + 2 - 1 + 1 = 3 + 2 = 5; // subarrays - [ 10 ], [ 5 ], [ 10, 5 ], [ 2 ], [ 5, 2 ] 
			*/