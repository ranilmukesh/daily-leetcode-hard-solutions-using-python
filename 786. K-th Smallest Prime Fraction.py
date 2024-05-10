class Solution:
    def kthSmallestPrimeFraction(self, arr: List[int], k: int) -> List[int]:        
        def condition(mid):
            top,down = 0,1
            ctr = 0
            l = 0
            for i in range(1,len(arr)): 
                while l < i and arr[l]/arr[i] <mid:
                    l+=1

                if 1 > arr[l-1]/arr[i] > top/down:
                    top = arr[l-1]
                    down = arr[i]
                ctr += l
            return ctr,top,down


        l = 0 
        r = 1
        while l<r:
            mid = (l+r)/2 
            count,top,down = condition(mid)
            if count == k:
                return [top,down]
                
            elif count >k:
                r = mid
            else:
                l = mid
