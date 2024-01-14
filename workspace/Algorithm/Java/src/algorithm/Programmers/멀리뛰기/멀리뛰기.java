package algorithm.Programmers.멀리뛰기;

public class 멀리뛰기 {
	/* 출력을 위한 main문 */
	public static void main(String[] args) {
        System.out.println(solution(5));
	}
    public static long solution(int n) {
        /* 점화식 => d[n] = d[n-1] + d[n-2] ==> 피보나치 */
        /* 문제 핵심은 범위 초과를 어떻게 다루냐 ==> 모듈러 연산의 분배법칙 사용 */
        /* (A + B) % C ≡ ( ( A % C ) + ( B % C) ) % C를 이용해 오버플로우를 막음 */
        
        long answer = 0;
        long[] fibonacci = new long[n+2];
        
        for(int i = 0; i < fibonacci.length; i++) {
            if(i < 2) {
                fibonacci[i] = i;
            } else {
                fibonacci[i] = (fibonacci[i-2] + fibonacci[i-1]) % 1234567; // 큰 수를 다루기 위한 모듈러 연산
            }
        }
        answer = fibonacci[fibonacci.length - 1];
        return answer;
    }
}