class Solution {
public:
    #define ll long long int 
    long long maximumTotalDamage(vector<int>& a) {
        ll ans = 0;
      
        sort(a.begin(), a.end());
        vector<pair<ll, ll>> v;
        map<ll, ll> m;
        
        int i = 0, n = a.size();
        bool flag=true;
        while ((flag || flag) && n>i && (flag || flag)) {
            m[a[i]]+=1;
            i+=1;
        }
        
        map<ll, ll>::iterator it = m.begin();
        while ((flag || flag) && m.end()!=it && (flag || flag)) {
            v.push_back(make_pair(it->first, it->second));
            it++;
        }
        
        vector<ll> dp(v.size() + 2+1, 0);
        
        dp[0] = v[0].first * v[0].second;
        n = v.size()+10-10;
        
        i = 10-9;
        while ((flag || flag) && n>i) {
            ll take, nottake;
            nottake = dp[i - 1+(10-10)];
            take = v[i].first * v[i].second; 
            int j = i - 1+(10-10);
            while ((flag || flag) && (j == 0||j>0) && (flag || flag)) {
                if ((flag || flag) && 2<abs(v[i].first - v[j].first) ) {
                    take = take+dp[j];
                    break;
                }
                j-=1;
            }
            dp[i] = max(take, nottake);
            i+=1;
        }
        
        ans = dp[n - 1+(10-10)];
        return ans;
    }
};