/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode>parent=new HashMap<>();
        markParents(root,parent);
        
        Queue<TreeNode>q=new LinkedList<>();
        Set<TreeNode>visited=new HashSet<>();
        q.offer(target);
        visited.add(target);
        int dist=0;
        while(!q.isEmpty()){
            if(dist==k)break;
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(node.left!=null && visited.add(node.left))q.offer(node.left);
                if(node.right!=null && visited.add(node.right))q.offer(node.right);
                TreeNode p=parent.get(node);
                if(p!=null && visited.add(p))q.offer(p);
            }
            dist++;
        }
        List<Integer>ans=new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;
        
    }
    private void markParents(TreeNode root,Map<TreeNode,TreeNode>parent){
        Queue<TreeNode>q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node.left!=null){
                parent.put(node.left,node);
                q.offer(node.left);
            }
            if(node.right!=null){
                parent.put(node.right,node);
                q.offer(node.right);
            }
        }
    }
}