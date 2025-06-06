class Solution {
    public String robotWithString(String s) {
        final int n = s.length();
        char[] futureMin = new char[n+1];
        futureMin[n] = futureMin[n-1] = s.charAt(n-1);
        for (int i = n-2; i > 0; --i) 
            futureMin[i] = (s.charAt(i) < futureMin[i+1]) ? s.charAt(i) : futureMin[i+1];

        char[] stk = new char[n];
        int sidx = -1;
        StringBuilder res = new StringBuilder(n);
        for (int i = 0; i < n; ++i) {
            stk[++sidx] = s.charAt(i);

            while (sidx > -1 && (i == n - 1 || stk[sidx] <= futureMin[i + 1])) {
                res.append(stk[sidx--]);
            }
        }

        return res.toString();
    }
}
