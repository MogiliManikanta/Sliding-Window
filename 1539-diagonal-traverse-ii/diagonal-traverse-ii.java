class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
    Map<Integer, LinkedList<Integer>> map = new HashMap<>();
    int count = 0, maxKey = 0;

    for(int i = 0; i < nums.size(); i++)
        for(int j = 0; j < nums.get(i).size(); j++){
            map.computeIfAbsent(i + j, x -> new LinkedList<>()).addFirst(nums.get(i).get(j));//add at starting 
            ++count;
            maxKey = Math.max(maxKey, i + j);//store max key
        }

    int[] res = new int[count]; count = 0;

    for(int i = 0; i <= maxKey; i++)
        for(int e : map.get(i))
            res[count++] = e;//populate the result array

    return res;
}
}