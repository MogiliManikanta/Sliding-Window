class MedianFinder {
    PriorityQueue<Integer>small = new PriorityQueue<Integer>(Collections.reverseOrder());
    PriorityQueue<Integer>large = new PriorityQueue<>();
    private boolean even = true;
    public void addNum(int num) {
        if(even){
            large.offer(num);
            small.offer(large.poll());
        }
        else{
            small.offer(num);
            large.offer(small.poll());
        }
        even=!even;
    }
    
    public double findMedian() {
        if(even){
            return (small.peek() + large.peek())/2.0;
        }
        else{
            return small.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */