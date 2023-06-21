class Solution:
    def boxDelivering(self, boxes: List[List[int]], portsCount: int, maxBoxes: int, maxWeight: int) -> int: 
        num_boxes = len(boxes)
        left = -1 
        dp = [0 for _ in range(num_boxes)]
        res = 0
        for right in range(num_boxes): 
            maxBoxes -= 1 
            maxWeight -= boxes[right][1]
            
            if right==left+1:
                res+=2 
            elif boxes[right][0] != boxes[right-1][0]:
                res+=1 
            
            while maxBoxes<0 or maxWeight<0 or (left<right-1 and dp[left]==dp[left+1]):  
                left += 1 
                maxBoxes += 1     
                maxWeight += boxes[left][1]
                if boxes[left][0] != boxes[left+1][0]:
                    res -= 1  
                 
            dp[right] = dp[left] + res   
        return dp[num_boxes-1]
