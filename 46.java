//Given a collection of distinct numbers, return all possible permutations.


public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(list, temp, nums);
        
        return list;
    }
    
    private void helper(List<List<Integer>> list, List<Integer> temp, int[] num) {
        if (temp.size() == num.length) {
            list.add(temp);
        }
        else {
            for (int i = 0; i < num.length; i++) {
                if (temp.contains(num[i])) continue;
                temp.add(num[i]);
                helper(list, temp, num);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
