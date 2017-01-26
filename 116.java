//Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

//Initially, all next pointers are set to NULL.

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode startNode = root;
        while (startNode != null) {
            TreeLinkNode temp = startNode;
            while (temp != null) {
                if (temp.left != null) {
                    temp.left.next = temp.right;
                }
                if (temp.next != null && temp.right != null) {
                    temp.right.next = temp.next.left;
                }
                temp = temp.next;
            }
            startNode = startNode.left;
        }
        
    }
}
