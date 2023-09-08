class Solution {
public:
    bool isNStraightHand(vector<int>& hand, int groupSize) {
        
        map<int,int>mp;
        
        for(int i =0 ; i<hand.size() ; i++)
        {
            mp[hand[i]]++;
        }
        
        
        for(auto x= mp.begin() ; x!=mp.end(); )
        {
            if(x->second > 0)
            {
                for(int i = 0 ; i< groupSize ; i++)
                {
                    if(mp[x->first + i] > 0)
                        mp[x->first + i]--;
                    else
                        return false;
                }
            }
            else
            {
                x++;
            }
        }
        return true;
        
    }
};