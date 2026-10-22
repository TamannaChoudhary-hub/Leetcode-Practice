/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int i = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        i = 0;
        return build(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode build(int[] preorder, int lower, int upper) {
        if (i == preorder.length) {
            return null;
        }

        int val = preorder[i];

        if (val < lower || val > upper) {
            return null;
        }

        TreeNode root = new TreeNode(val);
        i++;

        root.left = build(preorder, lower, val);
        root.right = build(preorder, val, upper);

        return root;
    }
}
