class Solution:
	def lengthOfLIS(self, nums: List[int]) -> int:
		r = []
		for x in nums:
				if not r or x > r[-1]:
					r.append(x)
				else:
					r[bisect_left(r, x)] = x
		return len(r)
