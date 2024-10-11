package week_1;
/**
 * Given an integer n, print numbers from 1 to n and its squares.
 * Input
 * Line 1: contains a positive integer n (1 <= n <= 100)
 * Output
 * Each line i (i = 1,...,n): contains i and i^2 (elements are separated by one SPACE character)
 *
 * Example
 * Input
 * 3
 * Output
 * 1 1
 * 2 4
 * 3 9
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;



public class list_number_from_1_to_n_and_its_square {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 1; i <= n; i++){
            System.out.println(i + " " + (int)Math.pow(i,2));
        }

    }
}
