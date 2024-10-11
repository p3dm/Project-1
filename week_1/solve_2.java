package week_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given an equation ax^2 + bx + c = 0. Find solution to the given equation.
 * Input
 * Line 1 contains 3 integers a, b, c
 * Output
 * Write NO SOLUTION if the given equation has no solution
 * Write x0 (2 digits after the decimal point) if the given equation has one solution x0
 * Write x1 and x2 with x1 < x2 (2 digits after the decimal point) if the given equation has two distinct solutions x1, x2
 *
 * Example
 * Input
 * 1 1 8
 * Output
 * NO SOLUTION
 *
 *
 * Input
 * 1 -2 1
 * Output
 * 1.00
 *
 * Input
 * 1 -7 10
 * Output
 * 2.00 5.00
 */
public class solve_2 {
    public static int delta(int a, int b, int c) {
        return b * b - 4 * a * c;
    }

    public static void hai_nghiem_phan_biet(int a, int b, int c) {
        double x1 = (-b + Math.sqrt(delta(a, b, c))) / (2 * a);
        double x2 = (-b - Math.sqrt(delta(a, b, c))) / (2 * a);
        if (x1 < x2) {
            System.out.printf("%.2f %.2f%n", x1, x2);
        } else {
            System.out.printf("%.2f %.2f%n", x2, x1);
        }
    }

    public static void nghiem_kep(int a, int b, int c) {
        double x = -b / (2 * a);
        System.out.printf("%.2f",x);
    }

    public static void no_solution() {
        System.out.println("NO SOLUTION");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().trim().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);

        int deltaValue = delta(a, b, c);
        if (deltaValue > 0) {
            hai_nghiem_phan_biet(a, b, c);
        } else if (deltaValue == 0) {
            nghiem_kep(a, b, c);
        } else {
            no_solution();
        }
    }
}