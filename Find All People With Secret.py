from itertools import groupby

class Solution:
    def findAllPeople(self, n: int, meetings: List[List[int]], firstPerson: int) -> List[int]:

        class UnionFind:
            def __init__(self, size):
                self.parent = list(range(size))
                self.rank = [0] * size

            def find(self, i):
                if self.parent[i] != i:
                    self.parent[i] = self.find(self.parent[i])
                return self.parent[i]

            def unite(self, i, j):
                ri = self.find(i)
                rj = self.find(j)
                if ri == rj:
                    return
                if self.rank[ri] < self.rank[rj]:
                    self.parent[ri] = rj
                elif self.rank[ri] > self.rank[rj]:
                    self.parent[rj] = ri
                else:
                    self.parent[rj] = ri
                    self.rank[ri] += 1

        secrets={0,firstPerson}
        
        meetings.sort(key=lambda x:x[2])
        
        for time, group in groupby(meetings, key=lambda x: x[2]):
            currentPeople=set()
            group_list = list(group)  # all meetings at this time
            for person1, person2, _ in group_list:
                currentPeople.add(person1)
                currentPeople.add(person2)
            index = {p: i for i, p in enumerate(currentPeople)}
            uf = UnionFind(len(currentPeople))
            for x, y, _ in group_list:
                uf.unite(index[x], index[y])
            good_roots=set()
            for person in currentPeople:
                if person in secrets:
                    good_roots.add(uf.find(index[person]))
            for person in currentPeople:
                if uf.find(index[person]) in good_roots:
                    secrets.add(person)
            
        
        return list(secrets)
