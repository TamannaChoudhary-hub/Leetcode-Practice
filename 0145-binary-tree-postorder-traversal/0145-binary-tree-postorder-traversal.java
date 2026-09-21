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

//using two stack

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode>st1=new Stack<TreeNode>();
        Stack<TreeNode>st2=new Stack<TreeNode>();
        List<Integer>postOrder=new ArrayList<Integer>();
        if(root==null)return postOrder;
        st1.push(root);
        while(!st1.isEmpty()){
            TreeNode node=st1.pop();
            st2.push(node);
            if(node.left!=null)st1.push(node.left);
            if(node.right!=null)st1.push(node.right);
        }
        while(!st2.isEmpty()) {
            postOrder.add(st2.pop().val);
        }
        return postOrder;  
    }
}