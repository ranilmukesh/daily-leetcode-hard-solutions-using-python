class Solution:
    def winnerOfGame(self, colors: str) -> bool:
        return sum([len(i) - 2 for i in re.findall(r'A[A]+A', colors)]) > sum([len(i) - 2 for i in re.findall(r'B[B]+B', colors)])
