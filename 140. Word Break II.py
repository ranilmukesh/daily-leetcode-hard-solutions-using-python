class Solution {
    Set<String> words;
    List<String> sentences;
    private void backtrack(String s, int i0, int i1, boolean[] spaces) {
        if (i1 >= s.length()) {
            if (words.contains(s.substring(i0, i1))) {
                StringBuilder sen = new StringBuilder();
                for (int i = 0; i < s.length(); i++) {
                    sen.append(s.charAt(i));
                    if (spaces[i])
                        sen.append(" ");
                }
                sentences.add(new String(sen));
            }
            return ;
        }

        if (words.contains(s.substring(i0, i1 + 1))) {
            spaces[i1] = true;
            backtrack(s, i1 + 1, i1 + 1, spaces);
            spaces[i1] = false;
        }

        backtrack(s, i0, i1 + 1, spaces);
    }
 
    public List<String> wordBreak(String s, List<String> wordDict) {
        sentences = new ArrayList<>();
        words = new HashSet<>(wordDict);
        backtrack(s, 0, 0, new boolean[s.length()]);
        return sentences;
    }
}
