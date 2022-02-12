package com.boj.string;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 1213.팰린드롬 만들기
 * 
 * @author ashle
 *
 */
public class BOJ_S4_1213_팰린드롬만들기 {
	
	private static String name; // 영어 이름
	private static String[] palin; // 최종 팰린드롬
	private static String alpha = ""; // 
	private static String alphaSet = "";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		name = scanner.next();

		palin = new String[3];

		char[] nameArr = name.toCharArray();
		Arrays.sort(nameArr); // 영어이름을 알파벳순으로 정렬
		

		int position = 0;
		for (int i = 0; i < nameArr.length; i++) {
			if (i == nameArr.length-1) {
				alpha = new String(Arrays.copyOfRange(nameArr, position, i+1));
//				System.out.println("alpha : " + alpha);
				if(alpha.length() == 1) {
					palin[1] = alpha;
				}else if(alpha.length() % 2 == 0) {
					alphaSet += alpha.substring(0, alpha.length()/2);
				}else {
					alphaSet += alpha.substring(0, alpha.length()/2);
					palin[1] = alpha.substring(alpha.length()-1);
				}
				break;
			}
			if (nameArr[i] != nameArr[i + 1]) {
				alpha = new String(Arrays.copyOfRange(nameArr, position, i+1));
//				System.out.println("alpha : " + alpha);
				if(alpha.length() == 1) {
					palin[1] = alpha;
				}else if(alpha.length() % 2 == 0) {
					alphaSet += alpha.substring(0, alpha.length()/2);
				}else {
					alphaSet += alpha.substring(0, alpha.length()/2);
					palin[1] = alpha.substring(alpha.length()-1);
				}
				position = i + 1; 
			}
		}
		
//		System.out.println("alphaSet: " + alphaSet);
		
		StringBuffer alphaSetRev = new StringBuffer(alphaSet);
		palin[0] = alphaSet;
		if(palin[1] == null) {
			palin[1] = "";
		}
		palin[2] = alphaSetRev.reverse().toString();
		
		String answer = palin[0] + palin[1] + palin[2];
		if(alphaSet.length() == 0 || answer.length() != name.length()) {
			System.out.println("I'm Sorry Hansoo");
		}else {
			System.out.println(answer);
		}
		
	}


}
