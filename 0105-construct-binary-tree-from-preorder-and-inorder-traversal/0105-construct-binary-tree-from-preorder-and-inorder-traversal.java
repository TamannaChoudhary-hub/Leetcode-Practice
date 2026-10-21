
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inmap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inmap.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preorder.length - 1,
                         inorder, 0, inorder.length - 1, inmap);
    }

    public TreeNode buildTree(int[] preorder, int prestart, int preend,
                              int[] inorder, int instart, int inend,
                              Map<Integer, Integer> inmap) {

        if (prestart > preend || instart > inend) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[prestart]);

        int inroot = inmap.get(root.val);
        int numsleft = inroot - instart;

        root.left = buildTree(preorder,
                              prestart + 1,
                              prestart + numsleft,
                              inorder, instart, inroot - 1, inmap);

        root.right = buildTree(preorder,
                               prestart + numsleft + 1,
                               preend,
                               inorder, inroot + 1, inend, inmap);

        return root;
    }
}
