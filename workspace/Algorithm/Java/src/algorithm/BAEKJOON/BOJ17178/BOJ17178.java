package algorithm.BAEKJOON.BOJ17178;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ17178 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 결과를 한 번에 출력하기 위한 StringBuilder
		StringBuilder sb = new StringBuilder();

		int N;
		N = Integer.parseInt(in.readLine());
		String answer = "";
		String[] waiting_line = new String[N*5];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j = (i * 5); j < (i * 5 + 5); j++) {
				if(st.hasMoreTokens()) {
					waiting_line[j] = st.nextToken();
				}
			}
		}
		/* 입장 동작 Stack 생성 */
		Stack<String> entry_action_stack = new Stack();
		for(int i = (waiting_line.length - 1); i >= 0; i--) {
			entry_action_stack.push(waiting_line[i]);
		}
		/* 알파벳 정렬 이후 숫자 정렬 */
		Arrays.sort(waiting_line, new MixedStringComparator());	
		/* 입장 순서 Stack 생성 */
		Stack<String> entry_order_stack = new Stack();
		for(int i = (waiting_line.length - 1); i >= 0; i--) {
			entry_order_stack.push(waiting_line[i]);
		}
		/* 대기열 Stack 생성 */
		Stack<String> waiting_line_stack = new Stack();
		/* 줄 서 있는 순서대로 입장하거나 대기열로 빠지거나 */
		while(!entry_action_stack.isEmpty()) {
			boolean a = true;
			int cnt = 0;
			String action = entry_action_stack.pop();
			if (!entry_order_stack.isEmpty() && action.equals(entry_order_stack.peek())) {
				entry_order_stack.pop();
				cnt++;
			}
			while(a) {
				if(!waiting_line_stack.isEmpty() && !entry_order_stack.isEmpty() && waiting_line_stack.peek().equals(entry_order_stack.peek())) {
					entry_order_stack.pop();
					waiting_line_stack.pop();
					cnt++;
				} else {
					a = false;
				}
			}
			if (cnt == 0) {
				waiting_line_stack.push(action);
			}
		}
		/*대기열 비면 성공, 차 있으면 실패 아입니꺼*/
		if(waiting_line_stack.isEmpty()) {
			answer = "GOOD";
		} else {
			answer = "BAD";
		}

		sb.append(answer);
		System.out.println(sb);
	}
}

class MixedStringComparator implements Comparator<String> {

	@Override
    public int compare(String s1, String s2) {
        // 알파벳으로 비교
        int alphabetComparison = extractAlphabet(s1).compareTo(extractAlphabet(s2));
        
        // 알파벳이 같으면 숫자로 비교
        if (alphabetComparison == 0) {
            return extractNumber(s1) - extractNumber(s2);
        }
        
        return alphabetComparison;
    }

    // 문자열에서 알파벳 부분 추출
    private String extractAlphabet(String s) {
        return s.replaceAll("[^a-zA-Z]", "");
    }

    // 문자열에서 숫자 부분 추출
    private int extractNumber(String s) {
        String number = s.replaceAll("[^0-9]", "");
        return number.isEmpty() ? 0 : Integer.parseInt(number);
    }
}