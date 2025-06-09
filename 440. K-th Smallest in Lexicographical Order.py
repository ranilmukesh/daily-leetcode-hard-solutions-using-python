class Node:
    def __init__(self, val):
        self.val = val
        self.nextNodes = []

    def __eq__(self, other):
        return self.val == other

class Solution:
    def generateTrieTree(self, data: list):
        root = Node(None)
        for intChar in data:
            pointer = root
            for char in intChar:
                try:
                    existedNodeIdx = pointer.nextNodes.index(char)
                    pointer = pointer.nextNodes[existedNodeIdx]
                except:
                    newNode = Node(char)
                    pointer.nextNodes.append(newNode)
                    pointer = newNode
        return root

    def findKthNumber(self, n: int, k: int) -> int:
        result = 1
        k -= 1
        while k > 0:
            count = 0
            interval = [result, result + 1]
            while interval[0] <= n:
                count += (min(n + 1, interval[1]) - interval[0])
                interval = [10 * interval[0], 10 * interval[1]]

            if k >= count:
                result += 1
                k -= count
            else:
                result *= 10
                k -= 1
        return result
        
        
        root = self.generateTrieTree([str(i) for i in range(1, n + 1)])
        output = []

        def traverse(pointer, previousVal):
            nextNodes = pointer.nextNodes
            if not nextNodes:
                return

            for node in nextNodes:
                if len(output) == k:
                    return

                newVal = previousVal + node.val
                output.append(newVal)
                traverse(node, newVal)

        traverse(root, "")
        return int(output[-1])
