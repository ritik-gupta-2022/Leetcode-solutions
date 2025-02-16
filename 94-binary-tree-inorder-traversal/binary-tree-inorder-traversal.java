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
    public List<Integer> inorderTraversal(TreeNode root) {
        ls=new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode node=root;
        while(root!=null){
            if(node!=null){
                st.push(node);
                node=node.left;
            }
            else{
                if(st.isEmpty()) return ls;
                node=st.pop();
                ls.add(node.val);
                node=node.right;
            }
        }
        return ls;
    }
}