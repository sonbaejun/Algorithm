package com.ssafy.startcamp.forwhile;

public class Label {
	/*
	 * 평상 시, label 사용은 권장하지 않음.
	 * 알고리즘 문제를 풀 때는 사용하면 유용함. (가지치기)
	 */
	public static void main(String[] args) {
		a:
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (j >= 5) {
						continue a;
					}
					System.out.println(i + " " + j);
				}
				System.out.println("for(j) end");
			}
	
		System.out.println("end of 'a' label");

		b:
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (j >= 5) {
						break b;
					}
					System.out.println(i + " " + j);
				}
			}
		
		System.out.println("end of 'b' label");
	}
}