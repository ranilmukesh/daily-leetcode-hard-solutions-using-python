MOD = 1_000_000_007

IDENTITY_MATRIX = [
    [4, 0, 0, 0],
    [0, 2, 0, 0],
    [0, 0, 2, 0],
    [0, 0, 0, 1],
]

PERMUTATION_MATRIX = [
    [0, 1, 1, 0],
    [2, 0, 0, 0],
    [2, 0, 0, 1],
    [0, 0, 2, 0],
]

class Solution:
    def knightDialer(self, n: int) -> int:
        return dynamic_knight_dialer(n) if n < 512 else matrix_knight_dialer(n)


def dynamic_knight_dialer(n: int) -> int:
    if n == 1:
        return 10
    
    a = 4
    b = 2
    c = 2
    d = 1
    
    for _ in range(1, n):
        a, b, c, d = (2 * (b + c)) % MOD, a, (a + d + d) % MOD, c
    
    return (a + b + c+ d) % MOD


def matrix_knight_dialer(n: int) -> int:
    return sum(map(sum, matrix_power(PERMUTATION_MATRIX, n - 1))) % MOD
    

def matrix_power(matrix, power):
    result = IDENTITY_MATRIX
    base = PERMUTATION_MATRIX
    while power:
        if power & 1:
            result = multiply_matrices(result, base)
        base = multiply_matrices(base, base)
        power >>= 1
    return result


def multiply_matrices(mat1, mat2):
    return [[sum(map(mul, row, col)) % MOD for col in zip(*mat2)] for row in mat1]
