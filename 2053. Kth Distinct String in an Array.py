class Solution:
    def kthDistinct(self, arr: List[str], k: int) -> str:
        c = Counter(arr)
        temp = 1
        for key,v in c.items():
            if v == 1:
                if temp == k:
                    return key
                temp += 1
        return ''
