# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if not head:
            return
        # Step 1: Find the middle of the list
        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        # Step 2: Reverse the second half of the list
        right = slow.next
        rev = slow.next = None # slow.next=None breaks the link making two left & right lists
        while right:
            temp = right.next
            right.next = rev
            rev = right
            right = temp
        
        # now merge
        first, second = head, rev
        while second: # second one prolly smaller
            temp1, temp2 = first.next, second.next
            first.next = second
            second.next = temp1
            ## swap done
            # now shift first & second pointers
            first, second = temp1, temp2
