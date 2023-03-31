package sudoku;

import java.util.Arrays;

public class Sudoku {
    
    public static char verificarCelula(char[][] board, int i2, int j2) {
        int num_solucoes = 0;
        int inicio_i = i;
        int inicio_j = j;
        if (i % 3 != 1)
            inicio_i -= i%3 == 0? 2 : 1;
        if (j % 3 != 1)
            inicio_j -= j%3 == 0? 2 : 1;
        for (char k = 49; k <= 57; k++) {
            invalido = false;
            for (int i = inicio_i; i <= inicio_i+2; i++) {
                for (int j = inicio_j; j <= inicio_j+2; j++) {
                    if (board[i][j] == k) {
                        invalido = true;
                        break;
                    }
                }
                if (invalido == true)
                    break;
            }
            if (invalido == false)
                for (int j = 1; j <= 9; j++)
                    if (board[i2][j] == k) {
                        invalido = true;
                        break;
                    }
            if (invalido == false)
                for (int i = 1; i <= 9; i++)
                    if (board[i][j2] == k) {
                        invalido = true;
                        break;
                    }
            if (invalido == false) {
                num_solucoes++;
                solucao = k;
            }
        }
        return num_solucoes == 1? solucao : 48;
    }
    
    public static void solveSudoku(char[][] board) {
        do {   
            incompleto = false;
            for (i = 1; i <= 9; i++) {
                for (j = 1; j <= 9; j++) {
                    if (board[i][j] == 48) {
                        incompleto = true;
                        board[i][j] = verificarCelula(board,i,j);
                    }
                }
            }
        } while (incompleto == true);
    }

    static int i, j;
    static char solucao;
    static boolean invalido, incompleto;
    
    public static void main(String[] args) {
        char[][] board = {
            {48,48,48,48,  48,48,48,  48,48,48},
            
            {48,48,48,49,  48,48,48,  53,48,48},
            {48,48,57,48,  54,48,49,  48,52,48},
            {48,54,48,48,  50,48,53,  48,48,57},
            
            {48,48,51,53,  48,48,48,  52,57,48},
            {48,48,48,48,  48,56,48,  48,48,48},
            {48,48,49,55,  48,48,48,  56,54,48},
            
            {48,49,48,48,  57,48,50,  48,48,55},
            {48,48,50,48,  53,48,56,  48,49,48},
            {48,48,48,56,  48,48,48,  57,48,48}
        };
        System.out.println(" _____________________");
        for (i = 1; i <= 9; i++) {
            System.out.print("| ");
            for (j = 1; j <= 9; j++) {
                System.out.print(board[i][j]+" ");
                if (j == 3 || j == 6)
                    System.out.print(" ");
            }
            System.out.println("|");
            if (i == 3 || i == 6)
                System.out.println();
                
        }
        System.out.println(".---------------------.");
        solveSudoku(board);        
        System.out.println(" _____________________");
        for (i = 1; i <= 9; i++) {
            System.out.print("| ");
            for (j = 1; j <= 9; j++) {
                System.out.print(board[i][j]+" ");
                if (j == 3 || j == 6)
                    System.out.print(" ");
            }
            System.out.println("|");
            if (i == 3 || i == 6)
                System.out.println();
                
        }
        System.out.println(".---------------------.");
    }
}