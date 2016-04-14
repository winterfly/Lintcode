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
 
class Result{
    int any2root;
    int any2any;
    Result(int a, int b) {
        any2root = a;
        any2any = b;
    }
}
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    private Result maxPath(TreeNode root) {
        if (root == null) {
            return new Result(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }
        Result left = maxPath(root.left);
        Result right = maxPath(root.right);
        int any2root = Math.max(Math.max(left.any2root, right.any2root), 0) 
                        + root.val;
        int any2any = Math.max(left.any2any, right.any2any);
        any2any = Math.max(any2any, Math.max(0, left.any2root) 
                        + Math.max(0, right.any2root) + root.val);
        return new Result(any2root, any2any);
    }
     
    public int maxPathSum(TreeNode root) {
        return maxPath(root).any2any;
    }
}
