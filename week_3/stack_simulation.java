package week_3;

/***
 * Perform a sequence of operations over a stack, each element is an integer:
 * PUSH v: push a value v into the stack
 * POP: remove an element out of the stack and print this element to stdout (print NULL if the stack is empty)
 * Input
 * Each line contains a command (operration) of type
 * PUSH  v
 * POP
 * Output
 * Write the results of POP operations (each result is written in a line)
 * Example
 * Input
 * PUSH 1
 * PUSH 2
 * PUSH 3
 * POP
 * POP
 * PUSH 4
 * PUSH 5
 * POP
 * #
 * Output
 * 3
 * 2
 * 5
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class stack_simulation {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        String line;
        List<String> danh_sach = new ArrayList<>();
        while((line = br.readLine())!= null){
            if(line.equals("#")){
                break;
            }
            String[] arr = line.split(" ");
            if(arr[0].equals("PUSH")) {
                stack.push(Integer.parseInt(arr[1]));
            }else if(arr[0].equals("POP")){
                danh_sach.add(stack.isEmpty() ? "NULL" : String.valueOf(stack.pop()));
            }


        }
        for(String s : danh_sach){
            System.out.println(s);
        }
    }
}
