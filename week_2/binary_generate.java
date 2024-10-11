package week_2;
/**Given an integer n, write a program that generates all the binary sequences of length n in a lexicographic order.
 Input
 Line 1: contains an integer n (1 <= n <= 20)
 Output
 Write binary sequences in a lexicographic ordder, eac sequence in a line

 Example
 Input
 3
 Output
 000
 001
 010
 011
 100
 101
 110
 111
**/
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class binary_generate {
     public static void main(String[] args) throws Exception{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int n = Integer.parseInt(br.readLine());
         generateBinary(n, "");
     }
     public static void generateBinary(int n, String s){
         if(n == 0){
             System.out.println(s);
             return;
         }
         generateBinary(n-1, s + "0");
         generateBinary(n-1, s + "1");
     }

}
