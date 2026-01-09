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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
         if(root==null)return null;
        // TreeNode curr=root;
        Queue<TreeNode>q=new LinkedList<>();
        List<TreeNode>list=new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            list.clear();
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                list.add(curr);
                if(curr.left!=null)q.add(curr.left);
                if(curr.right!=null)q.add(curr.right);
            }
        }
        TreeNode lca=list.get(0);
        for(int i=1;i<list.size();i++){
            lca=findLca(root,lca,list.get(i));
        }
        return lca;
    }

    TreeNode findLca(TreeNode root,TreeNode p,TreeNode q){
        if(root==null||root==p||root==q)return root;
        TreeNode left=findLca(root.left,p,q);
        TreeNode right=findLca(root.right,p,q);
        if(left!=null&&right!=null)return root;
        return left!=null?left:right;
    }
}
