package com.boj.string;

import java.util.Scanner;

/**
 * 1541.잃어버린 괄호
 * @author ashle
 *
 */
public class BOJ_S2_1541_잃어버린괄호 {
	
	private static String expression; // 식
	private static String[] subNum; // -를 기준으로 나눔
	private static String[] addNum; // subNum에서 +를 기준으로 나눔
	private static int answer = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		expression = scanner.next();
		
		subNum = expression.split("-"); // 식을 -를 기준으로 나눔
		
		for(int i = 0; i < subNum.length; i++) {
			addNum = subNum[i].split("\\+"); // subNum에서 +를 기준으로 나눔
			// 특수문자를 기준으로 split분리 할 때는 앞에 \\를 붙여주자!
			
			int smallExp = 0;
			for(int j = 0; j < addNum.length; j++) {
				smallExp += Integer.parseInt(addNum[j]); // addNum 숫자들 다 더해줌
			}
			
			if(i == 0) {
				answer += smallExp; // 첫번째 숫자는 더하고
			}else {
				answer -= smallExp; // 그 뒤의 숫자는 다 빼줌
			}
		}
		
		System.out.println(answer);
		
				
	}

}
