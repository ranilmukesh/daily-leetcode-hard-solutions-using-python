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

    private void inorder(TreeNode root,ArrayList<TreeNode> TN){
        if(root == null) return;

        inorder(root.left,TN);
        TN.add(root);
        inorder(root.right,TN);
    }

    private TreeNode constructree(ArrayList<TreeNode> TN,int s, int e){
        if(s>e) return null;

        int mid = s+(e-s)/2;
        TreeNode root = TN.get(mid);
        root.left = constructree(TN,s,mid-1);
       root.right = constructree(TN,mid+1,e);
        
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<TreeNode> TN = new ArrayList<>();
        inorder(root,TN);

        return constructree(TN,0,TN.size()-1);
    }
}
