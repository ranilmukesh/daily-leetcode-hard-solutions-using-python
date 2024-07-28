class Solution:
    def secondMinimum(self, n, edges, time, change):
        dict1 = collections.defaultdict(list)

        for i,j in edges:
            dict1[i-1].append((j-1,time))
            dict1[j-1].append((i-1,time))

        d1, d2 = {i:float("inf") for i in range(n)}, {i:float("inf") for i in range(n)}

        d1[0], freq = 0, collections.defaultdict(int)

        stack = [(0,0)]

        while stack:
            cur_time, node = heapq.heappop(stack)

            freq[node] += 1

            if freq[node] == 2 and node == n-1:
                return cur_time

            if ((cur_time//change)%2):
                cur_time = change*(cur_time//change + 1)

            for neighbor,t in dict1[node]:
                if freq[neighbor] == 2: continue
                if d1[neighbor] > cur_time + t:
                    d2[neighbor] = d1[neighbor]
                    d1[neighbor] = cur_time + t
                    heapq.heappush(stack,(cur_time + t,neighbor))

                elif d2[neighbor] > cur_time + t and d1[neighbor] != cur_time + t:
                    d2[neighbor] = cur_time + t
                    heapq.heappush(stack,(cur_time + t,neighbor))
