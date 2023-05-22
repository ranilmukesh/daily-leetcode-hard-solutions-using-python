class Solution:
    def maxNiceDivisors(self, primeFactors: int) -> int:
        if primeFactors == 1:
            return 1
        Mod = 1_000_000_007
        num2 =  -primeFactors%3
        num3 = (primeFactors - primeFactors%3*(-primeFactors%3))//3
        return (pow(2,num2))*(pow(3,num3,Mod))%Mod
