package com.boj.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * 1431.시리얼 번호
 * 
 * @author ashle
 *
 */
public class BOJ_S3_1431_시리얼번호 {

	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	private static int N; // 기타의 개수
	private static List<String> serial = new ArrayList<>(); // 기타 시리얼번호 리스트

	public static void main(String[] args) throws NumberFormatException, IOException {

		N = Integer.parseInt(input.readLine());

		for (int i = 0; i < N; i++) {
			serial.add(i, input.readLine().toString());
		}

		Collections.sort(serial, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int o1Sum = 0;
				int o2Sum = 0;
				
				for(int i = 0; i < o1.length(); i++) {
					if(Character.isDigit(o1.charAt(i))){ // 숫자인 것만 더함
						o1Sum += (o1.charAt(i) - '0'); 
					}
				} // o1 모든 자리수의 합 구하기
				
				for(int i = 0; i < o2.length(); i++) {
					if(Character.isDigit(o2.charAt(i))){
						o2Sum += (o2.charAt(i) - '0'); 
					}
				} // o2 모든 자리수의 합 구하기
					
				
				if(o1.length() > o2.length()) {
					return 1;
				}else if(o1.length() < o2.length()){
					return -1; // 길이가 다르면 짧은 것이 먼저 온다.
				}else {
					if(o1Sum > o2Sum) {
						return 1;
					}else if(o1Sum < o2Sum) {
						return -1; // o1 모든 자리수의 합, o2 모든 자리수의 합 중 작은 합을 가지는 것이 먼저 온다.
					}else {
						return o1.compareTo(o2); // 사전순 비교
					}
				}
	
			}

		});
		
		for(String s: serial) {
			System.out.println(s);
		}

	}

}
