package com.boj.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 문자열
 * 
 * @author ashle
 *
 */
public class BOJ_S4_1120_문자열 {

	private static String A = "";
	private static String B = "";
	private static int cnt = 0; // 둘의 차이
	private static int min = Integer.MAX_VALUE; // 둘의 차이의 최솟값

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		A = scanner.next();
		B = scanner.next();
		// 입력 완료!
		
		scanner.close();

		List<Character> listA = new ArrayList<>(); // A를 한글자씩 리스트에 넣기
		for (int i = 0; i < A.length(); i++) {
			listA.add(A.charAt(i));
		}
		List<Character> listB = new ArrayList<>(); // B를 한글자씩 리스트에 넣기
		for (int i = 0; i < B.length(); i++) {
			listB.add(B.charAt(i));
		}

		if (A.length() < B.length()) { // A의 길이가 B의 길이보다 작으면
			for (int i = listA.size(); i < listB.size(); i++) { 
				listA.add(i, null); // B의 길이가 될 때까지 null을 넣어줌
			}
		}

		for (int j = A.length() - 1; j <= listA.size() - 1; j++) {
			cnt = 0;

			for (int i = 0; i < listB.size(); i++) {
				if (listA.get(i) != null && listA.get(i) != listB.get(i)) {
					cnt += 1; // listA의 값이 null이 아니면서 listA와 listB의 값이 다를 때 차이값 올라감
				}
			}

			if (cnt < min)
				min = cnt; // min에 cnt의 최솟값 넣기!
		
			if (listA.get(listA.size() - 1) == null) {
				listA.add(0, null);
				listA.remove(listA.size() - 1);
			} // listA의 마지막값이 null이 아닐 때까지 listA 값들을 한칸씩 옮긴다(?)
		}
		// 출력
		System.out.println(min);
	}

}
