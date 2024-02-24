class Solution:
    def findAllPeople(self, n: int, meetings: List[List[int]], firstPerson: int) -> List[int]:
        meetings.sort(key = lambda x: x[2])
        knows_secret = {0, firstPerson}
        time_to_find_out = [float('inf')] * n
        time_to_find_out[firstPerson] = 0
        time_to_find_out[0] = 0
        r = reversed(meetings)
        for _ in range(4):
            for a, b, currtime in meetings:
                if a in knows_secret and time_to_find_out[a] <= currtime:
                    knows_secret.add(b)
                    time_to_find_out[b] = currtime
                elif b in knows_secret and time_to_find_out[b] <= currtime:
                    knows_secret.add(a)
                    time_to_find_out[a] = currtime

            for a, b, currtime in r:
                if a in knows_secret and time_to_find_out[a] <= currtime:
                    knows_secret.add(b)
                    time_to_find_out[b] = currtime
                elif b in knows_secret and time_to_find_out[b] <= currtime:
                    knows_secret.add(a)
                    time_to_find_out[a] = currtime
        return list(knows_secret)                            
