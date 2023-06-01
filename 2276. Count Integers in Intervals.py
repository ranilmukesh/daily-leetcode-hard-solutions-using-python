class Node:
    def __init__(self):
        self.val = self.left = self.right = None

    def add(self, node, x, y, s, e):
        if e <= x or y <= s or node and node.val == y-x: return node

        if not node: node = Node()

        if s <= x and y <= e:
            node.val = y-x
            return node

        mid = (x+y)//2

        node.left = self.add(node.left, x, mid, s, e)
        node.right = self.add(node.right, mid, y, s, e)

        node.val = 0

        if node.left: node.val += node.left.val
        if node.right: node.val += node.right.val 

        return node

class CountIntervals:
    def __init__(self):
        self.root = Node()

    def add(self, left, right):
        self.root.add(self.root,1,10**9+1,left,right+1)

    def count(self):
        return self.root.val or 0
        
