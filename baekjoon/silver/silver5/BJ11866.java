package silver5;
// baekjoon 11866번 요세푸스 문제0 (실버5)

import java.util.Scanner;

public class BJ11866 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int K = scan.nextInt();

        int[] Narr = new int[N];
        for (int i = 0; i < N; i++) {
            Narr[i] = i;
        }

        int answerCount = 0;
        int index = -1;
        int leftMovePoint = K;

        System.out.print("<");
        /* 배열을 순회하며 해당 인덱스가 -1이면 카운팅하지않고 K만큼 카운팅 */
        while (answerCount < N) {
            index = (index + 1) % N;
            if (Narr[index] == -1) {
                //SKIP
            } else {
                leftMovePoint--;
                if (leftMovePoint == 0) {
                    System.out.print(index + 1);
                    leftMovePoint = K;
                    Narr[index] = -1;
                    answerCount++;

                    if (answerCount == N) {
                        break;
                    } else {
                        System.out.print(", ");
                    }
                }
            }
        }
        System.out.print(">");
        scan.close();
    }
}
