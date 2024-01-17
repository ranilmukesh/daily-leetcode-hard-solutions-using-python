class Solution:
    def uniqueOccurrences(self, arr: List[int]) -> bool:
        return len((count := Counter(arr))) == len(set(count.values()))
