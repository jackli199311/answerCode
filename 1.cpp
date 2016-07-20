class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> numsMap;
        vector<int> result;

        for (int i = 0; i < nums.size(); ++i)
        {
            int addend = target - nums[i];
            if (numsMap.find(addend) != numsMap.end())
            {
                result.push_back(numsMap[addend]+1);
                result.push_back(i+1);

                return result;
            }

            numsMap[nums[i]] = i;
        }
    }
};
