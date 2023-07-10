class Solution:
    def minDepth(self, root: Optional[TreeNode]) -> int:

        nodes = [root]
        new_nodes = [root]
        depth = 0
        
        if root == None: return 0


        while len(new_nodes) > 0:
            depth += 1
            nodes = new_nodes
            new_nodes = []

            for node in nodes:
                if node.left == None and node.right == None:
                    return depth

                if node.left  != None: new_nodes.append(node.left)
                if node.right != None: new_nodes.append(node.right) 


        return depth
