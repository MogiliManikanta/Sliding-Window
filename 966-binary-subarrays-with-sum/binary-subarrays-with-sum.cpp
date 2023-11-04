class Solution {
public:
     int numSubarraysWithSum(vector<int>& A, int S) {
        int p=0, i=0, r=0, c=0;
        for(int j = 0; j < A.size(); j++){
            c+= A[j];
            while(c > S && i < j){
                p=0;
                c -= A[i];
                i++;
            }
            while(A[i] == 0 && i < j){
                p++;
                c -= A[i];
                i++;
            }
            if(c == S) r += p+1;
        }
        return r;
    }    
};