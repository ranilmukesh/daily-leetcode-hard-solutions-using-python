class Solution:
    def numRescueBoats(self, people: List[int], limit: int) -> int:
        people.sort()
        i, j = 0, len(people) - 1
        ans = 0
        while i < j:
            while people[i] + people[j] > limit and i < j:
                j -= 1
                ans += 1
            ans += 1
            i += 1
            j -= 1
        return ans if i != j else ans + 1
