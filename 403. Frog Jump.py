import collections
class Solution:
    def canCross(self, stones: List[int]) -> bool:
        stone_jump_map = {stone: set() for stone in stones}
        stone_jump_map[0].add(1)
        for stone in stones:
            for k in stone_jump_map[stone]:
                next_stone = stone + k
                if next_stone in stone_jump_map:
                    stone_jump_map[next_stone].add(k)
                    stone_jump_map[next_stone].add(k + 1)
                    if k > 1:
                        stone_jump_map[next_stone].add(k - 1)
        return len(stone_jump_map[stones[-1]]) > 0
