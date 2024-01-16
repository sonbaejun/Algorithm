package algorithm.BAEKJOON.BOJ2841;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2841 {

	public static void main(String[] args) throws Exception {
		// 각 줄 개수 만큼 stack을 생성해서
		// 최소 손가락 움직임 == 같은 줄일땐 가능한한 손을 안 움직여야됨
		// 그니까 줄 당 stack인데, 높은 음 없으면? 그냥 치고, 높은 음 있으면? 걔네 다 쳐내고 치고
		
		// System.setIn(new FileInputStream("1204_input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        // 결과를 한 번에 출력하기 위한 StringBuilder
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(in.readLine());
		int count_fingertip = 0; // 손가락 튕긴 횟수
        int sound_count = Integer.parseInt(st.nextToken());
        int fret_count = Integer.parseInt(st.nextToken());
//      boolean[][] pressed_guitar = new boolean[sound_count][fret_count];
        Stack<Integer>[] stackInt = new Stack[7];
        for (int i = 0; i <= 6; i++)
			stackInt[i] = new Stack<>();
        
        /* 풀이 1 : 2차원 배열 사용 -> 정답은 나오지만 시간복잡도 초 */
//        for (int i = 0; i < sound_count; i++) {
//        	  st = new StringTokenizer(in.readLine());
//            int sound = Integer.parseInt(st.nextToken());
//            int fret = Integer.parseInt(st.nextToken());
//            if(pressed_guitar[sound][fret]) continue;
//            for(int j = fret_count - 1 - 1; j > fret; j--) {
//            	if (pressed_guitar[sound][j]) {
//            		pressed_guitar[sound][j] = false;
//            		count_fingertip++;
//            	}
//            }
//            pressed_guitar[sound][fret] = true;
//            count_fingertip++;
//        }
        
        /* 풀이 2 : 줄 개수(6개)만큼 스택을 만들어서 품 */
        for (int i = 0; i < sound_count; i++) {
        	st = new StringTokenizer(in.readLine());
        	int sound = Integer.parseInt(st.nextToken());
        	int fret = Integer.parseInt(st.nextToken());
        	boolean is_checked_duplicated = true;
        	/* 더 높은 음 다 지우는 반복문 */
        	while(!stackInt[sound].isEmpty() && stackInt[sound].peek() >= fret) {
        		if(stackInt[sound].peek() == fret) {
        			is_checked_duplicated = false;
        			break;
        		}
        		stackInt[sound].pop();
        		count_fingertip++;
        	}
        	if(is_checked_duplicated) {
        		stackInt[sound].push(fret);
        		count_fingertip++;
        	}
        }
        
        sb.append(count_fingertip);
        System.out.println(sb);
	}

}
