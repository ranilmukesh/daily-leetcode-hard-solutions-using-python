class Solution:
    def getLengthOfOptimalCompression(self, s: str, k: int) -> int:
        @cache
        def dp(i, k):
            if i >= len(s):
                return 0

            answer = math.inf
            if k > 0:
                answer = min(answer, dp(i+1, k-1))

            answer = min(answer, 1+dp(i+1, k))
            
            j = i + 1
            same = 1
            while j < len(s):
                if s[j] == s[i]:
                    same += 1
                elif k > 0:
                    k -= 1
                else:
                    break
                j += 1
                if same > 2:
                    answer = min(answer, len(str(same))+1+dp(j, k))

            return answer
        
        return dp(0, k)

        
