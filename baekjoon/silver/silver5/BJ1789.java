package silver5;
/// baekjoon 1789번 수들의 합 (실버5)

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ1789 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        /* 자연수 S(1 ≤ S ≤ 4,294,967,295)의 범위가 int 범위보다 크므로 long 타입을 사용 해 주어야 한다. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long S = Long.parseLong(br.readLine());
        long N = 1;
        long sum = 0;
        while (true) {
            sum += N;
            N++;
            if (sum + N > S) {
                N--;
                bw.write(String.valueOf(N));
                break;
            }
        }
        bw.flush();
    }
}