class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        import itertools
        
        combination_list=[]
        
        for combination in itertools.combinations(range(1,n+1),k):
            combination_array = list(combination) 
            combination_list.append(combination_array)
        
        return combination_list
