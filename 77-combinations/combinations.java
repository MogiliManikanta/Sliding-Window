class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<k;i++){
            list.add(0);
        }

        int i=0;
        while(i>=0){
            list.set(i,list.get(i)+1);
            /*      Move index to the left if the element
                    at index i has exceeded n.
            */
            if(list.get(i)>n-k+i+1){ 
                i--;
            }
            /* If the index is at the end of the vector
             * c, then (because the other conditions are
             * obeyed), we know we have a valid combination,
             * so push it to our ans vector<vector<>>
             */

            else if(i==k-1){
                result.add(new ArrayList<>(list));
            }
            /* Move index to the right and set the
             * element at that index equal to the
             * element at the previous index.
             * 
             * Because of the increment at the beginning
             * of this while loop, we ensure that the
             * element at this index will be at least
             * one more than its neighbor to the left.
             */
            else{
                i++;
                list.set(i,list.get(i-1));
            }
        }
        return result;
    }
}