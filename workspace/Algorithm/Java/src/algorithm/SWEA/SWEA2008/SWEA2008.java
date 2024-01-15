package algorithm.SWEA.SWEA2008;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA2008 {

	public static void main(String[] args) throws Exception {
    	
        /**
         * 0. 입력파일 읽어들이기
         */
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        // 결과를 한 번에 출력하기 위한 StringBuilder
        StringBuilder sb = new StringBuilder();
        
        int T;
        T = Integer.parseInt(in.readLine());
        
        
        int[][] deltas = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}}; // 좌표값
        
        for (int test_case = 1; test_case <= T; test_case++) {
        	int max_height = 0;
        	int N = Integer.parseInt(in.readLine());
        	/* 입력값 2차원 배열에 저장 */
        	char[][] building_arr = new char[N][N];
        	for(int r = 0; r < N; r++) {
        		StringTokenizer st = new StringTokenizer(in.readLine());
        		for(int c = 0; c < N; c++) {
        			building_arr[r][c] = st.nextToken().charAt(0);
        		}
        	}
        	/* 완전 탐색 돌면서 층 수 max값 구하기 */
        	for(int r = 0; r < N; r++) {
        		for(int c = 0; c < N; c++) {
        			int height_current = 0;
        			boolean check_contact = true;
        			/* G인 경우 계속 진행 */
        			if(building_arr[r][c] == 'G') {
        				continue;
        			} else {
        				/* B인경우 8각에 G가 하나라도 있으면 높이는 2 */
        				for(int d = 0; d < 8; d++) {
        					int nr = r + deltas[d][0];
        					int nc = c + deltas[d][1];
        					if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
        						if (building_arr[nr][nc] == 'G') {
        							height_current = 2;
        							check_contact = false;
        							break;
        						}
        					}
        					/* 8각 모두 B인 경우 B 갯수만큼 높이 설정 */
        					if(check_contact && d == 7) {
        						for(int i = 0; i < N; i++) {
            						if (building_arr[r][i] == 'B') height_current++;
            						if (building_arr[i][c] == 'B') height_current++;
        						}
        					}
        				}
        			}
        			if(max_height < height_current) max_height = height_current - 1; // 중복(자기 자신 제거)
        		}
        	}
            sb.append("#" + test_case + " ");
            sb.append(max_height);
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
}
