class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        n = len(s)
        stack = []
        ans = []
        
        for c in s:
            if c == ")":
                if len(stack) == 0:
                    continue
                else:
                    stack.pop()

            if c == "(":
                stack.append(c)

            ans.append(c)

        i = len(ans) - 1
        while stack and i >= 0:
            if ans[i] == "(":
                ans[i] = ""
                stack.pop()

            i -= 1

        return "".join(ans)
