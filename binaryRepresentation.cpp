//Given a (decimal - e.g. 3.72) number that is passed in as a string, return the binary representation that is passed in as a string. If the fractional part of the number can not be represented accurately in binary with at most 32 characters, return ERROR.
#include <strstream>
class Solution {
public:
    /**
     *@param n: Given a decimal number that is passed in as a string
     *@return: A string
     */
    string itoa(int n) {
        strstream ss;
        string s;
        ss << n;
        ss >> s;
        return s;
    }
    string binaryRepresentation(string n) {
        // wirte your code here
        int intPart = atoi(n.substr(0, n.find(".")).c_str());
        double decPart = atof(n.substr(n.find("."),n.size() - n.find(".")).c_str());
        string int_string = "";
        while (intPart > 0) {
            int r = intPart % 2;
            intPart >>= 1;
            int_string = itoa(r) + int_string;
        }
        if (int_string.size() == 0)
            int_string = "0";
        if (n.substr(n.find("."), n.size() - n.find(".")) == ".0")
            return int_string;
        string dec_string = "";
        while (decPart > 0) {
            if (dec_string.size() > 32) return "ERROR";
            if (decPart == 1) {
                dec_string += itoa(1);
                break;
            }
            
            double r = decPart * 2;
            if (r >= 1) {
                dec_string += "1";
                decPart = r - 1;
            } else {
                dec_string += "0";
                decPart = r;
            }
            
        }
        return int_string + "." + dec_string;
    }
    
};
