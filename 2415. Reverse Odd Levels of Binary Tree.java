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
    public TreeNode reverseOddLevels(TreeNode root) {
        level(root.left,root.right,0);
        return root;
    }
    public void level(TreeNode node1, TreeNode node2,int l){
        if(node1==null || node2==null){
            return;
        }
        if(l%2==0){
            int val=node1.val;
            node1.val=node2.val;
            node2.val=val;
        }
        level(node1.left,node2.right,l+1);
        level(node1.right,node2.left,l+1);
    }
}
