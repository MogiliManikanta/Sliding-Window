class Solution {
    public int numRescueBoats(int[] people, int limit) {
      /*Time Complexity -> O(NLog(N))
      Space Complexity ->O(1)*/
      
      Arrays.sort(people);
      int left=0;
      int right=people.length-1;
      int count=0;
      while(left<=right){
          if(people[left]+people[right]<=limit){
              left++;
              right--;
          }
          else{
              right--;
          }
          count++;
      }
      return count;
    //count sort
    // int[] count =  new int[limit+1];
    // for(int p:people){
    //     count[p]++;
    // }
    // int index=0;
    // for(int val=0;val<=limit;val++){
    //     while(count[val]-->0){
    //         people[index++]=val;
    //     }
    // }
    //   int left=0;
    //   int right=people.length-1;
    //   int count1=0;
    //   while(left<=right){
    //       if(people[left]+people[right]<=limit){
    //           left++;
    //           right--;
    //       }
    //       else{
    //           right--;
    //       }
    //       count1++;
    //   }
    //   return count1;

    }
}