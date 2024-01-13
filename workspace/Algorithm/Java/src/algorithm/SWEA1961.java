package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA1961 {
    
    public static void main(String[] args) throws Exception {
        
        /**
         * 0. 입력파일 읽어들이기
         */
        // System.setIn(new FileInputStream("C:\\Users\\BAEJUN\\git\\Algorithm\\baekjoon\\silver\\silver4\\input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        // 결과를 한 번에 출력하기 위한 StringBuilder
        StringBuilder sb = new StringBuilder();
        
        int T;
        T = Integer.parseInt(in.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
        	sb.append("#" + test_case + "\n");
			StringTokenizer st = new StringTokenizer(in.readLine());
        	int N = Integer.parseInt(st.nextToken());
        	int[][] arr = new int[N][N];
        	/* 2차원 배열에 인풋 값 초기화 */
        	for(int i = 0; i < N; i++) {
        		st = new StringTokenizer(in.readLine());
        		for(int j = 0; j < N; j++) {
        			arr[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	int rotate90 = 0;
        	int rotate180 = N - 1;
        	int rotate270 = N - 1;
        	/* 90, 180, 270도 회전 로직 */
        	for(int i = 0; i < N; i++) {
        		for(int j = N - 1; j >= 0; j--) {
        			sb.append(arr[j][rotate90]);
        		}
        		sb.append(" ");
        		rotate90++;
        		for(int j = N - 1; j >= 0; j--) {
        			sb.append(arr[rotate180][j]);
        		}
        		sb.append(" ");
        		rotate180--;
        		for(int j = 0; j < N; j++) {
        			sb.append(arr[j][rotate270]);
        		}
        		sb.append(" ");
        		rotate270--;
        		sb.append("\n");
        	}
        	
        }
        
        System.out.println(sb);
    }
}