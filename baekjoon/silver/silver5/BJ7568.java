package silver5;
/// baekjoon 7568번 덩치 (실버5)

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ7568 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); /* 사람 수 */
        int[][] array = new int[2][N];

        /* 사람 수만큼 키와 몸무게 할당 반복 */
        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            array[0][i] = Integer.parseInt(st2.nextToken());    /* 몸무게 */
            array[1][i] = Integer.parseInt(st2.nextToken());    /* 키 */
        }

        /* 자신보다 더 큰 덩치의 사람 수 count */
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 0; j < N; j++) {
                /* 자기 자신은 비교하지 않는다 */
                if (i == j)
                    continue;

                if (array[0][i] < array[0][j] && array[1][i] < array[1][j]) {
                    cnt++;
                }
            }
            bw.write(String.valueOf(cnt + " "));
        }
        bw.close();
    }
}