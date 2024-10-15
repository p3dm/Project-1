package week_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/***
 * Perform a sequence of operations over a queue, each element is an integer:
 * PUSH v: push a value v into the queue
 * POP: remove an element out of the queue and print this element to stdout (print NULL if the queue is empty)
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
 * 1
 * 2
 * 3
 * Input
 * PUSH 1
 * POP
 * POP
 * PUSH 4
 * POP
 * #
 * Output
 * 1
 * NULL
 * 4
 */

public class simulation_queue {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        Queue<String> queue = new LinkedList<>();
        List<String> danh_sach = new ArrayList<>();
        while ((line = br.readLine()) != null){
            if(line.equals("#")){
                break;
            }
            String[] arr = line.split(" ");
            if(arr[0].equals("PUSH")){
                queue.add(arr[1]);
            }
            else if(arr[0].equals("POP")){
                danh_sach.add(queue.isEmpty() ? "NULL" : queue.poll());
            }
        }
        for(String s : danh_sach){
            System.out.println(s);
        }
    }
}
