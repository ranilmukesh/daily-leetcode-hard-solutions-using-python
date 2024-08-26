class Solution {
    List<Integer> at = new ArrayList<>();
    
    public List<Integer> postorder(Node root) {
        helper(root);
        return at;       
    }
    
    public void helper(Node root) {
        if (root == null) {
            return;
        }
        for (Node child : root.children) {
            helper(child);
        }
        
        at.add(root.val);
    }
}
