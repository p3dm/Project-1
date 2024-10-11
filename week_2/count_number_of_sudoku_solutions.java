package week_2;

import java.io.BufferedReader;


/***
 * Write a program to compute the number of sudoku solutions (fill the zero elements of a given partial sudoku table)
 * Fill numbers from 1, 2, 3, ..., 9 to 9 x 9 table so that:
 * Numbers of each row are distinct
 * Numbers of each column are distinct
 * Numbers on each sub-square 3 x 3 are distinct
 * Input
 * Each line i (i = 1, 2, ..., 9) contains elements of the i
 * th
 *  row of the Sudoku table: elements are numbers from 0 to 9 (value 0 means the empty cell of the table)
 * Output
 * Write the number of solutions found
 *
 * Example
 * Input
 * 0 0 3 4 0 0 0 8 9
 * 0 0 6 7 8 9 0 2 3
 * 0 8 0 0 2 3 4 5 6
 * 0 0 4 0 6 5 0 9 7
 * 0 6 0 0 9 0 0 1 4
 * 0 0 7 2 0 4 3 6 5
 * 0 3 0 6 0 2 0 7 8
 * 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0
 * Output
 * 64
 */
public class count_number_of_sudoku_solutions {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int[][] grid = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                grid[i][j] = Integer.parseInt(row[j]);
            }
        }

        System.out.println(countSudokuSolutions(grid));

    }
    public static boolean isValid(int[][] grid, int row, int col, int num){
        for (int i = 0; i < 9; i++) {
            if(grid[row][i] == num || grid[i][col] == num){
                return false;
            }
        }
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(grid[i + startRow][j + startCol] == num){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean solveSudoku(int[][] grid){
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(grid[i][j] == 0){
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if(!isEmpty){
                break;
            }
        }
        if(isEmpty){
            return true;
        }
        for (int num = 1; num <= 9; num++) {
            if(isValid(grid, row, col, num)){
                grid[row][col] = num;
                if(solveSudoku(grid)){
                    return true;
                }
                grid[row][col] = 0;
            }
        }
        return false;
    }
    public static int countSudokuSolutions(int[][] grid){
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(grid[i][j] == 0){
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if(!isEmpty){
                break;
            }
        }
        if(isEmpty){
            return 1;
        }
        int count = 0;
        for (int num = 1; num <= 9; num++) {
            if(isValid(grid, row, col, num)){
                grid[row][col] = num;
                count += countSudokuSolutions(grid);
                grid[row][col] = 0;
            }
        }
        return count;
    }
}
