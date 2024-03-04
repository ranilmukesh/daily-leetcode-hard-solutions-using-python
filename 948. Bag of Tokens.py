class Solution:
    def bagOfTokensScore(self, tokens: List[int], power: int) -> int:
        tokens.sort()
        score = 0
        left, right = 0, len(tokens) - 1
        
        while right >= left:
            if power >= tokens[left]:
                power -= tokens[left]
                score += 1
                left += 1
            elif score > 0 and right - left > 0:
                score -= 1
                power += tokens[right]
                right -= 1
            else:
                return score
        
        return score
