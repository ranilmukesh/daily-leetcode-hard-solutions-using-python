class Solution:
    def exist(self, board, word):
        def dfs(r, o, k):
            if not (0 <= r < len(board) and 0 <= o < len(board[0]) and board[r][o] == word[k]):
                return False
            if k == len(word) - 1:
                return True
            temp, board[r][o] = board[r][o], ''
            res = (dfs(r+1, o, k+1) or dfs(r-1, o, k+1) or
                   dfs(r, o+1, k+1) or dfs(r, o-1, k+1))
            board[r][o] = temp
            return res

        for r in range(len(board)):
            for o in range(len(board[0])):
                if dfs(r, o, 0):
                    return True
        return False
