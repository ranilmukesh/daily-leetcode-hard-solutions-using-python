class Solution:
    def minDeletions(self, s: str) -> int:
        cnt = collections.Counter(s)
        ans = 0
        res = set()
        for ch, f in cnt.items():
            while f > 0 and f in res:
                f -= 1
                ans += 1
            res.add(f)
        return ans
