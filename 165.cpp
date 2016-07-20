class Solution {
public:
    int compareVersion(string version1, string version2) {
        istringstream st1(version1+'.'),st2(version2+'.');
        
        int ver1=0;
        int ver2=0;
        
        char dot='.';
        
        while (st1.good()||st2.good())
        {
            if (st1.good())
                st1>>ver1>>dot;
            if (st2.good())
                st2>>ver2>>dot;
                
            if (ver1>ver2)
                return 1;
            if (ver1<ver2)
                return -1;    
            ver1=ver2=0;
        }
        
        return 0;

    }
};
