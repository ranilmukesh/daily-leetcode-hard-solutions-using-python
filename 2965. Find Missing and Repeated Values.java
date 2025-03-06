class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int l = grid.length;
        int[] arr = new int[(l*l)+1];   
        int[] ans = new int[2];
        for(int i=0; i<l; i++){
            for(int j=0; j<l; j++){
                if(arr[grid[i][j]] == 1){
                    ans[0] = grid[i][j];
                }
                else{
                    arr[grid[i][j]] = 1;
                }
            }
        }
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 0){
                ans[1] = i;
            }
        }
        return ans;
    }
}
