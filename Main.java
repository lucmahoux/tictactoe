package tictactoe;
import java.util.Scanner;

public class Main {

    static char[][] matrix = new char[3][3];
    static int nbO = 0;
    static int nbX = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // write your code here
        initBoard();
        play('X');
    }

    public static void initBoard(){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                matrix[i][j] = ' ';
            }
        }
    }

    public static void drawBoard(){
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static boolean occupied(int i, int j){
        return matrix[i][j] == 'X' || matrix[i][j] == 'O';
    }

    public static void play(char ch){
        System.out.println("Enter the coordinates:");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        if (a < 1 || b < 1 || a > 3 || b > 3){
            System.out.println("Coordinates should be from 1 to 3!");
            play(ch);
            return;
        }
        if (b == 1){
            b = 2;
        } else if (b == 2) {
            b = 1;
        } else {
            b = 0;
        }
        a -= 1;
        if (occupied(b, a)){
            System.out.println("This cell is occupied! Choose another one!");
            play(ch);
        } else {
            if (ch == 'X'){
                matrix[b][a] = 'X';
                drawBoard();
                if (result()) {
                } else {
                    play('O');
                }
            } else {
                matrix[b][a] = 'O';
                drawBoard();
                if (result()){
                } else {
                    play( 'X');
                }

            }

        }
    }

    public static boolean result() {
        boolean winO = false;
        boolean winX = false;
        for (int i = 0; i < 3; i++) {
            if (matrix[i][0] == matrix[i][1] && matrix[i][0] == matrix[i][2] && matrix[i][0] == 'O') {
                winO = true;
            }
            if (matrix[i][0] == matrix[i][1] && matrix[i][0] == matrix[i][2] && matrix[i][0] == 'X') {
                winX = true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (matrix[0][i] == matrix[1][i] && matrix[0][i] == matrix[2][i] && matrix[0][i] == 'O') {
                winO = true;
            }
            if (matrix[0][i] == matrix[1][i] && matrix[0][i] == matrix[2][i] && matrix[0][i] == 'X') {
                winX = true;
            }
        }
        if (matrix[0][0] == matrix[1][1] && matrix[2][2] == matrix[0][0] && matrix[0][0] == 'O') {
            winO = true;
        }
        if (matrix[0][0] == matrix[1][1] && matrix[2][2] == matrix[0][0] && matrix[0][0] == 'X') {
            winX = true;
        }
        if (matrix[0][2] == matrix[1][1] && matrix[2][0] == matrix[0][2] && matrix[0][2] == 'O') {
            winO = true;
        }
        if (matrix[0][2] == matrix[1][1] && matrix[2][0] == matrix[0][2] && matrix[0][2] == 'X') {
            winX = true;
        }

        if (winO == winX) {
            if (!winO){
                if (!gameNotFinished()) {
                    System.out.println("Draw") ;
                    return true;
                } else {
                    return false;
                }
            } else {
                System.out.println("Impossible");
                return true;
            }
        } else if (winO) {
            System.out.println("O wins");
            return true;
        } else {
            System.out.println("X wins");
            return true;
        }
    }

    public static boolean possible(){
        int dif;
        dif = nbO - nbX;
        return dif <= 1 && dif >= (-1);
    }

    public static boolean gameNotFinished(){
        boolean flag = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == ' ' || matrix[i][j] == '_') {
                    flag = true;
                    break;
                }
            }
        }
        if (flag) {
            System.out.println("Game not finished");
            return true;
        } else {
            return false;
        }
    }
}
