class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        pre = temp = ListNode(0, head)
        for _ in range(left - 1):
            pre = pre.next
        a, b = pre, pre.next
        for _ in range(right - left):
            c = b.next
            b.next, c.next, a.next = c.next, a.next, c
        return temp.next
