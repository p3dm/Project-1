package week_2;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/***
 * Given an integer n, write a program to generate all permutations of 1, 2, ..., n in a lexicographic order
 * (elements of a permutation are separated by a SPACE character).
 * Example
 * Input
 * 3
 * Output
 * 1 2 3
 * 1 3 2
 * 2 1 3
 * 2 3 1
 * 3 1 2
 * 3 2 1
 ***/
public class permutation_generate {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        genPermutations(arr);
    }


    public static void genPermutations(int[] arr) {
        Arrays.sort(arr);  // Ensure array is sorted initially
        boolean hasNext = true;
        while (hasNext) {
            printArray(arr);
            hasNext = nextPermutation(arr);
        }
    }


    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public static boolean nextPermutation(int[] arr) {
        int i = arr.length - 2;

        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        if (i < 0) {
            return false;
        }


        int j = arr.length - 1;
        while (arr[j] <= arr[i]) {
            j--;
        }
        swap(arr, i, j);
        reverse(arr, i + 1, arr.length - 1);

        return true;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}
