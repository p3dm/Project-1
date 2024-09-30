package week_1;
/**
 *Given a positive integer n, find all integer having 3 digits which is divisible by n.
 *Input
 *Line 1: contains a positive integer n (1 <= n <= 999)
 *Output
 *Write the sequence of numbers found (elements are separated by a SPACE character)

 *Example
 *Input
 *200

 *Output
 *200 400 600 800
 **/
import java.util.Scanner;

public class list_sequence_of_integer_having_3_digits_divisible_by_n {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StringBuilder so_chia_het_cho_n = new StringBuilder();
        for (int i = 100; i < 1000; i++){
            if (i % n == 0){
                so_chia_het_cho_n.append(i).append(" ");
            }
        }
        System.out.println (so_chia_het_cho_n.toString().trim());

    }
}

