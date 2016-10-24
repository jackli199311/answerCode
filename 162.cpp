//Find Peak Element
class Solution {
public:
    int findPeakElement(vector<int>& A) {
        int low = 0, high = A.size() - 1;
        while (low < high - 1) {
            int mid = (high - low)/2 + low;
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1])
                return mid;
            if (A[mid] > A[mid - 1])
                low = mid + 1;
            else 
                high = mid - 1;
        } 
        return A[low] > A[high] ? low : high;
        
    }
};
