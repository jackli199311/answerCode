class Solution {
public:
    bool wordPattern(string pattern, string str) {
        map<char, int> pmap;
        map<string, int> smap;
        
        istringstream in(str);
        int i=0;
        int n=pattern.size();
        
        for (string word;in>>word;++i)
        {
            if (i==n||pmap[pattern[i]]!=smap[word])
                return false;
            pmap[pattern[i]]=smap[word]=i+1;
            
        }
        return i==n;
        
    }
};
