package week_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class subsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String[] input = br.readLine().trim().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        int Q = 0;
        int sum = 0;


        for (int i = 0; i < k; i++) {
            sum += a[i];
        }


        if (sum % 2 == 0) {
            Q++;
        }


        for (int i = 1; i <= n - k; i++) {
            sum = sum - a[i - 1] + a[i + k - 1];

            if (sum % 2 == 0) {
                Q++;
            }
        }


        System.out.println(Q);
    }
}

