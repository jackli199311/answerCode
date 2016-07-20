class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        int diff=accumulate(nums.begin(),nums.end(),0,bit_xor<int>());
        diff &=-diff;
        
        vector<int> temp={0,0};
        for (int num:nums){
            if ((diff&num)==0)
            {
                temp[0] ^=num;
            }
            else
            {
                temp[1] ^=num;
            }
        }
        return temp;
    }
};
