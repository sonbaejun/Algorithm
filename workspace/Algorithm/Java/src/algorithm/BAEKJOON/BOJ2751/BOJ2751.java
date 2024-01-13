package algorithm.BAEKJOON.BOJ2751;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2751 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		/**
         * 0. 입력파일 읽어들이기
         */
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        // 결과를 한 번에 출력하기 위한 StringBuilder
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(in.readLine());
        int[] arr = new int[T];
        
        for(int i = 0; i < T; i++) {
        	arr[i] = Integer.parseInt(in.readLine());
        }
        
        Arrays.sort(arr);
        		
        for (int i = 0; i < arr.length; i++)
            sb.append(arr[i] + "\n");            
        
        
        System.out.println(sb);
	}

}
