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
import java.util.Scanner;

public class Add_Subtract_Multiplication_Division_of_A_and_B {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(a + b + " " + (a - b) + " " + a * b + " " + a / b);

    }
}
