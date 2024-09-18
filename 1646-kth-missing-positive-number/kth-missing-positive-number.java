class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid=(low+(high-low)/2);
            int missing = arr[mid]-(mid+1);
            if(missing<k) low=mid+1;
            else high=mid-1;
        }
        return high+1+k;
        // arr[high]+more
        // more = k-missing
        // missing=arr[high]-(high+1) = arr[high]-high-1
        // arr[high]+k-missing
        // arr[high]+k-arr[high]+high+1
        // k+high+1
        // k+low
    }
    // arr =[4,7,9]
    // high=points to -1
    // so high might not be our answer
    // [2,3,4,7,11] k=5
    // high=7 but our answer is 9 so we need arr[high]+more
    // lies in between 

}
//  int numberMissingInhigh= arr[high] - (high+1);
       // int moreNummberRequired= k-numberMissingInhigh;
        // result= arr[high]+moreNummberRequired 
       //.      arr[high] + k-numberMissingInhigh;
       //         arr[high] + k- ( arr[high] - (high+1));
       //       arr[high] + k-  arr[high] + high+1 
       // high + 1+ k
       // low +k 
    //   return low +k ;





    // 2,3,4,7,11
    // 0 1 2 3  4    
    //     mid = 4
    //     missing = 11 - (4+1) = 6    potential = 3

    // 7 + (k - 7-(3+1))







    // binary Search 
    //     index -> Number
    //     0->1
    //     1->2
    //     ....
    //     5->6
    //     if arr[m]!= m+1 there have been missing Numbers
    //         missing numbers at m is arr[m]-(m+1)
    //         if this <k then look right as there need to be more missing Numbers 
    //         else look left
    //     when the loop ends where l>r, return l+k
        

        // arr[r]-(r+1) numbers missing so far
        // k-(arr[r]-(r+1)) missing numbers left needed
        // k-(arr[r]-(r+1))+arr[r]  
        // return k+r+1;