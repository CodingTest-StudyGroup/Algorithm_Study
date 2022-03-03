package com.ssafy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.Set;

public class P1213_펠린드롬만들기 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		
		Map<Character, Integer> countMap = new HashMap<Character, Integer>();
		
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			
			if(countMap.containsKey(c)) { // 이미 있는 단어
				countMap.put(c, countMap.get(c) + 1);
			}else { // 없는 단어
				countMap.put(c, 1);
			}
		}
		
		Set<Character> keys = countMap.keySet(); //key모음
		List<Character> keyList = new ArrayList<Character>(keys);
		Collections.sort(keyList); //key모음 정렬
		
		List<Character> copy = new ArrayList<Character>();
		
		int oddCnt = 0;
		
		for (Character key : keys) {
			if(countMap.get(key)%2 == 1) { //홀수일 경우 cnt 증가
				oddCnt++;
			}
		}
		char mid = ' '; //가운데 문자 인덱스

		for(char k : keyList) { //copy에 앞부분 저장
			int n = countMap.get(k) / 2;
			
			for(int j=0; j<n; j++) { //앞부분 출력
				copy.add(k);
			}
			if(countMap.get(k)%2 == 1) {
				mid = k;
			}
		}
		
		if(oddCnt > 1) {
			System.out.println("I'm Sorry Hansoo");
		}else {
			for (Character c : copy) {//copy 출력
				System.out.print(c);
			}
			if(oddCnt==1) { //가운데 문자 존재할때만 출력
				System.out.print(mid);
			}
			for(int i=copy.size() - 1; i>=0; i--) {// copy 뒤집어서 출력
				System.out.print(copy.get(i));
			}
		}
		
		
	}// main

}
