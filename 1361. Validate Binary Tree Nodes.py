class Solution:
    def validateBinaryTreeNodes(self, n: int, leftChild: List[int], rightChild: List[int]) -> bool:
        childs_set = set(leftChild+rightChild)
        root = 0
        while root in childs_set and root < n:
            root += 1
        if root == n:
            return False
        queue = deque([root])
        while queue:
            node = queue.popleft()
            left, right = leftChild[node], rightChild[node]
            if left not in childs_set or right not in childs_set:
                return False
            if left != -1:
                queue.append(left)
                childs_set.discard(left)
            if right != -1:
                queue.append(right)
                childs_set.discard(right)
            n -= 1
        return not n
