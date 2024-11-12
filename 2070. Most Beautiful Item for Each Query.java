class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {

        int result[]=new int[queries.length];
        Arrays.sort(items,(x,y)-> Integer.compare(x[1],y[1]));
        for(int i=0;i<queries.length;i++){
            int price=queries[i];
            for(int j=items.length-1;j>=0;j--){
                if(items[j][0]<=price){
                    result[i]=items[j][1];
                    break;
                }
            }
        }
        return result;
    }
}
