class Solution {
    public int minimumDeletions(String s) {
        int aCount = 0 ;
        int bCount = 0 ;
        
        int n = s.length();
        if(s.length() == 1) return 0;
        for (char c : s.toCharArray()) {
            if(c == 'a')
            aCount++;
        }
        int res = Math.min(aCount, n - aCount);
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == 'a')
            {
                aCount--;
            }
            else
            {
                bCount++;
            }
            res = Math.min(res, aCount + bCount);
        }

    return res;
    }
}
