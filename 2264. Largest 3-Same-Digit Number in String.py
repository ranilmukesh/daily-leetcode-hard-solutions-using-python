class Solution:
    def largestGoodInteger(self, num: str) -> str:
        prev = None
        cur_count = 1
        max_num = ''
        for i,l in enumerate(num):
            if l == prev:
                cur_count += 1
            else:
                cur_count = 1
            if cur_count == 3:
                max_num = max(max_num, l)
                cur_num = 1
            prev = l
        return (max_num)*3
