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
    List<Integer> ls;
    public void dfs(TreeNode node){
        if(node==null) return;

        ls.add(node.val);
        dfs(node.left);
        dfs(node.right);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        ls=new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        if(root==null) return ls;
        while(!st.isEmpty()){
            TreeNode node = st.pop();
            ls.add(node.val);
            if(node.right!=null) st.push(node.right);
            if(node.left!=null) st.push(node.left);
        }
        return ls;
    }
}