class Solution:
    def checkValidString(self, s: str) -> bool:
        st, a = [], []
        for i, c in enumerate(s):
            if c == ")":
                if st: st.pop()
                elif a: a.pop()
                else: return False
            elif c == "(": st.append(i)
            else: a.append(i)
        
        while st and a:
            if st[-1] > a[-1]:
                return False
            
            st.pop()
            a.pop()
        
        return not st
