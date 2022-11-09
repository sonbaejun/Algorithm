package silver5;
/// baekjoon 9625번 BABBA (실버5)

import java.util.Scanner;

public class BJ9625 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int K = scan.nextInt();
        int A = 0;
        int B = 1;
        int sum = 0;

        for (int i = 1; i < K; i++) {
            sum = A + B;
            A = B;
            B = sum;
        }

        System.out.println(A + " " + B);
    }
}