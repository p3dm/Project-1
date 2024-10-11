package week_1;

/**
 * Given a sequence of integer a1, a2, ..., an. Count the number of odd elements and even elements of the sequence.
 * Input
 * Line 1: contains a positive integer n (1 <= n <= 100000)
 * Line 2: contains a1, a2, ..., an. (1 <= ai <= 1000000)
 * Output
 * Write the number of odd elements and the number of even elements (separated by a SPACE character)
 *
 * Example
 * Input
 * 6
 * 2 3 4 3 7 1
 * Output
 * 4 2
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class count_odd_and_even_number {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int odd = 0;
        int even = 0;
        for (int i = 0; i < n; i++) {
            if (Integer.parseInt(arr[i]) % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        System.out.println(odd + " " + even);
    }
}