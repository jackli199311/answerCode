class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        int aSize = 0;
        if (nums1.size() < nums2.size()) {
            aSize = nums2.size();
        }
        else {
            aSize = nums1.size();
        }
       map<int,int> ans;
       vector<int> answer;
        for (int i = 0; i < nums1.size(); i++) {
            ans[nums1[i]] = 1;
        }
        for (int j = 0; j < nums2.size(); j++) {
            if (ans[nums2[j]] == 1) {
                answer.push_back(nums2[j]);
                ans[nums2[j]] = 0;
            }
        }
        return answer;
        
        
    }
};
