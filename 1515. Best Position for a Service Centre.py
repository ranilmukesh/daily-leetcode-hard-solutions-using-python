import numpy as np
from scipy.optimize import minimize

class Solution:
    def getMinDistSum(self, positions: List[List[int]]) -> float:
        def cost(p):
            return sum(sqrt((p[0]-x)*(p[0]-x) + (p[1]-y)*(p[1]-y)) for x, y in positions)
        positions = np.array(positions)
        return cost(minimize(cost, x0=[0, 0], tol=10**(-6)).x)
