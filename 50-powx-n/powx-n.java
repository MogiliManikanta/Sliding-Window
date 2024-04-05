class Solution {
    double myPow(double x, int n) {
        // Convert n to long to handle large values
        long nn = n;
        double ans = 1.0;
        
        // If n is negative, make it positive
        if (nn < 0) 
            nn = -1 * nn;
        
        // Iterative approach to compute power
        while (nn > 0) {
            if (nn % 2 == 1) {
                // If n is odd, multiply ans by x
                ans *= x;
                // Decrease nn by 1
                nn -= 1;
            } else {
                // If n is even, square x
                x *= x;
                // Divide nn by 2
                nn /= 2;
            }
        }
        
        // If n was negative, calculate the reciprocal
        if (n < 0) 
            ans = 1.0 / ans;
        
        // Return the result
        return ans;
    }
}

/**class Solution {
    /*public double myPow(double x, int n) {
        // Initialize the answer to 1
        double ans = 1;
        int m=n;
        if(n<0){
            n*=-1;
        }
        // Iterate until n becomes 0
        while (n > 0) {
            // If n is odd, multiply the answer by x and decrease n by 1
            if (n % 2 == 1) {
                ans *= x;
                n = n - 1;
            } else {
                // If n is even, divide n by 2 and square x
                n = n / 2;
                x = x * x;
            }
        }
        
        // Return the final answer
        return m<0 ? 1.0/ans:ans;
    }
    // for posititve/negative powers
    public  double myPow(double x, int n) {
        double ans = 1;
        int m = n;
        if(n==Integer.MIN_VALUE){
            return 0.0;
        }
        if(n<0){ n=n*-1;}
        while (n > 0) {
            if (n % 2 == 1) {
                ans = ans * x;
                n = n - 1;
            } else {
                n = n / 2;
                x = x * x;
            }
        }
        if(m<0){ans = 1/ans;}
        return ans;
    }
}

/*class Solution {
    public double myPow(double x, int n) {
     double result=1;
     long b = Math.abs((long)n);// given condition is -231 <= n <= 231-1

     while(b>0){
         if((b&1)==1){//equal to b%2==1
             result*=x;
         }
         x*=x;
         b>>=1;//equal b=b/2;
     }
     return n<0?1/result:result;    
    }
}*/
/** class Solution {
    public double myPow(double x, int n) {
     double result=1;
     long b = Math.abs((long)n);
     while(b>0){
         if((b%2)==1){
             result*=x;
         }
         x*=x;
         b/=2;
     }
     return n<0?1/result:result;    
    }
}*/