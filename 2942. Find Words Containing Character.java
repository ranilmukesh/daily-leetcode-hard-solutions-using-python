class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> res=new ArrayList<Integer>();
        for(int i=0;i<words.length;i++)
        {
            String word=words[i];
            if(word.indexOf(x)>-1)
            res.add(i);
        }
        return res;
    }
}
