class Solution {
public:
    bool isIsomorphic(string s, string t) {
        int si[128] = {0};
        int ti[128] = {0};
        int n = s.size();
        for(int i=0;i<n;i++){
            if(si[s[i]] != ti[t[i]])
                return false;
            si[s[i]] = i+1;
            ti[t[i]] = i+1;
        }
        return true;
    }
};