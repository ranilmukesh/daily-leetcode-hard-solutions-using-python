class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] PS=new int[words.length+1];
        int[] result=new int[queries.length];
        for(int i=0;i<words.length;i++)
        {
            if(isVowelString(words[i]))
            {
                PS[i+1]=PS[i]+1;
            }else{
                PS[i+1]=PS[i];
            }
        }
        for(int i=0;i<queries.length;i++)
        {
            int left=queries[i][0];
            int right=queries[i][1];
            result[i]=PS[right+1]-PS[left];
        }
        return result;
    }
    private static boolean isVowelString(String word)
    {
        String vowel="aeiou";
        return vowel.indexOf(word.charAt(0))!=-1 && vowel.indexOf(word.charAt(word.length()-1))!=-1;
    }
}
