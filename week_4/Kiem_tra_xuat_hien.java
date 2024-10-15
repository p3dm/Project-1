package week_4;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Kiem_tra_xuat_hien {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if(set.contains(arr[i])){
                System.out.println("1");
            } else {
                System.out.println("0");
                set.add(arr[i]);
            }
        }
    }
}
