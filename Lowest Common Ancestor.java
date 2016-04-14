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
 
class Node {
    public TreeNode ancester;
    Node(TreeNode node) {
        ancester = node;
    }
}
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    private Node search(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null || root == A || root == B) {
            return new Node(root);
        }
        Node left = search(root.left, A, B);
        Node right = search(root.right, A, B);
        if (left.ancester != null && right.ancester != null) return new Node(root);
        if (left.ancester != null) return left;
        if (right.ancester != null) return right;
        return new Node(null);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        return search(root, A, B).ancester;
    }
}
