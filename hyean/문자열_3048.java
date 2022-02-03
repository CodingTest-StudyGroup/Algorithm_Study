package com.boj.string;

/**
 * 3048.개미
 * 런타임에러(배열 범위 벗어난 듯)
 * @author ashle
 *
 */
import java.util.Scanner;

public class 문자열_3048 {
	
	private static int N1; // 첫번째 그룹의 개미의 수
	private static int N2; // 두번째 그룹의 개미의 수
	private static String antsOne = ""; // 첫번째 그룹 개미의 순서
	private static String antsTwo = ""; // 두번째 그룹 개미의 순서
	private static int T; // 몇 초가 지났는지
	private static String antsAll = ""; // 개미 그룹들이 처음 만날 때
	private static String[] arrayAll;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N1 = scanner.nextInt(); 
		N2 = scanner.nextInt(); 
		antsOne = scanner.next(); 
		antsTwo = scanner.next(); 
		T = scanner.nextInt(); 
		// 입력 완료!
		
		StringBuffer sb = new StringBuffer(antsOne);
		String antsOneRev = sb.reverse().toString(); // 첫번째 그룹은 왼쪽에서 오른쪽으로 움직이니까 뒤집자
		
		antsAll = antsOneRev + antsTwo;
		
		arrayAll = new String[N1 + N2];
		arrayAll = antsAll.split("");
//		for(int i = 0; i < arrayAll.length; i++) {
//			System.out.println(arrayAll[i]);
//		}

		for(int i = 1; i <= T; i++) {		
			for(int j = 0; j < arrayAll.length-1; j++) {
				if(antsOne.contains(arrayAll[j]) && antsTwo.contains(arrayAll[j+1])) { // 현재 인덱스에 첫번째 그룹의 개미가 있고 그 뒤 인덱스에 두번째 그룹의 개미가 있을 때
					String temp = "";
					temp = arrayAll[j];
					arrayAll[j] = arrayAll[j+1];
					arrayAll[j+1] = temp; // 위치 바꾸기
					j++; // 바꾼 인덱스 건너뛰기
				}
//				for(int k = 0; k < arrayAll.length; k++) {
//					System.out.print(arrayAll[k]);
//				}
			}		
		}

		for(int i = 0; i < arrayAll.length; i++) {
			System.out.print(arrayAll[i]);
		}
				
	}
}
