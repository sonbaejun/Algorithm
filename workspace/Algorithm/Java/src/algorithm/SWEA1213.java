package algorithm;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.BufferedReader;


public class SWEA1213 {
	
	public static void main(String[] args) throws Exception {
        /**
         * 0. 입력파일 읽어들이기
         */
        System.setIn(new FileInputStream("1213_input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        // 결과를 한 번에 출력하기 위한 StringBuilder
        StringBuilder sb = new StringBuilder();
        
        for (int test_case = 1; test_case <= 10; test_case++) {
            int tcNum = Integer.parseInt(in.readLine());
            int cnt = 0;
            String searchStr = in.readLine();
            String sentence = in.readLine();
            
            char[] sentenceArr = new char[sentence.length()];
            for(int i =0; i < sentenceArr.length; i++) {
            	sentenceArr[i] = sentence.charAt(i);
            }
            
            char[] searchArr = new char[searchStr.length()];
            for(int i = 0; i < searchArr.length; i++) {
            	searchArr[i] = searchStr.charAt(i);
            }
            
            for(int i = 0; i < sentenceArr.length; i++) {
            	for(int j = 0; j < searchArr.length; j++) {
            		if(i + j < sentenceArr.length) {
            			if(searchArr[j] != sentenceArr[i+j])
                			break;
                		if(j == searchArr.length - 1) {
                			cnt++;
                		}
            		}
            	}
            }
            System.out.println("#" + tcNum + " " + cnt);
        }
        
	}
}
