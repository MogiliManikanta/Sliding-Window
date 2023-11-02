class Solution {
    public int mySqrt(int x) {
        if(x==0) return 0;
        if(x==1) return 1;
        int left = 0;
    int right = x;
    
    while (left < right) {
        int mid = left + (right - left) / 2;
        
        if ((long)mid * mid <= x) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }
    
    return left - 1;
    }
}
/**  
  
  
  There's one thing I'd like to point out. Remember I say that we usually look for the minimal k value satisfying certain condition? But in this problem we are searching for maximal k value instead. Feeling confused? Don't be. Actually, the maximal k satisfying condition(k) is False is just equal to the minimal k satisfying condition(k) is True minus one. This is why I mentioned earlier that we need to decide which value to return, left or left - 1
  
  
  
  
  
  
   */