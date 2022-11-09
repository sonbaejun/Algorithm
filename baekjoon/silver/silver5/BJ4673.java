package silver5;
////baekjoon 4673번 self number(실버5)

import java.util.Scanner;


public class BJ4673 {

    static int dn(int i) {
        int num = i;
        while (i != 0) {
            num += i % 10;
            i /= 10;
        }
        return num;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int d[] = new int[10036];
        for (int i = 1; i <= 10000; i++) {
            d[dn(i)] = 1;
            if (d[i] != 1)
                System.out.print(i + "\n");
        }
    }
}