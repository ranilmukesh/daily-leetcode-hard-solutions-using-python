class Solution {
    Set<String> set;
    int max = 0;
    public int maxUniqueSplit(String s) {
        set = new HashSet<>();
        backtracking(s, 0);
        return max;
    }

    public void backtracking(String s, int start) {
        if (start >= s.length()) {
            max = Math.max(max, set.size());
            return;
        }
        for (int i = start+1; i <= s.length(); i++) {
            if (set.size() + s.length()-i < max) break;
            String str = s.substring(start, i);
            if (!set.add(str)) continue;
            backtracking(s, i);
            set.remove(str);
        }
    }
}
