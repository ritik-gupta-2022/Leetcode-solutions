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
    int ans;
    public void helper(TreeNode node, int min, int max){
        if(node==null) return;

        ans=Math.max(Math.abs(max-node.val), ans);
        ans=Math.max(Math.abs(node.val-min), ans);

        helper(node.left, Math.min(min,node.val), Math.max(max,node.val));
        helper(node.right, Math.min(min,node.val), Math.max(max,node.val));

        
    }
    public int maxAncestorDiff(TreeNode root) {
        ans=0;
        helper(root, root.val, root.val);
        return ans;
    }
}