class Solution:
    def maxNumEdgesToRemove(self, n, edges):
        
        def find(i, root):
            if i != root[i]:
                root[i] = find(root[i], root)
            return root[i]

        def uni(x, y, root):
            x, y = find(x, root), find(y, root)
            if x == y: return 0
            root[x] = y
            return 1

        res = alice_edges = bob_edges = 0

        
        root = list(range(n + 1))
        for t, i, j in edges:
            if t == 3:
                if uni(i, j, root):
                    alice_edges += 1
                    bob_edges += 1
                else:
                    res += 1
        root0 = root[:]

        
        for t, i, j in edges:
            if t == 1:
                if uni(i, j, root):
                    alice_edges += 1
                else:
                    res += 1
                    
                   

        
        root = root0
        for t, i, j in edges:
            if t == 2:
                if uni(i, j, root):
                    bob_edges += 1
                else:
                    res += 1

        return res if alice_edges == bob_edges == n - 1 else -1
      
   #Input: n = 4, edges = [[3,1,2],[3,2,3],[1,1,3],[1,2,4],[1,1,2],[2,3,4]]
# Output: 2
# Explanation: If we remove the 2 edges [1,1,2] and [1,1,3]. The graph will still be fully traversable by Alice and Bob. 
# Removing any additional edge will not make it so. So the maximum number of edges we can remove is 2.
