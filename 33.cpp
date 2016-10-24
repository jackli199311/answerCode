//Search in Rotated Sorted Array
class Solution {
public:
    int search(vector<int> &A, int target) {
        // write your code here
        int n = A.size();
        int low = 0, high = n - 1;
        while (low < high) {
            int mid = (high - low)/2 + low;
            if (A[mid] > A[high]) {
                low = mid + 1;
            }
            else 
                high = mid;
        }
        
        int piv = low;
        low = 0, high = n - 1;
        while (low <= high) {
            int mid = (high - low)/2 + low;
            int trueMid = (piv + mid)%n;
            if (A[trueMid] == target) {
                return trueMid;
            } else if (A[trueMid] < target){
                low = mid + 1;
            }
            else {
                high = mid -1;
            }
        }
        
        return -1;
    }
    
};
