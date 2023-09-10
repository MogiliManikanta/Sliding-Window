class FreqStack {
    HashMap<Integer,Integer>freq = new HashMap<>();
    HashMap<Integer,Stack<Integer>>map = new HashMap<>();
    int maxFreq =0;
    public FreqStack() {
        
    }
    
    public void push(int val) {
        int f = freq.getOrDefault(val,0)+1;
        freq.put(val,f);
        maxFreq=Math.max(maxFreq,f);
        if(!map.containsKey(f)){
            map.put(f,new Stack<Integer>());
        }
        map.get(f).add(val);
    }
    
    public int pop() {
        int x = map.get(maxFreq).pop();
        freq.put(x,maxFreq-1);
        if(map.get(maxFreq).size()==0){
            maxFreq--;
        }
        return x;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */