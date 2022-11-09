package silver4;
/// baekjoon 2164번 카드2 (실버4)

import java.util.ArrayList;
import java.util.Scanner;

public class BJ2164 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        int[] arr = new int[2 * N];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }
        int prevIndex = 1;
        int lastIndex = N;

        while (N-- > 1) {
            prevIndex++;
            arr[lastIndex + 1] = arr[prevIndex];
            lastIndex++;
            prevIndex++;
        }

        System.out.println(arr[prevIndex]);
    }
}