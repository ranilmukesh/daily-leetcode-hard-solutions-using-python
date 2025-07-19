class Solution {
class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode() {
            this.children = new TrieNode[27];
            this.isEndOfWord = false;
        }
    }

    TrieNode root;

    private int getIndex(char ch) {
        if (ch == '/') {
            return 26;
        }

        return ch - 'a';
    }

    private void insert(String s) {
        TrieNode curr = root;

        for (int i = 0; i < s.length(); i++) {
            int idx = getIndex(s.charAt(i));

            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }

        curr.children[26] = new TrieNode();
        curr = curr.children[26];
        curr.isEndOfWord = true;
    }

    private boolean search(String s) {
        TrieNode curr = root;

        for (int i = 0; i < s.length(); i++) {
            if (curr.isEndOfWord) {
                return true;
            }

            int idx = getIndex(s.charAt(i));

            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.isEndOfWord;
    }

    public List<String> removeSubfolders(String[] folder) {
        root = new TrieNode();
        Arrays.sort(folder, (a, b) -> a.length() - b.length());
        List<String> ans = new ArrayList<>();

        for (String f : folder) {
            if (!search(f)) {
                insert(f);
                ans.add(f);
            }
        }
        return ans;
    }
}
