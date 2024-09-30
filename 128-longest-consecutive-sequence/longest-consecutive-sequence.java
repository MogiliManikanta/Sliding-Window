class Solution {
    public int longestConsecutive(int[] a) {
        /*if(nums.length==0){
            return 0;
        }
        HashSet<Integer>set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        int result=Integer.MIN_VALUE;
        for(int i : nums){
            int left = i-1;
            int right = i+1;

            while(set.remove(left)){
                left--;
            }

            while(set.remove(right)){
                right++;
            }

            result = Math.max(result,right-left-1);
            if(set.isEmpty()){
                return result;
            }
        }
        return result;*/
        int n = a.length;
        if (n == 0)
            return 0;

        int longest = 1;
        Set<Integer> set = new HashSet<>();

        // put all the array elements into set
        for (int i = 0; i < n; i++) {
            set.add(a[i]);
        }

        // Find the longest sequence
        for (int it : set) {
            // if 'it' is a starting number
            if (!set.contains(it - 1)) {
                // find consecutive numbers
                int cnt = 1;
                int x = it;
                while (set.contains(x + 1)) {
                    x = x + 1;
                    cnt = cnt + 1;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }
}
