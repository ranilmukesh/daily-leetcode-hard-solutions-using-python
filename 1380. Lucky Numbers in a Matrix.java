class Solution {
    public static int minFunc(int i,int j,int matrix[][]){
        int min=Integer.MAX_VALUE;int minIdx=-1;
        for(j=0;j<matrix[0].length;j++){
            if(min>matrix[i][j]){
                minIdx=j;
                min=matrix[i][j];
            }
        }
            return minIdx;
        
    }
    public static int maxFunc(int i,int j,int matrix[][]){
        int max=matrix[i][j];
        for(i=0;i<matrix.length;i++){
            if(max<matrix[i][j]){
                return -1;
            }
        }
        return 0;
    }
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
                int min=minFunc(i,0,matrix);
                int max=maxFunc(i,min,matrix);
                if(max!=-1){
                    list.add(matrix[i][min]);
                    break;
        }
}
return list;
}
}
