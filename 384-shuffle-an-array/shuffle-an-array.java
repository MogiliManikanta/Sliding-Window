class Solution {
    int[] nums;
    public Solution(int[] nums) {
        this.nums=nums;
    }
    
    public int[] reset() {
        return nums;
    }
    
    public int[] shuffle() {
        int result[] = new int[nums.length];
        result = nums.clone();
        for(int i=0;i<nums.length;i++){
            int rand = (int)(Math.random()*(i+1));
            swap(result,i,rand);
        }
        return result;
    }
    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */