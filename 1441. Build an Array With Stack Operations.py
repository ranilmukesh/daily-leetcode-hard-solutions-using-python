class Solution:
    def buildArray(self, target: List[int], n: int) -> List[str]:
        res, i = [], 1
        while i <= target[-1]: 
            res += ["Push", "Pop"] if i not in set(target) else ["Push"]
            i += 1
        return res
