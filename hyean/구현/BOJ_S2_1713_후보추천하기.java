package com.boj.implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 1713.후보 추천하기
 * @author ashle
 *
 */
public class BOJ_S2_1713_후보추천하기 {

	private static int N; // 사진틀의 개수
	private static int total; // 전체 학생의 총 추천 횟수
	private static int stdNum; // 추천받은 학생 번호
	private static List<Student> recommend; // 추천받은 학생 리스트

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		N = scanner.nextInt(); 
		total = scanner.nextInt();
		recommend = new ArrayList<>();
		
		for (int i = 0; i < total; i++) {
			stdNum = scanner.nextInt(); //입력 완료!
			boolean picture = false;
			
			for(int j = 0; j < recommend.size(); j++) {
				if(recommend.get(j).num == stdNum) { // 이미 다른 학생의 추천 받은 경우
					recommend.get(j).cnt ++; // 추천받은 횟수만 증가시킴
					picture = true;
					break;
				}
			}
			
			if(!picture) {
				if(recommend.size() >= N) { // 사진틀 개수보다 추천받은 학생이 더 많을 경우
					Collections.sort(recommend); // 추천받은 횟수가 가장 적은 학생부터 정렬
					recommend.remove(0); // 게시된 지 가장 오래된 사진 삭제
				}
				recommend.add(new Student(stdNum, i, 1));
			}
		}
		
		List<Integer> list = new ArrayList<>(); // 사진틀 리스트
		for(Student s : recommend) {
			list.add(s.num);
		}
		
		// 출력!
		Collections.sort(list);
		for(int n:list) {
			System.out.print(n + " ");
		}
	}
	
	public static class Student implements Comparable<Student>{
		int num;
		int index;
		int cnt;
		
		public Student(int num, int index, int cnt) {
			this.num = num;
			this.index = index;
			this.cnt = cnt;
		}
		
		@Override
		public int compareTo(Student o) {
			int result = this.cnt - o.cnt;
			if(result == 0)
				result = this.index - o.index;
			return result;
		}
	}

}
