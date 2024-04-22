class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        target = int(target)
        if target == 0:
            return 0

        deadends = {int(d) for d in deadends}
        if 0 in deadends:
            return -1

        base = [1, 10, 100, 1000]

        transitions = [[(tr1 * base[i], tr2 * base[i]) for tr1, tr2 in zip([1] * 9 + [-9], [9] + [-1] * 9)] for i in range(4)]

        start, end = {0}, {target}
        deadends.add(0)
        deadends.add(target)
        result = 1
        while start and end:
            if len(start) > len(end):
                start, end = end, start
            
            temp = set()
            for cur in start:
                for i in range(4):
                    digit = (cur // base[i]) % 10
                    for tr in transitions[i][digit]:
                        new_state = cur + tr
                        
                        if new_state in end:
                            return result
                        
                        if new_state not in deadends:
                            deadends.add(new_state)
                            temp.add(new_state)
            start = temp
            result += 1
        return -1
