// class Solution {
//     public List<List<Integer>> subsets(int[] nums) {
//         List<List<Integer>> result = new ArrayList<>();
//         List<Integer> list = new ArrayList<>();
//         subsetHelper(nums,0,list,result);
//         return result;
//     }

//     public void subsetHelper(int[] nums,int idx,List<Integer>list,List<List<Integer>>result){
//         result.add(new ArrayList<>(list));
//         for(int j=idx;j<nums.length;j++){
//             list.add(nums[j]);
//             subsetHelper(nums,j+1,list,result);
//             list.remove(list.size()-1);
//         }
//     }
// }

// class Solution {
//     public List<List<Integer>> subsets(int[] nums) {
//         List<List<Integer>> result = new ArrayList<>();
//         result.add(new ArrayList<>());
//         for(int num : nums){
//             int n = result.size();
//             for(int j=0;j<n;j++){
//                 List<Integer> list = new ArrayList<>(result.get(j));
//                 list.add(num);
//                 result.add(list);
//             }
//         }
//         return result;
//     }
    /**Using [1, 2, 3] as an example, the iterative process is like:

Initially, one empty subset [[]]
Adding 1 to []: [[], [1]];
Adding 2 to [] and [1]: [[], [1], [2], [1, 2]];
Adding 3 to [], [1], [2] and [1, 2]: [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]

 */


public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        int p =1<<n;
        for(int i=0;i<p;i++){
            List<Integer>list=new ArrayList<>();
            for(int j=0;j<n;j++){
                if((i>>j & 1) == 1){
                    list.add(nums[j]);
                }
            }
            result.add(list);
        }
        return result;
    }
}