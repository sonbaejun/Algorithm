package algorithm.BAEKJOON.BOJ2630;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2630 {
	/* 재귀함수 : 배열 영역을 1/4씩 좁혀가는 로직(until 2 by 2) */
	private static int[] colorPaperCutting (int[][] colorPaperArray, int[] colorArray) {
	 	 // 재귀 종료조건(2 by 2)
		// 배열 전체가 하나의 색이 되는지 판별
		boolean flag = true;
		int checkingSameValue = colorPaperArray[0][0];
		for(int i = 0; i < colorPaperArray.length; i++) {
			for(int j = 0; j < colorPaperArray[i].length; j++) {
				if(!flag) break;
				if(colorPaperArray[i][j] != checkingSameValue) flag = false;
			}
		}
		// 배열 전체가 같은색이면 그걸 하나의 색으로 합쳐서 리턴
		if(flag) {
			if(colorPaperArray[0][0] == 0) colorArray[0]++;
			else colorArray[1]++;
			return colorArray;
		}
		
		// 2 by 2인데 같은 색이 아니라면 ? 이제 그냥 하나씩 세서 return
		if(colorPaperArray.length == 2) {
			for(int i = 0; i < colorPaperArray.length; i++) {
				for (int j = 0; j < colorPaperArray[i].length; j++) {
					if(colorPaperArray[i][j] == 0) colorArray[0]++;
					else colorArray[1]++;
				}
			}
			return colorArray;
		}
		
		// 하나의 색이 안된다면 ? 4등분한뒤 재귀호출
		int arrLength = colorPaperArray.length;
		int junctionPoint = arrLength / 2; // 4등분 기준점
		
		int[][] divideArray1 = new int[junctionPoint][junctionPoint];
		int[][] divideArray2 = new int[junctionPoint][junctionPoint];
		int[][] divideArray3 = new int[junctionPoint][junctionPoint];
		int[][] divideArray4 = new int[junctionPoint][junctionPoint];
		
		for (int i = 0; i < junctionPoint; i++) {
			for (int j = 0; j < junctionPoint; j++) {
				divideArray1[i][j] = colorPaperArray[i][j];
			}
		}
		for (int i = 0; i < junctionPoint; i++) {
			for (int j = junctionPoint; j < arrLength; j++) {
				divideArray2[i][j - junctionPoint] = colorPaperArray[i][j];
			}
		}
		for (int i = junctionPoint; i < arrLength; i++) {
			for (int j = 0; j < junctionPoint; j++) {
				divideArray3[i - junctionPoint][j] = colorPaperArray[i][j];
			}
		}
		for (int i = junctionPoint; i < arrLength; i++) {
			for (int j = junctionPoint; j < arrLength; j++) {
				divideArray4[i - junctionPoint][j - junctionPoint] = colorPaperArray[i][j];
			}
		}
		
		colorPaperCutting(divideArray1, colorArray);
		colorPaperCutting(divideArray2, colorArray);
		colorPaperCutting(divideArray3, colorArray);
		colorPaperCutting(divideArray4, colorArray);
				
		return colorArray;
	}

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("1204_input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 결과를 한 번에 출력하기 위한 StringBuilder
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] colorPaperArray = new int[N][N];
		for(int i = 0; i < colorPaperArray.length; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < colorPaperArray[i].length; j++) {
				colorPaperArray[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] colorArray = {0, 0};
		/* 재귀 함수 호출 */
		
		int[] answer = colorPaperCutting(colorPaperArray, colorArray);
		
		sb.append(answer[0]);
		sb.append("\n");
		sb.append(answer[1]);
		System.out.println(sb);
	}
}
