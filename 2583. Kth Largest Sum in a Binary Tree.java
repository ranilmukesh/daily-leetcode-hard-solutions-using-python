/*
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
  public long kthLargestLevelSum(TreeNode root, int k) {
    var queue = new PriorityQueue<Long>(Collections.reverseOrder());
    var q = new ArrayDeque<TreeNode>();
    q.offer(root);
    
    while (!q.isEmpty()) {
      var sum = 0L;
      
      for (var i = q.size(); i>0; i--) {
        var node = q.poll();
        
        sum += node.val;
        if (node.left != null) q.offer(node.left);
        if (node.right != null) q.offer(node.right);
      }
      queue.offer(sum);
    }
    if (queue.size() < k) return -1;
    
    while (--k > 0) queue.poll();
    
    return queue.poll();
  }
}
