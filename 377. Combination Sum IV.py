class Solution:combinationSum4=lambda s,n,t:(f:=cache(lambda t:sum(f(t-v)for v in n if v<=t)if t else 1))(t)
