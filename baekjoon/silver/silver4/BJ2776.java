package silver4;
/// baekjoon 2776번 암기왕 (실버4)

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ2776 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /* HashSet은 컬렉션 내에 값이 존재하는지 여부를 확인하는데 최적화된 자료 구조이다.(hash.contain()) */
        /* HashSet은 중복을 허용하지 않으니 그 점에 유의해서 사용하자.*/
        HashSet<Integer> set = new HashSet<Integer>();
        int T = Integer.parseInt(br.readLine());
        int index;

        for (int j = 0; j < T; j++) {
            set.clear();
            int N = Integer.parseInt(br.readLine());
            /* 정규식이나 인덱스 접근과 같은 처리가 필요없다면 StringTokenizer를 사용하는 것이 더 효율적이다.(속도면에서), 공백 단위로 토큰 구분*/
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                set.add(Integer.parseInt(st.nextToken()));
            }

            int M = Integer.parseInt(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                if (set.contains(Integer.parseInt(st2.nextToken()))) {
                    bw.write(String.valueOf(1) + "\n");
                } else {
                    bw.write(String.valueOf(0) + "\n");
                }
            }
            bw.flush();
        }
        bw.close();
    }
}