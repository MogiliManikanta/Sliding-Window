class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int ele : asteroids){
            if(ele > 0){
                st.push(ele);
              // System.out.println(ele);
            }
            else{   
                while(!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(ele)){   
                    st.pop();
                }      
                if(!st.isEmpty() && st.peek() == Math.abs(ele)){   
                    st.pop();
                }
                else if(st.isEmpty() || st.peek() < 0){   
                    st.push(ele);
                }
            }
        }   
        int[] arr = new int[st.size()];
        for(int i = st.size()-1 ; i>=0 ; i-- ){
            arr[i] = st.pop();
        }
        return arr;
    }
}