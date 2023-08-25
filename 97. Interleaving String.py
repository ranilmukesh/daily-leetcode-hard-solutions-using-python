class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        m, n, o = len(s1), len(s2), len(s3)
        if m + n != o:
            return False
        
        @cache
        def dphelper(i, j, k):
            if k == o:return i == m and j == n
            return (i < m and s1[i] == s3[k] and dphelper(i + 1, j, k + 1)) or \
                   (j < n and s2[j] == s3[k] and dphelper(i, j + 1, k + 1))
        
        return dphelper(0, 0, 0)
