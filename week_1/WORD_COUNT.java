package week_1;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.lang.StringBuilder;

/**
 * Given a Text, write a prorgam to count the number Q of words (ignore characters SPACE, TAB, LineBreak) of this Text
 * Input
 * The Text
 * Output
 * Write the number Q of words
 * Example
 * Input
 * Hanoi University Of Science and Technology
 * School of Information and Communication Technology
 * Output
 * 12
 */
public class WORD_COUNT {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder input = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null){
            input.append(line).append(" ");
        }
        int wordCount = 0;
        for (int i = 0; i < input.length(); i++){
            if (input.charAt(i) == ' ' || input.charAt(i) == '\t' || input.charAt(i) == '\n'){
                wordCount++;
            }
        }

        System.out.println(wordCount);
    }
}
