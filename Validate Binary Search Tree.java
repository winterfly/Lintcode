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

class NodeMinMax{
    public int minVal;
    public int maxVal;
    public boolean isValidBST;
    public NodeMinMax(int minVal, int maxVal, boolean isValidBST) {
        this.minVal = minVal;
        this.maxVal = maxVal;
        this.isValidBST = isValidBST;
    }
}
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    private NodeMinMax isValid(TreeNode root) {
        if (root == null)  {
            return new NodeMinMax(0, 0, true);
        }
        
        if (root.left == null && root.right == null) {
            return new NodeMinMax(root.val, root.val, true);
        }
        
        int min = root.val, max = root.val;
        if (root.left != null) {
            NodeMinMax left = isValid(root.left);
            if (!left.isValidBST || left.maxVal >= root.val) {
                return new NodeMinMax(0, 0, false);
            }
            min = left.minVal;
        }
        
        if (root.right != null) {
            NodeMinMax right = isValid(root.right);
            if (!right.isValidBST || right.minVal <= root.val) {
                return new NodeMinMax(0, 0, false);
            }
            max = right.maxVal;
        }
        
        return new NodeMinMax(min, max, true);
    }
     
    public boolean isValidBST(TreeNode root) {
        return isValid(root).isValidBST;
    }
}
