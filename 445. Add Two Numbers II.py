class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        def help(ll):
            a = 0
            while ll != None:
                a = a*10 + ll.val
                ll = ll.next
            return a
        
        add = help(l1) + help(l2)
        res = [x for x in str(add)]
        res = ",".join(res)
        return(ListNode(res))
