import java.util.Scanner;

public class Game {
    private Board board;
    private Player P1;
    private Player P2;
    private int turn;

    public Game(){
        turn = 0;
    }

    public void changeTurn(){
        turn = (turn + 1) % 2 ;
    }

    public void XOGame(){
        Scanner in = new Scanner(System.in);
        board = new Board();

        System.out.println("             Welcome to XO Game\n");

        System.out.print("Please Player 1 Enter your name: ");
        String name1 = in.next();
        P1 = new Player(name1,'X');

        System.out.print("Please Player 2 Enter your name: ");
        String name2 = in.next();
        P2 = new Player(name2,'O');

        board.printBoard();

        while (!board.isDraw()){
            /* Player 1 turn */
            while (true){
                System.out.print(P1.Name + " Enter the row and column (separated by space): ");
                int row = in.nextInt();
                int col = in.nextInt();
                if (board.valid(row, col)){
                    board.updateBoard('X', row, col);
                    break;
                }
            }
            board.printBoard();
            if(board.isWinner()){
                System.out.println(P1.Name + " Win!!!!");
                break;
            }
            /* Player 2 turn */
            while (true){
                System.out.print(P2.Name + " Enter the row and column (separated by space): ");
                int row = in.nextInt();
                int col = in.nextInt();
                if (board.valid(row, col)){
                    board.updateBoard('O', row, col);
                    break;
                }
            }
            board.printBoard();
            if(board.isWinner()){
                System.out.println(P2.Name + " Win!!!!");
                break;
            }
        }
        if (board.isDraw()){
            System.out.println("Draw!");
        }
    }

}
