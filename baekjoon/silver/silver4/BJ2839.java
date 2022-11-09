package silver4;
// #baekjoon 2839번 설탕배달문제(실버4)

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;


public class BJ2839 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int cnt = 0;

        for (int i = N / 5; i >= 0; i--) {
            int num5 = N - (i * 5);
            if (num5 % 3 == 0) {
                int num3 = num5 / 3;
                cnt += i + num3;
                System.out.println(cnt);
                break;
            }
        }
        if (cnt == 0)
            System.out.println("-1");
    }
}