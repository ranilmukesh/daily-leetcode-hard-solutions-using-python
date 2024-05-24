class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        
        int[] letcount = new int[26];
        for(char ch:letters)
        {
            letcount[ch-'a']++;
        }
        int maxScore = get(words,letcount,score,0);
        return maxScore;
    }
    public int get(String[] words,int[] letcount, int[] score,int ind)
    {
        if(ind==words.length)
        {
            return 0;
        }
        int maxscore = get(words,letcount,score,ind+1);

        boolean include = true;
        String word = words[ind];
        int[] temp = letcount.clone();
        int sc =0;

        for(char ch : word.toCharArray())
        {
            if(--temp[ch-'a']<0)
            {
                include=false;
            }
            sc+=score[ch-'a'];
        }
    
    if(include)
    {
        maxscore = Math.max(maxscore, sc+get(words,temp,score,ind+1));
    }
    return maxscore;
    }
}
