class Solution:
    def numberOfPaths(self, grid: List[List[int]], k: int) -> int:
        m = len(grid)
        n = len(grid[0])
        if m == 1 or n == 1:
            if sum(num for act_row in grid for num in act_row) % k:
                return 0
            return 1
        if k == 1:
            return comb(m + n - 2, n - 1) % 1000000007
        mod_row_poss = [deque([0] * k) for _ in repeat(None, n)]
        act_sum = 0
        for i, row0_num in enumerate(grid[0]):
            act_sum = (act_sum + row0_num) % k
            mod_row_poss[i][act_sum] = 1
        for act_row in grid[1:]:
            mod_row_poss[0].rotate(act_row[0] % k)
            for i, act_num in enumerate(act_row[1:], 1):
                act_poss_dq = mod_row_poss[i]
                for prev_num in mod_row_poss[i - 1]:
                    if (new_poss := act_poss_dq.popleft() + prev_num) >= 1000000007:
                        new_poss -= 1000000007
                    act_poss_dq.append(new_poss)
                act_poss_dq.rotate(act_num % k)
        return mod_row_poss[-1][0]
