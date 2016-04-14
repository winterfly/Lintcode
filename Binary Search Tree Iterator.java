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
 * Example of iterate a tree:
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */
public class BSTIterator {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode cur;
    //@param root: The root of binary tree.
    public BSTIterator(TreeNode root) {
        cur = root;
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        return (cur != null || !stack.isEmpty());
    }
    
    //@return: return next node
    public TreeNode next() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        TreeNode node = cur;
        cur = cur.right;
        return node;
    }
}
