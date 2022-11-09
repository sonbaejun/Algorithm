package silver4;
/// baekjoon 10773번 제로 (실버4)

import java.util.ArrayList;
import java.util.Scanner;

public class BJ10773 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int K = scan.nextInt();
        int[] arr = new int[K];
        for (int i = 0; i < K; i++) {
            arr[i] = scan.nextInt(); // K만큼 정수입력
        }
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        for (int i = 0; i < K; i++) {
            if (arr[i] == 0) {
                arrList.remove(arrList.size() - 1);
            } else {
                arrList.add(arr[i]);
            }
        }
        int sum = 0;
        for (int i = 0; i < arrList.size(); i++) {
            sum += arrList.get(i);
        }
        System.out.println(sum);
    }
}
