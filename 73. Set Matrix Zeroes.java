class Solution {
    public void zero_r(int matrix[][],int row,int C){
        for(int i=0;i<C;i++){
            matrix[row][i]=0;
        }
    }
    public void zero_c(int matrix[][],int col,int R){

        for(int i=0;i<R;i++){
            matrix[i][col]=0;
        }

    }
    public void setZeroes(int[][] matrix) {
        int R=matrix.length;
        int C=matrix[0].length;

        int row_m [] = new int [R];
        int col_m [] = new int [C];
        for(int row=0;row<R;row++){
            for(int col=0;col<C;col++){
                if(matrix[row][col]==0){
                    row_m[row]=1;
                    col_m[col]=1;
                }
            }
        }
        for(int row=0;row<R;row++){
            if(row_m[row]==1){
                    zero_r(matrix,row,C);
            }
        }
        for(int col=0;col<C;col++){
            if(col_m[col]==1){
                    zero_c(matrix,col,R);
            }
        }
    }
}
