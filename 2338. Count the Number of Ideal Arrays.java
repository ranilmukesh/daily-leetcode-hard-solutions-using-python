class Solution:

    def idealArrays(self, n: int, maxValue: int) -> int:
        MOD = 10 ** 9 + 7

        my_combs = [1, n]  # my_combs[k] = n+k-1 choose k
        for k in range(2, 21):
            my_combs.append(((n + k - 1) * my_combs[-1]) // k)
        for x in range(len(my_combs)):
            my_combs[x] %= MOD

        primes = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47,
                  53, 59, 61, 67, 71, 73,
                  79, 83, 89, 97]

        fac_prods = [1] * (maxValue + 1)
        ans = 1

        for x in primes:
            if x > maxValue:
                break

            mult = x
            ii = 1
            comb_prodder = my_combs[ii]

            while mult <= maxValue:
                for nm in range(mult, mult * x, mult):
                    if nm > maxValue:
                        break
                    for y in range(nm, maxValue + 1, mult * x):
                        fac_prods[y] = fac_prods[y] * comb_prodder % MOD
                mult *= x
                ii += 1
                comb_prodder = my_combs[ii]

        for i in range(2, maxValue + 1):
            if fac_prods[i] == 1 and i > 100:
                for y in range(i, maxValue + 1, i):
                    fac_prods[y] *= n
            ans += fac_prods[i] % MOD

        return ans % MOD
