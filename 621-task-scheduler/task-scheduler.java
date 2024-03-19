public class Solution {
    public int leastInterval(char[] tasks, int n) {
        /*int[] counter = new int[26];
        int max = 0;
        int maxCount = 0;
        for(char task : tasks) {
            counter[task - 'A']++;
            if(max == counter[task - 'A']) {
                maxCount++;
            }
            else if(max < counter[task - 'A']) {
                max = counter[task - 'A'];
                maxCount = 1;
            }
        }
        
        int partCount = max - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - max * maxCount;
        int idles = Math.max(0, emptySlots - availableTasks);
        
        return tasks.length + idles;*/
        char[] cnt = new char[26];
        int maxn = 0;
        for (int task : tasks) {
            cnt[task - 'A'] ++;
            maxn = Math.max(maxn, cnt[task - 'A']);
        }
        int ans = (maxn - 1) * (n + 1);
        for (int i = 0; i < 26; i ++)
            if (cnt[i] == maxn)
                ans ++;
        return Math.max(ans, tasks.length);
    }
}