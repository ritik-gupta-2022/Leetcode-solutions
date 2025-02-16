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
    PriorityQueue<Long> pq;
    public void helper(TreeNode node, long sum, int k){
        if(node==null){
            if(pq.size()<k){
                pq.offer(sum);
            }
            else if(pq.size()>=k && pq.peek()<sum){
                pq.poll();
                pq.offer(sum);
            }
            return;
        }
        helper(node.left, sum+node.val, k);
        helper(node.right, sum+node.val, k);

        return;
    }
    public long kthLargestLevelSum(TreeNode root, int k) {
        pq = new PriorityQueue<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int l=q.size();
            long sum=0;
            while(l-->0){
                TreeNode node = q.poll();
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
                sum+=node.val;
            }
            if(pq.size()<k){
                pq.offer(sum);
            }
            else if(pq.size()>=k && pq.peek()<sum){
                pq.poll();
                pq.offer(sum);
            }
        }
        return pq.size()<k ? -1 :pq.peek();
    }
}