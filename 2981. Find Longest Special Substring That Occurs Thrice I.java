class Solution {
    public int maximumLength(String s) {
        int [] count = new int [26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a'] ++;
        }
        int max = -1;
        for (int i = 0; i < 26; i++) {
            if (count[i] >= 3) {
                max = Math.max(max, findRepeat(s, i));
            }
        }
        return max;
    }
    
    // aaaa
    private int findRepeat(String s, int index) {
        char ch = (char)('a' + index);
        int repeat = 0; 
        int max = 0;
        int preIndex = -100;
        List<Integer> count = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
                if (preIndex == i -1) {
                    repeat++;
                    max = Math.max(max, repeat);
                    if (i == s.length() -1 || s.charAt(i+1) != ch) {
                        count.add(max);
                        max = 0;
                    }
                } else {
                    repeat = 1;
                }
                preIndex = i;
            }
        }
        Collections.sort(count, Collections.reverseOrder());
     
         // find thrices
        if (count.size() == 1) {
            return count.get(0) <=3 ? 1 : count.get(0) - 2;
        }
        if (count.size() == 2) {
            if (count.get(0) <= (count.get(1) + 1) ) {
                return (count.get(0) <=2) ? 1 : (count.get(0) -1);
            } else {
                return count.get(0) <=3 ? 1 : (count.get(0) - 2);
            }
        }
        if (count.size() >=3 ) {
            if(count.get(0) == count.get(1) && count.get(1) == count.get(2) ) {
                return count.get(0);
            }
            else {
               if (count.get(0) <= (count.get(1) + 1 )) {
                return (count.get(0) <=2) ? 1 : count.get(0) -1;
              } else {
                return count.get(0) <=3 ? 1 : count.get(0) - 2;
              }

            }
        }
        return 1;
    }
}
