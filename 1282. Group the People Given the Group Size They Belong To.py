class Solution:
    def groupThePeople(self, groupSizes: List[int]) -> List[List[int]]:
        groups = collections.defaultdict(list)
        res = []
        for idx ,val in enumerate(groupSizes):
            groups[val].append(idx)
            if len(groups[val]) == val:
                res.append(groups[val])
                groups[val] = []
        return res  
