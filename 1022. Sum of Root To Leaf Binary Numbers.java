class Solution {
    public int helper(TreeNode root, int val)
    {
        if(root ==null) return 0;
        val=val*2+root.val;
        return(root.left==root.right)? val: helper(root.left, val)+helper(root.right, val);
    }
    public int sumRootToLeaf(TreeNode root) {
        int val=0;
        return helper(root, val);
    }
}
