package silver4;
/// baekjoon 11047번 동전 0 (실버4)

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ11047 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        int num;
        for (int i = N - 1; i >= 0; i--) {
            if (arr[i] <= K) {
                num = K / arr[i];
                K -= arr[i] * num;
                cnt += num;
                if (K == 0) {
                    break;
                }
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}