class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String> res = new ArrayList<>();
        Arrays.sort(folder, (a, b) -> a.length() - b.length());
        Trie trie = new Trie();
        for(String f : folder){
            if(trie.insert(f)){
                res.add(f);
            }
        }
        return res;
    }

    class TrieNode{
        TrieNode[] children = new TrieNode[27];
        boolean isWord;
    }

    class Trie{
        TrieNode root = new TrieNode();
        public boolean insert(String str){
            TrieNode curr = root;
            for(char c : str.toCharArray()){
                if(c == '/'){
                    if(curr.isWord){
                        return false;
                    }
                    c = '{';
                }
                if(curr.children[c - 'a'] == null){
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }
            if(curr.isWord){
                return false;
            }
            curr.isWord = true;
            return true;
        }
    }

}
