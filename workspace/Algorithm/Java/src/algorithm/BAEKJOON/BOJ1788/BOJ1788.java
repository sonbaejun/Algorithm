package algorithm.BAEKJOON.BOJ1788;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1788 {

	public static void main(String[] args) throws Exception {
        
        /**
         * 0. 입력파일 읽어들이기
         */
        // System.setIn(new FileInputStream("1204_input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        // 결과를 한 번에 출력하기 위한 StringBuilder
        StringBuilder sb = new StringBuilder();
        
        int n;
        n = Integer.parseInt(in.readLine());
        
        long[] fibonacci = new long[1000002];
        fibonacci[0] = 0L;
        fibonacci[1] = 1L;
        int nAbs = Math.abs(n);
        /* n이 양인지 음인지 0인지 보고 append*/
        if(n > 0) {
        	for(int i = 2; i <= n; i++)
        		fibonacci[i] = (fibonacci[i-1] + fibonacci[i-2]) % 1000000000;
        } else if(n < 0) {
        	/* index 2부터 음수 시작 (index 2 = -1번 값)*/
        	fibonacci[2] = fibonacci[1] - fibonacci[0];
        	fibonacci[3] = fibonacci[0] - fibonacci[2];
        	
        	for(int i = 4; i <= (nAbs + 1); i++) {
        		if(fibonacci[i-1] > 0) {
        			fibonacci[i] = (fibonacci[i-2] - fibonacci[i-1]) % 1000000000;
        		} else {
        			long fiboAbs = Math.abs(fibonacci[i-1]);
        			fibonacci[i] = (fibonacci[i-2] + fiboAbs) % 1000000000;
        		}
        	}
        }
        /* 출력 형식 맞춰서 출력 */
        if(nAbs == 0 || nAbs == 1) {
        	if(nAbs == 0) {
        		sb.append(0);
	        	sb.append("\n");
	        	sb.append(0);
        	} else {
        		sb.append(1);
	        	sb.append("\n");
	        	sb.append(1);
        	}
        } else {
        	if (fibonacci[nAbs] > 0 && n > 0) {
        		sb.append(1);
	        	sb.append("\n");
	        	long reslutAbs = Math.abs(fibonacci[nAbs]) % 1000000000;
	        	sb.append(reslutAbs);
        	} else if (fibonacci[nAbs + 1] > 0 && n < 0) {
        		sb.append(1);
        		sb.append("\n");
	        	long reslutAbs = Math.abs(fibonacci[nAbs + 1]) % 1000000000;
	        	sb.append(reslutAbs);
        	} else if (fibonacci[nAbs + 1] < 0 && n < 0) {
        		sb.append(-1);
	        	sb.append("\n");
	        	long reslutAbs = Math.abs(fibonacci[nAbs + 1]) % 1000000000;
	        	sb.append(reslutAbs);
        	} else if (fibonacci[nAbs + 1] == 0 && n < 0) {
        		sb.append(0);
	        	sb.append("\n");
	        	sb.append(0);
        	}
        }
        
        System.out.println(sb);
    }

}
