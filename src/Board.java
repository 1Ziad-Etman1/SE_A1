public class Board {
    private char[][]board;

    public Board() {
        board = new char[3][3];
        for (int row = 0; row < 3 ; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = '-';
            }
        }
    }

    public void printBoard() {
        for (int row = 0; row < 3 ; row++) {
            for (int col = 0; col < 3 ; col++) {
                System.out.print("| "+board[row][col] +" |");
            }
            System.out.println('\n');
        }
    }

    public boolean valid(int row, int col){
        return board[row][col] == '-';
    }

    public void updateBoard(char choice, int row, int col){
        if (valid(row, col)){
            board[row][col] = choice;
        }
    }

    public boolean isDraw(){
        boolean full = true;
        for (int row = 0; row < 3 ; row++) {
            for (int col = 0; col < 3 ; col++) {
                if (board[row][col] == '-'){
                    full = false;
                    break;
                }
            }
        }
        return full;
    }

    public boolean isWinner(){
        /* Horizontally */
        for (int row = 0; row < 3 ; row++) {
            if (board[row][0] == board[row][1] && board[row][0] == board[row][2] && board[row][0] != '-'){
                return true;
            }
        }
        /* Vertically */
        for (int col = 0; col < 3 ; col++) {
            if (board[0][col] == board[1][col] && board[0][col] == board[2][col] && board[0][col] != '-') {
                return true;
            }
        }
        /* Diagonally */
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != '-') {
            return true;
        }
        else if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] != '-') {
            return true;
        }
        /* No Winner yet */
        return false;
    }
}
