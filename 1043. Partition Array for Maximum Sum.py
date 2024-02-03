class Solution:
    def funn(self ,ind , arr , k , dp):
        if ind == len(arr):
          return 0
        if dp[ind] != -1:
          return dp[ind]
        maxa = -1
        lenn = 0
        maxans = -1
        for i in range(ind , min(len(arr) , ind + k)):
          lenn+=1
          maxa = max(maxa , arr[i])
          summ = (lenn*maxa) + self.funn(i+1 , arr , k ,dp)
          maxans = max(summ , maxans)
        dp[ind] = maxans
        # print(dp)
        return maxans
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
      dp = [-1 for i in range(len(arr))]
      return self.funn(0 , arr , k , dp)     
