package silver2;/// baekjoon 16953번 A -> B (실버2)

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ16953 {
    /* Hint : B -> A 로 가는 과정의 수는 끝이 1이거나 짝수밖에 없다 */
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int cnt = 1;
        while (true) {
            if (A > B) {
                cnt = -1;
                bw.write(String.valueOf(cnt));
                break;
            }
            if (A == B) {
                bw.write(String.valueOf(cnt));
                break;
            }
            if (B % 10 == 1) {
                B /= 10;
                cnt++;
            } else if (B % 2 == 0) {
                B /= 2;
                cnt++;
            } else {
                cnt = -1;
                bw.write(String.valueOf(cnt));
                break;
            }
        }
        bw.flush();
        bw.close();
    }
}