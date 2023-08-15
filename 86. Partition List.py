class Solution:
    def partition(self, head: Optional[ListNode], x: int) -> Optional[ListNode]:
        dummy_left = ListNode(0)
        dummy_right = ListNode(0)
        left = dummy_left
        right = dummy_right

        while head:
            if head.val >= x:
                right.next = head
                right = right.next
            else:
                left.next = head
                left = left.next
            head = head.next
        
        right.next = None
        left.next = dummy_right.next
        return dummy_left.next
