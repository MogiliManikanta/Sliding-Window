class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> list = new ArrayList<>();
        for (int ele : asteroids) {
            if (ele > 0) {
                list.add(ele);
            } else {
                while (!list.isEmpty() && list.get(list.size() - 1) > 0 && list.get(list.size() - 1) < Math.abs(ele)) {
                    list.remove(list.size() - 1);  // Remove by index
                }
                if (!list.isEmpty() && list.get(list.size() - 1) == Math.abs(ele)) {
                    list.remove(list.size() - 1);  // Remove by index
                } else if (list.isEmpty() || list.get(list.size() - 1) < 0) {
                    list.add(ele);
                }
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
/**class Solution {
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
} */