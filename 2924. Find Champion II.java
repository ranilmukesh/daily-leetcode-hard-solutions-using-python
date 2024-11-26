class Solution {
    
    
    public int findChampion(int n, int[][] edges) {
        int[] incoming = new int[n];
        int count = n;
        
        for(int[] row : edges){
            if(incoming[row[1]] == 0){
                count -= 1;
            }
            incoming[row[1]]+=1;
        }
        
        
        if(count == 1){
            for(int i = 0 ; i < n ; i++){
                if(incoming[i] == 0){
                    return i;
                }
            } 
        }
        
        return -1;
    }
}
