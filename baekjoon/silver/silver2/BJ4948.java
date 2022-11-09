package silver2;
//baekjoon 4948번 베르트랑 공준문제(실버2)
//너무 안좋은 시간 복잡도로 품

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ4948 {
    public static int sosu(int i) {
        int cnt = 0;
        for (int j = 2; j <= i; j++) {
            if (i % j == 0) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int range = 123456 * 2;
        int[] testcase = new int[range + 1];
        testcase[1] = 1;
        int gop = (int) Math.sqrt(range);
        for (int i = 2; i <= gop; i++) {
            if (sosu(i) == 1) {
                for (int j = i + i; j <= range; j += i) {
                    testcase[j] = 1;
                }
            }
        }
        int cnt = 0;
        while (true) {
            int w = scan.nextInt();
            if (w == 0) {
                break;
            } else {
                for (int i = w + 1; i <= w * 2; i++) {
                    if (testcase[i] == 0)
                        cnt++;
                }
                System.out.println(cnt);
                cnt = 0;
            }
        }
    }
}