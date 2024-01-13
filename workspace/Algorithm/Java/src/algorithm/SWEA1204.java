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

public class SWEA1204 {
    
    public static void main(String[] args) throws Exception {
        
        /**
         * 0. 입력파일 읽어들이기
         */
        System.setIn(new FileInputStream("1204_input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        // 결과를 한 번에 출력하기 위한 StringBuilder
        StringBuilder sb = new StringBuilder();
        
        int T;
        T = Integer.parseInt(in.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
        	int answer = 1;
        	sb.append("#" + test_case + " ");
        	int[][] arr = new int[9][9];
        	/* 2차원 배열에 인풋 값 초기화 */
        	for(int i = 0; i < arr.length; i++) {
        		StringTokenizer st = new StringTokenizer(in.readLine());
        		for(int j = 0; j < arr.length; j++) {
        			arr[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	/* 가로 줄 검증 */
        	int row = 0;
        	for(int k = 0; k < arr.length; k++) {
        		if(answer == 0) break;
        		int[] check = new int[10];
        		for(int i = 0; i < arr.length; i++) {
            		check[arr[k][i]]++;
            		if(check[arr[k][i]] > 1) {
            			answer = 0;
            			break;
            		}
            	}
        	}
        	
        	/* 세로 줄 검증*/
        	if(answer != 0) {
        		row = 0;
            	for(int k = 0; k < arr.length; k++) {
            		if(answer == 0) break;
            		int[] check = new int[10];
            		for(int i = 0; i < arr.length; i++) {
                		check[arr[i][k]]++;
                		if(check[arr[i][k]] > 1) {
                			answer = 0;
                			break;
                		}
                	}
            	}
        	}
        	
        	/* 대각 3*3 검증 */
        	if(answer != 0) {
        		row = 0;
                int col = 0;
        		
                while(col < 9) {
                    int[] check3 = new int[10];
                    if(answer == 0) break;
                    for(int k = col; k < (col+3); k++) {
                        for(int i = row; i < (row + 3); i++) {
                            check3[arr[k][i]]++;
                        }
                    }
                    for(int i = 1; i < check3.length; i++) {
                        if (check3[i] != 1) {
                            answer = 0;
                            break;
                        }
        			}
                    row +=3;
                    col += 3;
                }
        	}
        	sb.append(answer + "\n");
        }
        System.out.println(sb);
    }
}