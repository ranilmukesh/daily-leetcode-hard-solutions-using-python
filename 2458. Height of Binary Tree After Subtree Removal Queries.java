class Solution:
    def treeQueries(self, root: Optional[TreeNode], queries: List[int]) -> List[int]:
        def dfs(node, depth=0):
            if not node:
                return 0
            height = max(dfs(node.left, depth + 1), dfs(node.right, depth + 1))
            heights[node.val] = depth
            heapq.heappush(depths[depth], (-height, node.val))
            
            return height + 1
        depths = collections.defaultdict(list)
        heights = {}
        res = []
        dfs(root)

        for q in queries:
            d = heights[q]
            max_h = d - 1
            to_add = None
            if depths[d][0][1] == q:
                to_add = heapq.heappop(depths[d])
            if depths[d]:
                max_h = max(max_h, d - depths[d][0][0])
            if to_add:
                heapq.heappush(depths[d], to_add)                
            res.append(max_h)

        return res
