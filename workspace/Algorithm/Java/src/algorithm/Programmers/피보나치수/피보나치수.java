package algorithm.Programmers.피보나치수;

public class 피보나치수 {

	/* 출력을 위한 main문 */
	public static void main(String[] args) {
		System.out.println(solution(2000));
	}
	
    public static long solution(int n) {
        long answer = 0;
        long[] fibonacci = new long[n+1];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        
        for(int i = 2; i < fibonacci.length; i++) {
            fibonacci[i] = (fibonacci[i-1] + fibonacci[i-2]) % 1234567;
        }
        answer = fibonacci[fibonacci.length - 1];
        return answer;
    }

}
