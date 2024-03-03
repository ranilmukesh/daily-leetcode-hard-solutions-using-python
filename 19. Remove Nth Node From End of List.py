class Solution:
	def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
		prehead = ListNode(0,next=head)
		fast, slow = prehead, prehead

		for i in range(n+1):
			fast = fast.next

		while fast:
			fast = fast.next
			slow = slow.next

		slow.next = slow.next.next

		return prehead.next
