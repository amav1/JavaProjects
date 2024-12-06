public class TicTacToeGame {
    private char[][] board;
    private int turns;

    private static final char X = 'X';
    private static final char O = 'O';
    private static final char EMPTY = ' ';
    private static final char OUT_OF_BOUNDS = '@';

    /**
     * Creates a new tic-tac-toe game instance and initializes the
     * internal state of the game. After this method is called, the
     * newly created game board is filled with '_' (empty spaces) to
     * indicate that players have not yet occupied any spots.
     */
    public TicTacToeGame() {
        board = new char[3][3];
        turns = 0;

        for (int r = 0; r < 3; r++ ) {
            for (int c = 0; c < 3; c++ ) {
                board[r][c] = EMPTY;
            }
        }
    }

    /**
     * Makes a move for the specified player, {@code p}, at location
     * ({@code r}, {@code c}) within the game board. If the move is invalid,
     * the method has no effect on the underlying board. The move is invalid
     * when the space is already occupied or the space is out of bounds.
     * Note: This method also increases the number of turns played if the move
     * is successful.
     *
     * @param p the character representing the player making the move.
     * @param r the row where the move is being made.
     * @param c the column where the move is being made.
     */
    public void playMove( char p, int r, int c ) {
        if (p!=X && p!=O){
            System.out.println("Invalid move");
            return;
        }
        if (board[r][c] != EMPTY){
            System.out.println("Invalid move");
            return; //if the row/column entry is not empty then its invalid
        }
        if((r < 0 || r >= 3) || (c < 0 || c >= 3)){
            System.out.println("Invalid move");
            return; //using the boundaries of the board, if it goes out of bounds it's invalid
        }
        board[r][c] = p;
        turns++;
        
    }

    /**
     * Returns whether the specified character, {@code p}, has
     * won the game.
     *
     * @return {@code true} if {@code p} has won the game and {@code false}
     * otherwise.
     * @param p the character to check.
     */
    public boolean isWinner(char p) {
        if (p != X && p != O) {
            return false; 
        }

        return checkRows(p) || checkColumns(p) || checkDiagonals(p);
    }
    	private boolean checkRows(char p) {
    	    for (int r = 0; r < 3; r++) {
    	        if (p == board[r][0] && p == board[r][1] && p == board[r][2]) {
    	            return true; 
    	        } //checks that within the board boundaries, there's an x or o in every row entry
    	    }
    	    return false; 
    	}

    	private boolean checkColumns(char p) {
    	    for (int c = 0; c < 3; c++) {
    	        if (p == board[0][c] && p == board[1][c] && p == board[2][c]) {
    	            return true; 
    	        } //starting from 0, checks that for every column entry there is an X or O and then counts it as a win
    	    }
    	    return false; 
    	}

    	private boolean checkDiagonals(char p) {
    	    if (p == board[0][0] && p == board[1][1] && p == board[2][2]) {
    	        return true; //checks main diagonal
    	    }
    	    if (p == board[0][2] && p == board[1][1] && p == board[2][0]) {
    	        return true; //checks reverse diagonal
    	    }
    	    return false; 
    	}

    
      
    /**
     * Returns whether the game board is full.
     *
     * @return {@code true} if the board is full and {@code false} otherwise.
     */
    	public boolean isFull() {
    	    for (int r = 0; r < 3; r++) {
    	        for (int c = 0; c < 3; c++) {
    	            if (board[r][c] == EMPTY) { // if any space is vacant then it returns false boolean
    	                return false; 
    	            }
    	        }
    	    }
    	    return true;  // otherwise it's true
    	}

    /**
     * Returns whether the game is a tie or not.
     * @return {@code true} if the game is a tie and {@code false} otherwise.
     */
    public boolean isTie() {
    	int numX = 0;
    	int numO = 0;
    	
    	for (int r = 0; r < 3; r++) {
	        for (int c = 0; c < 3; c++) {
	        	if (board[r][c] == X) {
	        		numX++;
	        	}else if(board[r][c] == O){
	        		numO++;
	        	}
	        }
    	}
	    return (numX == numO);
    }

    /**
     * Returns whether the specified coordinates, {@code r} and {@code c} fall
     * within the boundaries of the game board.
     * @param r the row number to check.
     * @param c the column number to check.
     * @return {@code true} if the specified coordinates are in bounds and
     * {@code false} otherwise.
     */
    public boolean isInBounds( int r, int c ) {
        if (0 <= r && r <= 2 && 0 <= c && c <= 2) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns the number of turns taken so far in the game.
     * @return the number of turns taken so far.
     */
    public int numTurns() {
        return turns;
    }

    /**
     * Returns the player occupying the board location at the specified coordinates,
     * {@code r} and {@code c}.
     * @param r the row value to check.
     * @param c the column value to check.
     * @return the character representing the player located at position
     * ({@code r},{@code c} on the board. If the location is out of bounds, the method
     * returns the {@code @} character.
     */
    public char playerAt( int r, int c ) {
        if (isInBounds(r,c)) {
            return board[r][c];
        } else {
            return OUT_OF_BOUNDS;
        }
    }

    //Prints the contents of the game board.
    public void displayBoard() {
        System.out.println("  0  " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("    --+-+--");
        System.out.println("  1  " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("    --+-+--");
        System.out.println("  2  " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
        System.out.println("     0 1 2 ");
    }

}