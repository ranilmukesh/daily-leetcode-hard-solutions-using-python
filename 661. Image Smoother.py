from itertools import product
import numpy as np 

class Solution:
    def imageSmoother(self, img: List[List[int]]) -> List[List[int]]:
        m, n = len(img), len(img[0])
        img_np = np.zeros((m+2, n+2), dtype=np.int32)
        img_np[1:-1, 1:-1] = img
        cnt_np = np.zeros((m+2, n+2), dtype=np.int32)
        cnt_np[1:-1, 1:-1] = 1

        reduce_img = lambda x: sum([x[o1:m+o1, o2:n+o2] for o1, o2 in product(range(3), range(3))])


        ans = reduce_img(img_np) // reduce_img(cnt_np)
        return ans.tolist()
