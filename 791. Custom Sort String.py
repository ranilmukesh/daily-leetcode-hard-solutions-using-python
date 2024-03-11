from functools import cmp_to_key


class Solution:
    def customSortString(self, order: str, s: str) -> str:
        return "".join(sorted(s, key=cmp_to_key(lambda x, y: order.find(x) - order.find(y))))
