class Solution:
    def getWinner(self, arr: List[int], k: int) -> int:
        cur, cnt = arr[0], 0
        for i in arr[1:]:
            if i < cur:
                cnt+=1
            else:
                cnt = 1
                cur = i
            if cnt == k:
                return cur
        return cur
