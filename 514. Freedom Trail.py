class Solution:
    def findRotateSteps(self, ring: str, key: str) -> int:
        
        n = len(ring)
        ind_dict = defaultdict(list)
        for i, l in enumerate(ring):
            ind_dict[l].append(i)
        
        prev_arr = [0]
        prev_inds = [0]
        for l in key:
            inds = ind_dict[l]
            arr = [0] * len(inds)
            next_inds = [0] * len(inds)
            for i, ind in enumerate(inds):
                j = bisect.bisect(prev_inds, ind)
                if j == len(prev_inds):
                    dist = min(prev_arr[-1] + ind - prev_inds[-1], prev_arr[0] + prev_inds[0] + n - ind)
                elif j == 0:
                    dist = min(prev_arr[-1] + ind + n - prev_inds[-1], prev_arr[0] + prev_inds[0] - ind)
                else:
                    dist = min(prev_arr[j - 1] + ind - prev_inds[j - 1], prev_arr[j] + prev_inds[j] - ind)
                arr[i] = dist
            prev_arr = arr
            prev_inds = inds
        return min(arr) + len(key)
