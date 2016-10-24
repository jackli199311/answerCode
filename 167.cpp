//Two Sum II - Input array is sorted

class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        vector<int> answer;
        int low = 0, high = numbers.size() - 1;
        while (low < high) {
            if (numbers[low] + numbers[high] > target) 
                high--;
            else if (numbers[low] + numbers[high] < target)
                low++;
            else {
                answer.push_back(low + 1);
                answer.push_back(high + 1);
                return answer;
            }
        }
        return answer;
    }
};
