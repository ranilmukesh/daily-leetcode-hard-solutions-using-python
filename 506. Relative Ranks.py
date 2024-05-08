class Solution:
    def findRelativeRanks(self, score: List[int]) -> List[str]:
        ranks = ["Gold Medal", "Silver Medal", "Bronze Medal"] + list(map(str, range(4, len(score) + 1)))
        score_rank = {score: rank for score, rank in zip(sorted(score, reverse=True), ranks)}
        return [score_rank[s] for s in score]
