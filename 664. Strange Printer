class Solution:
	def strangePrinter(self, s: str) -> int:
		
		s = ''.join([c for i, c in enumerate(s)
					 if i == 0 or c != s[i - 1]])

		next_occ_search = {}
		next_occurrence_of_letter = list(range(len(s)))
		for i, c in enumerate(s):
			if c in next_occ_search:
				next_occurrence_of_letter[next_occ_search[c]] = i
			next_occ_search[c] = i

		for v in next_occ_search.values():
			next_occurrence_of_letter[v] = 10**10

		@functools.lru_cache(None)
		def dp(left_ind: int, right_ind: int) -> int:

			if left_ind >= right_ind:
				return 0

			if s[right_ind] == s[left_ind]:
				return dp(left_ind + 1, right_ind)

			ans = 1 + dp(left_ind + 1, right_ind)

			pivot_index = next_occurrence_of_letter[left_ind]
			while pivot_index <= right_ind:
				ans = min(ans, 1 + dp(left_ind + 1, pivot_index)
						  + dp(pivot_index + 1, right_ind))
				pivot_index = next_occurrence_of_letter[pivot_index]

			return ans

		s += '#'
		return dp(0, len(s) - 1)
