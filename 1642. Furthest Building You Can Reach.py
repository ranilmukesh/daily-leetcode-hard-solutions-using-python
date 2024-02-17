class Solution:
  def furthestBuilding(self, heights: List[int], bricks: int, ladders: int) -> int:
    LENGTH = len(heights)
    climbs = []
    
    for i in range(LENGTH - 1):
      change = heights[i + 1] - heights[i]
      
      if change <= 0: continue
        
      heappush(climbs, -change)
      bricks -= change
      
      if bricks >= 0: continue
      if ladders == 0: return i
      bricks -= heappop(climbs)
      ladders -= 1
    
    return LENGTH - 1
