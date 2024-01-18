package algorithm.BAEKJOON.BOJ1074;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ1074 {
	/* 재귀함수 : 배열 영역을 1/4씩 좁혀가는 로직(until 2 by 2) */
	private static int zDetect (int[] input) {
		//재귀 종료조건(2 by 2)
		if(input[0] == 2) {
			int[] returnValueArray= {input[3], input[3] + 1, input[3] + 2, input[3] + 3};
			if(input[1] == 0 && input[2] == 0) {
				return returnValueArray[0];
			} else if (input[1] == 0 && input[2] == 1) {
				return returnValueArray[1];
			} else if (input[1] == 1 && input[2] == 0) {
				return returnValueArray[2];
			} else if (input[1] == 1 && input[2] == 1) {
				return returnValueArray[3];
			}
		}
		int N = input[0];
		int r = input[1];
		int c = input[2];
		int junctionPoint = N / 2;
		int zArrayIndexRange = N * N / 4;
		int startPoint = input[3];
		/* 영역을 4등분하여 그 중에 어디에 속하는지 구하기 */
		if(r < junctionPoint && c < junctionPoint) {} 
		else if (r < junctionPoint && c >= junctionPoint) {
			c = c - junctionPoint;
			startPoint += zArrayIndexRange;
		} else if (r >= junctionPoint && c < junctionPoint) {
			r = r - junctionPoint;
			startPoint += (zArrayIndexRange * 2);
		} else if (r >= junctionPoint && c >= junctionPoint) {
			c = c - junctionPoint;
			r = r - junctionPoint;
			startPoint += (zArrayIndexRange * 3);
		}
		/* 재귀 파라미터 수정 */
		input[0] = junctionPoint;
		input[1] = r;
		input[2] = c;
		input[3] = startPoint;
		return zDetect(input);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 결과를 한 번에 출력하기 위한 StringBuilder
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		/* 2^n * 2^n 배열 생성 */
		int zArrayRange = 2;
		for(int i = 0; i < N - 1; i++) {
			zArrayRange *= 2;
		}
		
		/* 재귀 함수 호출 */
		int[] inputArray = {zArrayRange, r, c, 0};
		int k = zDetect(inputArray);
		sb.append(k);
		System.out.println(sb);
	}
}