class Solution:
    def splitListToParts(self, head: Optional[ListNode], k: int) -> List[Optional[ListNode]]:

        temporrary, length = head, 0
    
        while temporrary: length += 1; temporrary = temporrary.next; 

        result, remnant, response = length // k, length % k, []

        for i in range(k):
            current = head
            previous = head
            for _ in range(result + (1 if i < remnant else 0)):
                try: previous = head; head = head.next; 
                except: break
            try: previous.next = None
            except: pass

            response.append(current)
                
        return response
