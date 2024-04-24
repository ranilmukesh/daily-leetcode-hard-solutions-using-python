class Solution:
    def tribonacci(self, n: int) -> int:
        if n == 0: 
            return 0
        elif n <= 2: 
            return 1 
        arr = [0]*(n+1)
        arr[1] = arr[2] = 1 
        i = 3
        # print(n)
        while i<=n: 
            # print(i)
            arr[i] = sum(arr[i-3:i])
            i += 1
        return arr[n]
