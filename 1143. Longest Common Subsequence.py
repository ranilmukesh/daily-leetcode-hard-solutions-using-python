class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        common = set(text1) & set(text2)
        if len(common)==0:
            return 0
        text1 = [t for t in text1 if t in common]
        text2 = [t for t in text2 if t in common]
        print(text1,text2)
        dp=[0 for i in text1]
        for t in text2:
            print(dp)
            count=0
            for i in range(len(text1)):
                if count<dp[i]:
                    count=dp[i]
                elif t == text1[i]:
                    dp[i]=count+1
        return max(dp)



        
