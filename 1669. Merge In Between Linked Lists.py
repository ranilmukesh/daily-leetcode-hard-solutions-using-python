# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeInBetween(self, list1: ListNode, a: int, b: int, list2: ListNode) -> ListNode:
        s=list1
        for _ in range(a-1):
            s=s.next
        e=list1
        e2=list2
        while e2.next:
            e2=e2.next
        for _ in range(b+1):
            e=e.next
        if a==b:
            t=s.next.next
            s.next=list2
            e2.next=t
        else:
            s.next=list2
            e2.next=e
        return list1

        
