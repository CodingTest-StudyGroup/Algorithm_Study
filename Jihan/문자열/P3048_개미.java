package com.ssafy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class P3048_개미 {

	public static void main(String[] args){

		Scanner scan = new Scanner(System.in);
		int N1 = scan.nextInt();
		int N2 = scan.nextInt();
		
		List<Character> tempList = new ArrayList<Character>();
		List<Character> ant = new ArrayList<Character>();
		Map<Character, Integer> group = new HashMap<Character, Integer>();
	
		String s1 = scan.next();
		String s2 = scan.next();
		
		int T = scan.nextInt();
		scan.close();
		
		for (Character c : s1.toCharArray()) { //1그룹 입력
			tempList.add(c);
			group.put(c, 1);
		}
		for(int i=tempList.size()-1; i>=0; i--) { // 1그룹 뒤집기
			ant.add(tempList.get(i));
		}
		
		for (Character c : s2.toCharArray()) { //2그룹 입력
			ant.add(c);
			group.put(c, 2);
		}
		
		char temp = ' ';
		
		for(int t=0; t<T; t++) {// T초 후
			for(int i=0; i<ant.size()-1; i++) {
				if(group.get(ant.get(i))==1 && group.get(ant.get(i+1))==2) { 
					// 1그룹의 개미이고 오른쪽이 2그룹일때
					temp = ant.get(i);
					ant.set(i, ant.get(i+1));
					ant.set(i+1, temp);
					i++;
				}
				
			}
		}
		
		for (Character character : ant) {
			System.out.print(character);
		}
		
	}// main

}
