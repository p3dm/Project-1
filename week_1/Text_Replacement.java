package week_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * Cho văn bản T và 2 mẫu P1, P2 đều là các xâu ký tự (không chứa ký tự xuống dòng, độ dài không vượt quá 1000). Hãy thay thế các xâu P1 trong T bằng xâu P2.
 * Dữ liệu
 * · Dòng 1: xâu P1
 * · Dòng 2: xâu P2
 * · Dòng 3: văn bản T
 * Kết quả:
 * · Ghi văn bản T sau khi thay thế
 * Ví dụ
 * Dữ liệu
 * AI
 * Artificial Intelligence
 * Recently, AI is a key technology. AI enable efficient operations in many fields.
 * Kết quả
 * Recently, Artificial Intelligence is a key technology. Artificial Intelligence enable efficient operations in many fields.
 */
public class Text_Replacement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line1 = br.readLine();
        if (line1 == null) {
            return;
        }

        String line2 = br.readLine();
        if (line2 == null) {
            return;
        }

        String line3 = br.readLine();
        if (line3 == null) {
            return;
        }

        String P1 = line1.trim();
        String P2 = line2.trim();
        String T = line3.trim();

        String result = T.replace(P1, P2);

        System.out.println(result);
    }

}
