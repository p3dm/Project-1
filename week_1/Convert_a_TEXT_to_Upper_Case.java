package week_1;

/**
 * Given a TEXT, write a program that converts the TEXT to upper-case.
 *
 * Input
 * The TEXT
 *
 * Output
 * The TEXT in which characters are converted into upper-case
 *
 * Example
 * Input
  Hello John,
  How are you?

  Bye,
 *
 * Output
  HELLO JOHN,
  HOW ARE YOU?

  BYE,
 **/
import java.util.Scanner;
public class Convert_a_TEXT_to_Upper_Case {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder text = new StringBuilder();
        String line;
        while ( !(line = scanner.nextLine()).isEmpty()){
            text.append(line).append("\n");
        }
        System.out.println(text.toString().toUpperCase());
    }
}
