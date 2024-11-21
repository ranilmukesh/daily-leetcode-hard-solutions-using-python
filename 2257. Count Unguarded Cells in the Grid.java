class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
       int[][] arr=new int[m][n];
       for(int i=0;i<guards.length;i++){
            arr[guards[i][0]][guards[i][1]]=1;
       }
       for(int j=0;j<walls.length;j++){
            arr[walls[j][0]][walls[j][1]]=1;
       }
       for(int j=0;j<guards.length;j++){
            int x=guards[j][0],y=guards[j][1];
            for(int i=y+1;i<n;i++){
                if(arr[x][i]==1 || arr[x][i]==2)
                    break;
                arr[x][i]=-1;
            }
            for(int i=y-1;i>=0;i--){
                if(arr[x][i]==1 || arr[x][i]==2)
                    break;
                arr[x][i]=-1;
            }
            for(int i=x+1;i<m;i++){
                if(arr[i][y]==1 || arr[i][y]==2){
                    break;
                }
                arr[i][y]=-1;
            }
            for(int i=x-1;i>=0;i--){
                if(arr[i][y]==1 || arr[i][y]==2){
                    break;
                }
                arr[i][y]=-1;
            }
       }
       int count=0;
       for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(arr[i][j]==0){
                count++;

            }
        }
       }
       return count;
    }
}
