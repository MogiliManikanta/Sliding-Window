class Solution {
    public void nextPermutation(int[] nums) {
        int index1=-1;
        int index2=-1;
        int n = nums.length;
        for(int i=n-2;i>=0;i--){ // step1:Find the break-point, i: Break-point means the first index i from the back of the given array where arr[i] becomes smaller than arr[i+1].
            if(nums[i]<nums[i+1]){
                index1=i;
                break;
            }
        }
        if(index1==-1){  // step2:If such a break-point does not exist i.e. if the array is sorted in decreasing order, the given permutation is the last one in the sorted order of all possible permutations. So, the next permutation must be the first i.e. the permutation in increasing order.
            reverse(nums,0);
        }
        else{/*step3:If a break-point exists:Find the smallest number i.e. > arr[i] and in the right half of index i(i.e. from index i+1 to n-1) and swap it with arr[i].
Reverse the entire right half(i.e. from index i+1 to n-1) of index i. And finally, return the array.*/
            for(int i=n-1;i>=index1;i--){
                if(nums[i]>nums[index1]){
                    index2=i;
                    break;
                }
            }
            swap(nums,index1,index2);
            reverse(nums,index1+1);
        }
    }
    public void swap(int nums[],int idx1,int idx2){
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
    public void reverse(int nums[],int i){
        int low=i;
        int high=nums.length-1;
        while(low<high){
            swap(nums,low,high);
            low++;
            high--;
        }
    }
}
