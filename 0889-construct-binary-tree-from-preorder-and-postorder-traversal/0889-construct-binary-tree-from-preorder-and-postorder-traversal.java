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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        Map<Integer, Integer> postmap = new HashMap<>();

        for (int i = 0; i < postorder.length; i++) {
            postmap.put(postorder[i], i);
        }

        return buildTree(preorder, 0, preorder.length - 1,
                         postorder, 0, postorder.length - 1, postmap);
    }

    private TreeNode buildTree(int[] preorder, int prestart, int preend,
                               int[] postorder, int poststart, int postend,
                               Map<Integer, Integer> postmap) {

        if (prestart > preend) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[prestart]);

        if (prestart == preend) {
            return root;
        }

        int leftRoot = preorder[prestart + 1];
        int postIndex = postmap.get(leftRoot);
        int numsleft = postIndex - poststart + 1;

        root.left = buildTree(preorder,
                              prestart + 1,
                              prestart + numsleft,
                              postorder,
                              poststart,
                              postIndex,
                              postmap);

        root.right = buildTree(preorder,
                               prestart + numsleft + 1,
                               preend,
                               postorder,
                               postIndex + 1,
                               postend - 1,
                               postmap);

        return root;
    }
}
