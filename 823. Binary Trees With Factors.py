class Solution:
    def numFactoredBinaryTrees(self, arr: List[int]) -> int:
        points = set(arr)
        arr.sort()

        @lru_cache(None)
        def r(nv):
            ways = 1
            for i in arr:
                j = nv // i
                if j < i:
                    break
                if nv % i or j not in points:
                    continue
                v = r(i) * r(j)
                ways += v
                if i != j:
                    ways += v
            return ways % (10**9 + 7)
        
        return sum(r(i) for i in arr) % (10**9 + 7)

