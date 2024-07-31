class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        Integer[] memo=new Integer[books.length];
        return helper(0,books,shelfWidth,memo);
    }
    private static int helper(int index,int[][] books, int shelfWidth,Integer[] memo){
        if(index>=books.length)
            return 0;
        if(memo[index]!=null)return memo[index];
        int currentWidth=shelfWidth;
        int result=Integer.MAX_VALUE;
        int max=0;

        for(int i=index;i<books.length;i++){
            int width=books[i][0];
            int height=books[i][1];
            if(width>currentWidth)
                break;
                currentWidth-=width;
                max=Math.max(max,height);
                result=Math.min(result,helper(i+1,books,shelfWidth,memo)+max);
            
        }
        return memo[index]=result;
    }
}
