class Solution {
      
    private Board board; 
    private boolean[] cellsAlreadyVisited;
    private Queue<CellToVisit> queue = new LinkedList<>();
    private static final int MAX_JUMP_LENGTH = 6;

    public int snakesAndLadders(int[][] board) {        
        this.board = new Board(board);            
        this.cellsAlreadyVisited = new boolean[this.board.getLastCellNr() + 1];        
        queue.add(new CellToVisit(1, 0));        

        while (!queue.isEmpty()) {
            CellToVisit nextCell = queue.poll();
            boolean foundSolution = visit(nextCell.cell, nextCell.step);
            if (foundSolution) {
                return nextCell.step;
            }            
        }        
        return -1;
    }

    private boolean visit(int currentCellNr, int step) {          
        if (currentCellNr == board.getLastCellNr()) {
            return true;
        } 
        if (cellsAlreadyVisited[currentCellNr]) {
            // we already was here
            return false;
        }
        
        /**         
         * We do not need to visit the same cell twice. 
         * If that happen, it means - we were already were there 
         * and it was in LOWER number of steps.
         */
        cellsAlreadyVisited[currentCellNr] = true;

        /**
         * If we have a few regular cells to be jumped, then we can optimize that. 
         * We should jump only to the farest regular cell.
         * 
         * We still need to visit all teleporting cells like ladder or snake.
         *
         * This is super small optimization that can be omitted.         
         */
        boolean alreadyJumpedToRegularCell = false;

        int maxCellNr = Math.min(board.getLastCellNr(), currentCellNr + MAX_JUMP_LENGTH);        

        for (int nextCellNr = maxCellNr; nextCellNr > currentCellNr; nextCellNr--) {

            int cellValue = board.getValue(nextCellNr);
            if (cellValue == Board.REGULAR_CELL) {
                if (alreadyJumpedToRegularCell) {
                    continue;
                } else {
                    alreadyJumpedToRegularCell = true;
                    queue.add(new CellToVisit(nextCellNr, step + 1));                    
                }
            } else if (cellValue < currentCellNr || cellValue > currentCellNr + MAX_JUMP_LENGTH) {
                queue.add(new CellToVisit(cellValue, step + 1));                                    
            }            
        }
        return false;
    }

    class Board {

        public final static int REGULAR_CELL = -1;  

        int[][] board;
        int length;
        int lastCellNr;

        public Board(int[][] board) {
            this.board = board;
            this.length = board.length;
            this.lastCellNr = length * length;
        }

        public int getValue(int celllNr) {
            Cord cord = getCord(celllNr);            
            return board[cord.r][cord.c];            
        }

        public Cord getCord(int cellNr) {
            int reverseCellNr = lastCellNr - cellNr;            
            int row = reverseCellNr / length;
            boolean moveRight = ((length - row - 1) % 2) == 0;            

            int col = (moveRight) 
                ? (cellNr - 1) % length
                : (length - ((cellNr - 1) % length)) - 1;
            return new Cord(row, col);
        }

        public int getLastCellNr() {
            return this.lastCellNr;
        }
    }

    class Cord {
        int r;
        int c;

        public Cord(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    class CellToVisit {
        int cell;
        int step;

        public CellToVisit(int cell, int step) {
            this.cell = cell;
            this.step = step;
        }
    }
}
