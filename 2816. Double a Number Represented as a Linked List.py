
class Solution:
    def doubleIt(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(0, head)
        prev = dummy
        start = head
        while start:
            num = start.val * 2
            if num >= 10:
                prev.val += 1
            start.val = num % 10
            prev = start
            start = start.next
        
        return dummy if dummy.val else dummy.next
