class Solution:
    def longestCommonPrefix(self, arr1: List[int], arr2: List[int]) -> int:
        mp = defaultdict(int)
        ans = 0
        # Storing Prefix
        for i, num in enumerate(arr1):
            while num > 0:
                mp[num] = 1
                num //= 10
        
        # Checking Prefix
        for i, num in enumerate(arr2):
            while num > 0:
                if num in mp:
                    ans = max(ans , len(str(num)))
                    break
                num //= 10
        return ans
