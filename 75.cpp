class Solution {
public:
    void sortColors(vector<int>& nums) {
        vector<int> count;
        count.push_back(0);
        count.push_back(0);
        count.push_back(0);

        vector<int> result;
        for (int i = 0;i<nums.size();i++){
            count[nums[i]]++;
        }
    
        for (int i = 0; i<3;i++){
            for (int j = 0; j< count[i];j++){
                result.push_back(i);
            }
        }
        nums = result;
    }
};
