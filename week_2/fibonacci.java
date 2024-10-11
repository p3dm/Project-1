package week_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class fibonacci {
    public static long fibonacciCompute(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return fibonacciCompute(n-1) + fibonacciCompute(n-2);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(fibonacciCompute(n-1));
    }
}
