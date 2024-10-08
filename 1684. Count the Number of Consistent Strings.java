class Solution {
   
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] allowedArr = insert(allowed);
        int count = 0;
        for(String eachElement: words){
            if(search(eachElement, allowedArr)){
                count++;
            }
        }
        return count;
    }
    private boolean[] insert(String allowed){
        boolean[] allowedArr = new boolean[26];
        for(int i = 0; i < allowed.length(); i++){
            int index = allowed.charAt(i) - 'a';
            if(!allowedArr[index]){
                allowedArr[index] = true;
            }
        }
        return allowedArr;
    }
    
    private boolean search(String word, boolean[] allowedArr){
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(!allowedArr[index]){
                return false;
            }
        }
        return true;
    }
 
}
