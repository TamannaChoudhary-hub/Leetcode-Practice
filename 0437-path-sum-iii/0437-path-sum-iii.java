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
import java.util.*;

class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);

        return dfs(root, 0L, targetSum, map);
    }

    private int dfs(TreeNode node, long sum, int target,
                    Map<Long, Integer> map) {
        if (node == null) return 0;

        sum += node.val;

        int count = map.getOrDefault(sum - target, 0);

        map.put(sum, map.getOrDefault(sum, 0) + 1);

        count += dfs(node.left, sum, target, map);
        count += dfs(node.right, sum, target, map);

        map.put(sum, map.get(sum) - 1);

        return count;
    }
}