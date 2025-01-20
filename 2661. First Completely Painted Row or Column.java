class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length, n = mat[0].length; 

        int map[] = new int[m*n+1];

        for(int i = 0; i<arr.length; i++){
            map[arr[i]] = i; 
        }

        int ans = arr.length-1; 

        for(int i = 0; i<m; i++){
            int max = 0; 
            for(int j = 0; j<n; j++){
                max = Math.max(max, map[mat[i][j]]); 
            }
            ans = Math.min(ans, max); 
        }

        for(int j = 0; j<n; j++){
            int max = 0; 
            for(int i = 0; i<m; i++){
                max = Math.max(max, map[mat[i][j]]); 
            }
            ans = Math.min(ans, max); 
        }

        return ans; 
    }
}
