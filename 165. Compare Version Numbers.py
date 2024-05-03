class Solution:
    def compareVersion(self, version1: str, version2: str) -> int:
        v1_str = version1.split(".")
        v2_str = version2.split(".")
        
        v1 = [int(n) for n in v1_str]
        v2 = [int(n) for n in v2_str]

        # n = min(len(v1), len(v2))


        i = 0
        while i < min(len(v1), len(v2)):
            v1_el = v1[i]
            v2_el = v2[i]
            
            if v1_el > v2_el:
                return 1
            if v2_el > v1_el:
                return -1
            i+=1
        
        if len(v1) == len(v2):
            return 0
        
        bigger_list = []
        if len(v1) > len(v2):
            bigger_list = v1
        else:
            bigger_list = v2
        
        # go over bigger_list from i+1 to end
        for c in range(i, len(bigger_list)):
            if bigger_list[c] != 0:
                if len(v1) > len(v2):
                    return 1
                else:
                    return -1
        return 0
        
