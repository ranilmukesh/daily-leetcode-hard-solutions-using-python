class Solution(object):
    def buddyStrings(self, A, B):
        if len(A) != len(B):
            return False
        if A == B and len(A) > len(set(A)):
            return True
        d = [(a, b) for a, b in zip(A, B) if a != b]
        return len(d) == 2 and d[0] == d[1][::-1]
