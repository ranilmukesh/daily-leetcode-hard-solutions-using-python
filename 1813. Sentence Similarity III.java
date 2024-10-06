class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {

        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");

        int count1 = 0;
        int count2 = 0;

        int runLen = Math.min(s1.length, s2.length);

        for(int i = 0; i < runLen; i++) {
            if(s1[i].equals(s2[i])) {
                count1++;
                count2++;
            } else {
                break;
            }
        }

        for(int i = 0; i < runLen; i++) {
            if(s1[s1.length - 1 - i].equals(s2[s2.length - 1 - i])) {
                count1++;
                count2++;
            } else {
                break;
            }
        }

        if(count1 >= runLen || count2 >= runLen) {
            return true;
        }

        return false;
    }
}
