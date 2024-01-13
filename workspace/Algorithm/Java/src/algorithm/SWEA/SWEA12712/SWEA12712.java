package algorithm.SWEA.SWEA12712;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;

public class SWEA12712
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
            int [][] flyArr = new int[N][N];
            int max = 0;
            /* 2차원 배열 입력 */
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    flyArr[i][j] = sc.nextInt();
                }
            }
            /* 각 배열을 순회하면서 위아래양옆 M칸씩 +모양 하나 x모양 하나 값 */
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    int idxValue = flyArr[i][j];
                    /* 파리  퇴치하는 로직 +모양 */
                    for(int q = 1; q < M; q++) {
                    	if(i - q >= 0) idxValue += flyArr[i-q][j];
                        if(i + q < N) idxValue += flyArr[i+q][j];
                        if(j - q >= 0) idxValue += flyArr[i][j-q];
                        if(j + q < N) idxValue += flyArr[i][j+q];
                    }
                    if(idxValue > max) max = idxValue;
                    /* 파리 퇴치하는 로직 x모양 */
                    idxValue = flyArr[i][j];
                    for(int q = 1; q < M; q++) {
                        if(i - q >= 0 && j - q >= 0) idxValue += flyArr[i-q][j-q];
                        if(i - q >= 0 && j + q < N) idxValue += flyArr[i-q][j+q];
                        if(i + q < N && j - q >= 0) idxValue += flyArr[i+q][j-q];
                        if(i + q < N && j + q < N) idxValue += flyArr[i+q][j+q];
                    }
                    if(idxValue > max) max = idxValue;
                }
            }
            System.out.printf("#%d %d" ,test_case, max);
            System.out.println();
		}
	}
}
