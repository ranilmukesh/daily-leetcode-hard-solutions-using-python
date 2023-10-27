class Solution:
    
    def longestPalindrome(self, s: str) -> str:
        len_s = len(s)
        len_max = 0
        ans = ''
        left, right = 0, 1 # odd length
        while right <= len_s:            
            while left >= 0 and right <= len_s and s[left: right] == s[left: right][:: -1]:
                left, right = left - 1, right + 1
            candidate = right - left - 2
            if candidate > len_max:
                len_max = candidate
                ans = s[left + 1: right - 1]
            left, right = left + 1, right + 1
        
        left, right = 0, len_max + 1 # even length
        while right <= len_s:            
            while left >= 0 and right <= len_s and s[left: right] == s[left: right][:: -1]:
                left, right = left - 1, right + 1
            candidate = right - left - 2
            if candidate > len_max:
                len_max = candidate
                ans = s[left + 1: right - 1]
            left, right = left + 1, right + 1        
        
        return ans
