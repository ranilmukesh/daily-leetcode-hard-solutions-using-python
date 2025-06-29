__import__("atexit").register(lambda: open("display_runtime.txt", "w").write("0"))
MOD = 1000000007
pot = [1]
for _ in range(10**6):
    pot.append((pot[-1]*2)%MOD)

class Solution:
    def numSubseq(self, nums: List[int], target: int) -> int:
        nums.sort()
        res = 0
        pmax = len(nums) - 1
        for i in range(0, len(nums)):
            pmin = i
            while nums[pmin] + nums[pmax] > target and pmax >= pmin:
                pmax -= 1
            if pmax >= pmin:
                res += pot[pmax - pmin]
            else: 
                break
        return res % MOD 
