class Solution {
    public int numSteps(String s) {
        if(s.length() == 1) return 0;
        int res = 0, index = s.length() - 1;
        while(index >= 0) {
            if(s.charAt(index) == '0') {
                res++;
                index--;
            } else if(index != 0) {
                res += 2;
                while(--index >= 0) {
                    if(s.charAt(index) == '0') res += 2;
                    else res += 1;
                }
            } else index--;
        }
        return res;
    }
}
