MOD = 1000000007

prime = [True] * 100001
pScores = [0] * 100001
for i in range(2, 100001):
    if prime[i]:
        for j in range(i, 100001, i):
            prime[j] = False
            pScores[j] += 1

prime[0] = prime[1] = False
pScores[0] = pScores[1] = 0

class Solution:
    def maximumScore(self, nums: List[int], k: int) -> int:

        s = [pScores[x] for x in nums]

        n = len(nums)
        left, right = [-1] * n, [n] * n
        for i in range(1, n):
            j = i - 1
            while j >= 0 and s[j] < s[i]: j = left[j]
            left[i] = j
        for i in range(n-2, -1, -1):
            j = i + 1
            while j < n and s[j] <= s[i]: j = right[j]
            right[i] = j
        
        ranges = [(i - left[i]) * (right[i] - i) for i in range(n)]

        candidates = sorted([(nums[i], ranges[i]) for i in range(n)], reverse=True)
        
        score = 1
        i = 0
        while k > 0:
            power = min(candidates[i][1], k)
            score = score * pow(candidates[i][0], power, MOD)
            k -= power
            i += 1
        
        return score % MOD
