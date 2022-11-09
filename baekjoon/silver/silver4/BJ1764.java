package silver4;
/// baekjoon 1764번 듣보잡 (실버4)

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ1764 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner scan = new Scanner(System.in);
        String str;

        HashSet<String> set = new HashSet<String>();
        int N = scan.nextInt();
        int M = scan.nextInt();
        String[] arr = new String[N + M];
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            str = scan.next();
            set.add(str);
        }

        for (int i = N; i < N + M; i++) {
            str = scan.next();
            if (set.contains(str)) {
                arr[cnt] = str;
                cnt++;
            }
        }

        /*
         * Comparator.nullsLast(Comparator.naturalOrder()) ==> sort과정에서
         * NullPointerException가 발생하는데, nullLast를 통해 null을 모든 객체의 마지막으로 보내줌으로써 오류제거
         */
        Arrays.sort(arr, Comparator.nullsLast(Comparator.naturalOrder()));

        bw.write(String.valueOf(cnt + "\n"));
        for (int i = 0; i < cnt; i++) {
            bw.write(String.valueOf(arr[i] + "\n"));
        }

        bw.flush();
        bw.close();
    }
}