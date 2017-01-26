//Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).


/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    
    void helper(vector<vector<int>> &res, TreeNode* root, int level) {
        if (level == res.size())
            res.push_back(vector<int>());
        res[level].push_back(root -> val);
        if (root ->left != NULL)
            helper(res,root -> left,level+1);
        if (root ->right != NULL)
            helper(res,root -> right,level+1);
        
        
    }
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> res;
        if (root == NULL)
            return res;
        
        helper(res, root, 0);
        
        return res;
    }
};
