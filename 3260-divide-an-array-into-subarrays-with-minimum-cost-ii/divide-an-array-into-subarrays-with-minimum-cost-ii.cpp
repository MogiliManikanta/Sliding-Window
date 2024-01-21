class Solution {  
public:  
    long long minimumCost(vector<int>& a, int k, int dist) {  
        long long int ans=a[0];  
        a.erase(a.begin());  
        int n=a.size();  
        k--;  
        dist++;  
        multiset<long long int>big,small;  
        long long int ts=0,sum;  
        for(int i=0;i<dist;i++){  
            small.insert(a[i]);  
            ts+=a[i];  
        }  
        int dif=dist-k;  
        while(dif--){  
            int tp=*small.rbegin();  
            ts-=tp;  
            big.insert(tp);  
            small.erase(small.find(tp));  
        }  
        sum=ts;  
        cout<<sum<<endl;  
        for(int i=1;i<=n-dist;i++){  
            if(small.find(a[i-1]) !=small.end()){  
                ts-=a[i-1];  
                small.erase(small.find(a[i-1]));  
                if(big.size()!=0){  
                    int tp=*big.begin();  
                    ts+=tp;  
                    small.insert(tp);  
                    big.erase(big.find(tp));  
                }  
            }else{  
                big.erase(big.find(a[i-1]));  
            }  
            int lst=*small.rbegin();  
            int nn=a[i+dist-1];  
            if(small.size()<k){  
                ts+=nn;  
                small.insert(nn);  
            }else{  
                if(nn<lst){  
                    ts-=lst;  
                    ts+=nn;  
                    big.insert(lst);  
                    small.erase(small.find(lst));  
                    small.insert(nn);  
                }else{  
                    big.insert(nn);  
                }  
            }  
            sum=min(sum,ts);  
        }  
        return sum+ans;  
    }  
};
