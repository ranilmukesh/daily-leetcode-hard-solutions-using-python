class Solution {
    int[] mask;
    public int slidingPuzzle(int[][] board) {
        int n = (int)Math.pow(2, 18);
        boolean[] visited = new boolean[n];
        mask = new int[]{7, 56, 448, 3584, 28672, 229376};
        Queue<Integer> q = new LinkedList();
        int res = 1;
        int ordered = getInt(new int[][]{{1, 2, 3}, {4, 5, 0}});
        int first = getInt(board);
        if(first == ordered) return 0;
        q.add(first);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int current = q.poll();
                if(visited[current]) continue;
                visited[current] = true;
                int[] adj = getAdj(current);
                if(!visited[adj[0]]){
                    q.add(adj[0]);
                    if(ordered == adj[0]) return res;
                }
                if(!visited[adj[1]]){
                    q.add(adj[1]);
                    if(ordered == adj[1]) return res;
                }
                if(adj[2] != -1 && !visited[adj[2]]){
                    q.add(adj[2]);
                    if(ordered == adj[2]) return res;
                }
            }
            res++;
        }
        return -1;
    }


    private int[] getAdj(int current){
        int[] res = new int[3];
        if((current & mask[0]) == 0){
            res[0] = swap(current, 0, 1);
            res[1] = swap(current, 0, 3);
            res[2] = -1;
        }
        else if((current & mask[1]) == 0){
            res[0] = swap(current, 1, 0);
            res[1] = swap(current, 1, 2);
            res[2] = swap(current, 1, 4);
        }
        else if((current & mask[2]) == 0){
            res[0] = swap(current, 2, 1);
            res[1] = swap(current, 2, 5);
            res[2] = -1;
        }
        else if((current & mask[3]) == 0){
            res[0] = swap(current, 3, 0);
            res[1] = swap(current, 3, 4);
            res[2] = -1;
        }
        else if((current & mask[4]) == 0){
            res[0] = swap(current, 4, 3);
            res[1] = swap(current, 4, 5);
            res[2] = swap(current, 4, 1);
        }
        else if((current & mask[5]) == 0){
            res[0] = swap(current, 5, 2);
            res[1] = swap(current, 5, 4);
            res[2] = -1;
        }
        return res;
    }


    private int getInt(int[][] board){
        return  (board[0][0]         & mask[0]) + 
                ((board[0][1] << 3 ) & mask[1]) +
                ((board[0][2] << 6 ) & mask[2]) + 
                ((board[1][0] << 9 ) & mask[3]) + 
                ((board[1][1] << 12) & mask[4]) + 
                ((board[1][2] << 15) & mask[5]);
    }


    private int[][] getBoard(int num){
        int[][] board = new int[2][3];
        board[0][0] = num & mask[0];
        board[0][1] = (num & mask[1]) >> 3; 
        board[0][2] = (num & mask[2]) >> 6; 
        board[1][0] = (num & mask[3]) >> 9; 
        board[1][1] = (num & mask[4]) >> 12; 
        board[1][2] = (num & mask[5]) >> 15; 
        return board;
    }
    


    private int swap(int num, int i, int j){
        int valI = (i == 0 ? (num & mask[i]) : (num & mask[i]) >> (3*i));
        int valJ = (j == 0 ? (num & mask[j]) : (num & mask[j]) >> (3*j));
        return num - (num & mask[i]) - (num & mask[j]) + (valI << (3*j)) + (valJ << (3*i));
    }

    private void printBoard(int[][] b){
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(b[i][j] + " | ");
            }
            System.out.println();
        }
    }
}
