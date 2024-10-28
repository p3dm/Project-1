package week_4;
/***
 * Cho dãy a1, a2, ..., an trong đó các phần tử đôi một khác nhau và 1 giá trị nguyên dương M. Hãy đếm số Q các cặp (i,j) sao cho 1 <= i < j <= n và ai + aj = M.
 *
 * Dữ liệu
 * Dòng 1: ghi n và M (1 <= n, M <= 1000000)
 * Dòng 2: ghi a1, a2, ..., an
 * Kết quả
 * Ghi ra giá trị Q
 * Ví dụ
 * Dữ liệu
 * 5 6
 * 5 2 1 4 3
 * Kết quả
 * 2
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Sum_part_of_sequence_equal_to_a_number {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int complement = k - arr[i];
            if (set.contains(complement)) {
                count++;
            }
            set.add(arr[i]);
        }
        System.out.println(count);
    }
}
