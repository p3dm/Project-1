package week_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/***
 * Given an integer n, write a program that generates all binary sequences without consecutive 11 in a lexicographic order.
 * Input
 * Line 1: contains an integer n (1 <= n <= 20)
 * Output
 * Write binary sequences in a lexicographic order, each sequence in a line
 * Example
 * Input
 * 3
 * Output
 * 000
 * 001
 * 010
 * 100
 * 101
 */

public class binary_sequence_without_consecutive_11 {
    public static String nextBinary(String s){
        int n = s.length();
        char[] arr = s.toCharArray();
        for(int i = n - 1; i >= 0 ; i-- ){
            if(arr[i] == '0'){
                arr[i] = '1';
                return new String(arr);
            }
            arr[i] = '0';
        }
        return new String(arr);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String arr = "";
        for (int i = 0; i < n; i++) {
            arr = arr + "0";
        }
        for (int i = 0; i < Math.pow(2, n); i++) {
            if (!arr.contains("11")) {
                System.out.println(arr);
            }
            arr = nextBinary(arr);
        }
    }
}