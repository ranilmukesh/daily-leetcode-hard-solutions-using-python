class Solution:
    def constrainedSubsetSum(self, nums: List[int], k: int) -> int:
        n,q = len(nums),deque([0])
        for i in range(1, n):
            if nums[q[0]] > 0:
                nums[i] += nums[q[0]]
            while q and nums[i] > nums[q[-1]]:
                q.pop()
            q.append(i)
            if i - k >= q[0]:
                q.popleft()
        return max(nums)
