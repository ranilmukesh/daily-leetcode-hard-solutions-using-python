class Solution:
    def peak_finder(self, arr: list[int], n: int) -> int:
        l,r = 0,n-1
        while l < r :
            m = (l+r)//2
            if arr.get(m) < arr.get(m+1):
                l = m+1
            else:
                r = m
        return l

    def bin_search(self, arr: list[int], l: int, r: int, val: int, desc: bool = False) -> int:
        while l <= r:
            m = (l+r)//2
            mid_val = arr.get(m)
            if val == mid_val:
                return m
            elif val > mid_val:
                if desc:
                    r = m - 1
                else:
                    l = m + 1
            else:
                if desc:
                    l = m + 1
                else:
                    r = m - 1

        return -1

    def findInMountainArray(self, target: int, mountain_arr: 'MountainArray') -> int:
        n = mountain_arr.length()
        peak = self.peak_finder(mountain_arr, n)
        
        if peak > 0:
            res = self.bin_search(mountain_arr,0,peak+1,target)
            if res != -1:
                return res
            else:
                res = self.bin_search(mountain_arr,n-peak-1,n-1,target, True)
                return res

        return -1
        
