class Solution:
    def distanceK(self, root: TreeNode, target: TreeNode, k: int) -> List[int]:
        def add_parent(node, parent): 
            if node: 
                node.parent = parent 
                add_parent(node.left, node) 
                add_parent(node.right, node) 
        # initialize answer list and visited set 
        answer = [] 
        visited = set() 
        def dfs(node, distance): 
            if node is None or node in visited: 
                return 
            visited.add(node) 
            if distance == k: 
                answer.append(node.val) 
                return 
            dfs(node.left, distance+1) 
            dfs(node.right, distance+1) 
            dfs(node.parent, distance+1) 
        add_parent(root, None) 
        dfs(target, 0) 
        return answer 
