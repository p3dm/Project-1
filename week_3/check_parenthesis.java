package week_3;

/***
 * Given a string containing only characters (, ), [, ] {, }. Write a program that checks whether the string is correct in expression.
 * Example
 *  ([]{()}()[]): correct
 *  ([]{()]()[]): incorrect
 * Input
 * One line contains the string (the length of the string is less than or equal to $10^6$)One line contains the string (the length of the string is less than or equal to 10
 * 6
 * )
 * Output
 * Write 1 if the sequence is correct, and write 0, otherwise
 * Example
 * Input
 * (()[][]{}){}{}[][]({[]()})
 * Output
 * 1
 */
import java.io.BufferedReader;
import java.util.Stack;
import java.io.InputStreamReader;

public class check_parenthesis {
    public static boolean checkParenthesis(String s){
        Stack<Character> check = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '['|| s.charAt(i) == '{'){
                check.push(s.charAt(i));
            }
            else {
                if(!check.isEmpty() &&
                    ((s.charAt(i) == ')' && check.peek() == '(') ||
                    (s.charAt(i) == ']' && check.peek() == '[') ||
                    (s.charAt(i) == '}' && check.peek() == '{'))){
                        check.pop();
                    }
                    else {
                        return false;
                    }
            }
        }
        return check.isEmpty();
    }
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(checkParenthesis(s) ? 1 : 0);
    }
}

