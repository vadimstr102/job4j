package ru.job4j.array;

public class MatrixCheck {
    public static boolean isWin(char[][] board) {
        boolean result = false;
        boolean resultRow = false;
        boolean resultCell = false;

        for (int row = 0; row < board.length; row++) { //Проверяем ряды
            for (int cell = 0; cell < board.length; cell++) {
                char sign = board[row][cell];
                resultRow = sign == 'X' ? true : false;
                if (!resultRow) {
                    break;
                }
            }
            if (resultRow) {
                break;
            }
        }

        for (int cell = 0; cell < board.length; cell++) { //Проверяем столбцы
            for (int row = 0; row < board.length; row++) {
                char sign = board[row][cell];
                resultCell = sign == 'X' ? true : false;
                if (!resultCell) {
                    break;
                }
            }
            if (resultCell) {
                break;
            }
        }
        if (resultRow || resultCell) {
            result = true;
        }
        return result;
    }

    public static void main(String[] args) {
        char[][] hasWinVertical = {
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
        };
        boolean win = isWin(hasWinVertical);
        System.out.println("A board has a winner : " + win);
        System.out.println();
        char[][] hasWinHor = {
                {'_', '_', '_', '_', '_'},
                {'X', 'X', 'X', 'X', 'X'},
                {'_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_'},
        };
        boolean winHor = isWin(hasWinHor);
        System.out.println("A board has a winner : " + winHor);
        System.out.println();
        char[][] notWin = {
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', 'X', '_', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
        };
        boolean lose = isWin(notWin);
        System.out.println("A board has a winner : " + lose);
    }
}
