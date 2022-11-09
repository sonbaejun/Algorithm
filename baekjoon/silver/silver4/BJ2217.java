package silver4;
/// baekjoon 2217번 로프 (실버4)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2217 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int max = arr[N - 1];
        int cnt = 2;
        int num;
        for (int i = N - 2; i >= 0; i--) {
            num = arr[i] * cnt;
            if (num > max) {
                max = num;
            }
            cnt++;
        }
        System.out.println(max);
    }
}