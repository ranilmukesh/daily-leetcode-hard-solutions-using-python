class Solution:
    def largestGoodInteger(self, num: str) -> str:
        c = 0
        cur = None
        max_good = -1
        for char in num:
            if char == cur:
                c += 1
                if c == 3 and int(cur) > max_good:
                    max_good = int(cur)
            else:
                cur = char
                c = 1
        if max_good < 0:
            return ""
        return str(max_good) * 3
        
        
