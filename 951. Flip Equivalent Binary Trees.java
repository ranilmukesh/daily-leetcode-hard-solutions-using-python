class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true ; 
        if(root1 == null || root2 == null) return false ; 

        if(root1.val != root2.val) return false ; 
        
        boolean t1 = flipEquiv(root1.left , root2.left) ; 
        boolean t2 = flipEquiv(root1.right , root2.right) ; 
        boolean t3 = flipEquiv(root1.left , root2.right) ; 
        boolean t4 = flipEquiv(root1.right , root2.left) ; 

        return (t1 && t2) || (t3 && t4) ;
    }
}
