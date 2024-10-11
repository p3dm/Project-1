package week_1;

/**
 * Given 2 integers a and b. Compute a+b, a-b, a*b, a/b.
 * Input
 * Line 1 contains 2 integers a and b (1 <= a,b <= 1000)
 * Output
 * Write a+b, a-b, a*b, a/b  (4 integers are separated by a SPACE characters)
 * Example
 * Input
 * 9 4
 * Output
 * 13 5 36 2
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Add_Subtract_Multiplication_Division_of_A_and_B {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);
        System.out.println((a + b) + " " + (a - b) + " " + (a * b) + " " + (a / b));

    }
}
