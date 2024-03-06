class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        dummy = ListNode(0,head)
        node = dummy

        while node and node.next:
            nextNode = node.next
            if nextNode.next == dummy:
                return True
            node.next = dummy
            node = nextNode
        return False
