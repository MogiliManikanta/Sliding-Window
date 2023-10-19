class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] ans = new int[spells.length];
        Arrays.sort(potions);
        
        for (int i = 0; i < spells.length; i++) {
            int spell = spells[i];
            int target = (int) Math.ceil((double) success / ((double) spell));
            int search = binarySearch(potions, target);
            ans[i] = potions.length - search;
        }

        return ans;
    }

    private int binarySearch(int[] potions, int target) {
        int l = 0;
        int r = potions.length - 1;
        int smallestIndex = Integer.MAX_VALUE;

        if (target > potions[r])
            return r + 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (potions[mid] >= target) {
                smallestIndex = mid;
                r = mid - 1;
            }
            
            else 
                l = mid + 1;
        }

        return smallestIndex;
    }
}