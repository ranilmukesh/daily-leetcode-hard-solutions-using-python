class Solution:
    def buddyStrings(self, s: str, goal: str) -> bool:

        if len(s) != len(goal):
            return False
        
        if s == goal:
            return [1 for x in collections.Counter(s).values() if x >1]
        
        lst = list(s)
        i = None
        for x in range(len(s)):
            if s[x] != goal[x]:
                if i is None:
                    i = x
                else:
                    lst[x], lst[i] = lst[i], lst[x]
                    return "".join(lst) == goal
