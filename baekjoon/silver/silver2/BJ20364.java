package silver2;
/// baekjoon 20364번 부동산 다툼 (실버2)

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ20364 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Integer> own = new HashSet<Integer>();
        int cur;
        int possession = 0;
        int search;

        int N = Integer.parseInt(st.nextToken()); /* 땅 개수 */
        int Q = Integer.parseInt(st.nextToken()); /* 오리 수*/

        for (int i = 0; i < Q; i++) {
            cur = Integer.parseInt(br.readLine());
            search = cur;
            while (search > 1) {
                /* 현재 값이 점유된 땅이라면 possession을 갱신 */
                if (own.contains(search)) {
                    possession = search;
                    /* cnt변수를 통해 점유된 땅이 만났었는지를 체크했는데 시간을 굉장히 잡아먹어서 possession의 값이 0인지 아닌지로 체크 방법 변경 */
                }
                /* 부모노드로 이동 */
                search = search / 2;
            }
            if (possession == 0) {
                /* 가는 길에 점유된 땅이 없었다면 목적지를 점유하고 0을 출력! */
                own.add(cur);
                bw.write(String.valueOf("0\n"));
            } else {
                /* 점유된 땅을 만났었다면 possession의 최솟값을 출력! */
                bw.write(String.valueOf(possession + "\n"));
                possession = 0;
            }
        }
        bw.close();
    }
}