package algorithm;

import java.util.Scanner;
import java.io.FileInputStream;

public class SWEA1959
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] Aarr = new int[N];
            int[] Barr = new int[M];
            for(int i = 0; i < Aarr.length; i++) {
                Aarr[i] = sc.nextInt();
            }
            for(int i = 0; i < Barr.length; i++) {
                Barr[i] = sc.nextInt();
            }
            int trial = (Aarr.length > Barr.length) ? Aarr.length - Barr.length : Barr.length - Aarr.length;
            int max = 0;
            /* 구할 수 있는 모든 최대값 구하기 */
            for(int i = 0; i <= trial; i++) {
				int k = 0;
                if ( Aarr.length > Barr.length) {
                    for(int j = 0; j < Barr.length; j++) {
                        k += Barr[j] * Aarr[i + j];
                	}
                } else {
                    for(int j = 0; j < Aarr.length; j++) {
                        k += Aarr[j] * Barr[i + j];
                    }
                }
                if (k > max) max = k;
            }
            System.out.printf("#%d %d", test_case, max);
            System.out.println();
        }
	}
}