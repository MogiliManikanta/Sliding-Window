class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
       int result[] = new int[n];
       int stack[] = new int[n];
       int top=-1;
       for(int i=0;i<n;i++){
           while(top > -1 && temperatures[i]>temperatures[stack[top]]){
               int index = stack[top--];
               result[index]=i-index;
           }
           stack[++top]=i;
       }
       return result; 
    }
}