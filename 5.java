//Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String result = "";
        int curLength = 0;
        for(int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, i - curLength - 1, i)) {
                result = s.substring(i - curLength - 1, i + 1);
                curLength += 2;
            }
            else if (isPalindrome(s, i - curLength, i)) {
                result = s.substring(i - curLength, i + 1);
                curLength++;
            }
        }
        return result;
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        if (start < 0)
            return false;
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
    
}
