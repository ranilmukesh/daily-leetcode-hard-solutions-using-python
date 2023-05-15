class Solution:
    def getMaxRepetitions(self, s1: str, n1: int, s2: str, n2: int) -> int:
        l1, l2 = len(s1), len(s2)
        visited = {}
        index = repeat_count = i = 0
        while i < n1:
            print(i)
            for j in range(l1):
                if s1[j] == s2[index]:
                    index += 1
                if index == l2:
                    index = 0
                    repeat_count += 1
            if index in visited:
                prev_i, prev_repeat_count = visited[index]
                r = (n1-1-i) // (i-prev_i)
                i += (i-prev_i)*r
                repeat_count += (repeat_count-prev_repeat_count )*r
                visited = {}
            else:
                visited[index] = [i, repeat_count]
            i += 1
        return repeat_count // n2
