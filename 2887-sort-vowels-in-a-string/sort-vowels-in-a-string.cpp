class Solution {
public:
    string sortVowels(string s) {
        int n=s.size();
        vector<char>v;
        string t="aeiouAEIOU";
        for(int i=0;i<n;i++){
            for(int j=0;j<10;j++){
                if(s[i]== t[j])v.push_back(s[i]);
            }
        }
        
        sort(v.begin(),v.end());
        
        int k=0;
         for(int i=0;i<n;i++){
            for(int j=0;j<10;j++){
                if(s[i]== t[j]){
                    s[i]=v[k++];
                    break;
                }
            }
        }
        
    
        return s;
    }
};