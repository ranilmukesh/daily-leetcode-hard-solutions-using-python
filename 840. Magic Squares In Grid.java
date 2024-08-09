class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        if(row < 3 || col < 3) return 0;
        int ans = 0;
        for(int i = 1; i < row - 1; i ++)
        {
            for(int j = 1; j < col-1; j++)
            {
                if(grid[i][j] != 5) continue;
                if(isMagicSquares(grid,i,j)) ans++;
            }
        }

        return ans;
    }

    public boolean isMagicSquares(int[][] grid, int x, int y)
    {
        int[] count = new int[10];
        int idx = 0;
        int countForNum = 0;
        for(int i = -1; i <= 1; i++)
        {
            for(int j = -1; j <= 1; j++)
            {
                if(grid[x+i][y+j] < 10)
                {
                    count[grid[x+i][y+j]]++;
                }
            }
        }
        for(int i = 1; i <=9; i++)
        {
            countForNum+=count[i];
            if(count[i]!=1) return false;
        }
        if(countForNum > 9) return false;
        int rowOne = grid[x-1][y-1]+grid[x-1][y]+grid[x-1][y+1];
        int rowTwo = grid[x][y-1]+grid[x][y]+grid[x][y+1];
        int rowThree = grid[x+1][y-1]+grid[x+1][y]+grid[x+1][y+1];

        int colOne = grid[x-1][y-1]+grid[x-1][y]+grid[x-1][y+1];
        int colTwo = grid[x-1][y]+grid[x][y]+grid[x+1][y];
        int colThree = grid[x-1][y+1]+grid[x][y+1]+grid[x+1][y+1];

        int diagonalOne = grid[x-1][y-1]+grid[x][y]+grid[x+1][y+1];
        int diagonalTwo = grid[x-1][y+1]+grid[x][y]+grid[x+1][y-1];

        return (rowOne == 15 && rowTwo == 15 && rowThree == 15 && colOne == 15 && colTwo ==15 && colThree ==15 && diagonalOne==15 && diagonalTwo ==15); 
    }
}
