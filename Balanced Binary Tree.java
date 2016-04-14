/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
 

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
     
    private int check(TreeNode root) {
        if (root == null)  return 0;
        int left = check(root.left);
        int right = check(root.right);
        if (left == -1 || right == -1 || Math.abs(right-left) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        return (check(root) != -1);
    }
}
