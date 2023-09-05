class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head:
            return None
        if not head.next:
            newHead = Node(head.val)
            if not head.random:
                newHead.random = None
            else:
                newHead.random = newHead
            return newHead
        nodeMap = {}

        oCur = head
        nCur = Node(head.val)
        if(head.random):
            nRand = Node(head.random.val)
            nodeMap[head.random] = nRand
            nCur.random = nRand
        else:
            nCur.random = oCur.random
        
        nodeMap[oCur] = nCur
        nHead = nCur

        while oCur.next:
            oNxt = oCur.next

            if oNxt in nodeMap:
                nNxt = nodeMap[oNxt]
            else:
                nNxt = Node(oNxt.val)
                nodeMap[oNxt] = nNxt
            
            oRand = oNxt.random
            nRand = None

            if(oRand):
                if oRand in nodeMap:
                    nRand = nodeMap[oRand]
                else:
                    nRand = Node(oRand.val)
                    nodeMap[oRand] = nRand
            
            nNxt.random = nRand
            nCur.next = nNxt
            nCur = nNxt
            oCur.next = oNxt
            oCur = oNxt
            
        return nHead
        




        
