class Solution {
public:
    int maxSubarrayLength(vector<int>& nums, int k) {
        int i = 0;
        int j = 0;
        int n = nums.size();
        unordered_map<int,int> ump;
        
        int ans = 0;
        while(j < n)
        {
            ump[nums[j]]++;
            if(ump[nums[j]] > k)
            {
                while(i<j and ump[nums[j]] > k)
                {
                    if(ump[nums[i]] == 1)
                        ump.erase(nums[i]);
                    else
                        ump[nums[i]]--;
                    i++;
                }
            }
            ans = max(ans, j-i+1);
            
            j++;
        }
        
        return ans;
    }

};
// class Solution {
// public:
//     int maximum(int i, int j) {
//         return i > j ? i : j;
//     }
//     int maxSubarrayLength(vector<int>& nums, int k) {
//         int start = 0, end = 0, result = 0;
//         unordered_map<int, int> mp;
//         for (; end < nums.size(); ++end) {
//             mp[nums[end]]++;
//             if (mp[nums[end]] < k) {
//                 continue;
//             } else {
//                 for (; start < end && mp[nums[end]] > k; ++start) {
//                     mp[nums[start]] == 1 ? mp.erase(nums[start]) : --mp[nums[start]];
//                 }
//             }
//             result = maximum(result, end - start + 1);
//         }
//         return result;
//     }
// };

