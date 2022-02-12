package com.boj.implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2621.카드게임
 * @author ashle
 *
 */
public class BOJ_S4_2621_카드게임 {

	private static int score = 0;
	private static char[] color = new char[5];
	private static int[] num = new int[5];
	private static boolean straightNum = false;
	private static boolean sameColor = false;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		for (int i = 0; i < 5; i++) {
			color[i] = scanner.next().charAt(0);
			num[i] = scanner.nextInt();
		}

		Arrays.sort(color);
		Arrays.sort(num);

		if (num[0] == num[1] - 1 && num[0] == num[2] - 2 && num[0] == num[3] - 3 && num[0] == num[4] - 4)
			straightNum = true; // 모든 숫자가 연속적일 때
		if (color[0] == color[4])
			sameColor = true; // 모두 같은 색일 때

		if (straightNum && sameColor) { // 모두 같은 색이면서 숫자가 연속적일 때
			score = num[4] + 900; // 가장 높은 숫자에 900을 더함
		} else if (num[0] == num[3] || num[1] == num[4]) { // 5장 중 4장의 숫자가 같을 때
			score = num[3] + 800; // 같은 숫자에 800을 더함
		} else if (num[0] == num[2] && num[3] == num[4] || num[0] == num[1] && num[2] == num[4]) { // 5장 중 3장의 숫자가 같고 나머지 2장도 숫자가 같을 때
			score = num[0] + num[4] + 9 * num[2] + 700; // 3장이 같은 숫자에 10을 곱하고 2장이 같은 숫자를 더한 다음 700을 더함
			// num[2]는 무조건 한 번 끼워져있기 때문에 9번만 곱하고 3장이 같은 숫자, 2장이 같은 숫자 한번씩 더한다!
		} else if (sameColor) { // 카드 색이 모두 같을 때
			score = num[4] + 600; // 가장 높은 숫자에 600을 더함
		} else if (straightNum) { // 숫자가 연속적일 때
			score = num[4] + 500; // 가장 높은 숫자에 500을 더함
		} else if (num[0] == num[2] || num[1] == num[3] || num[2] == num[4]) { // 5장 중 3장의 숫자가 같을 때
			score = num[2] + 400; // 3장이 같은 숫자에 400을 더함
		} else if (num[0] == num[1]) { 
			if (num[2] == num[3] || num[3] == num[4]) { // 5장 중 2장의 숫자가 같고 또 다른 2장의 숫자가 같을 때 (num[0]과 num[1]가 같은 버전)
				score = 300 + num[3] * 10 + num[0]; // 같은 숫자 중 큰 숫자에 10을 곱하고 같은 숫자 중 작은 숫자를 더한 다음 300을 더함
			} else { // 5장 중 2장의 숫자가 같을 때
				score = num[0] + 200; // 같은 숫자에 200을 더함
			}
		} else if (num[1] == num[2]) { 
			if (num[3] == num[4]) { // 5장 중 2장의 숫자가 같고 또 다른 2장의 숫자가 같을 때 (num[1]과 num[2]가 같은 버전)
				score = 300 + num[3] * 10 + num[1];
			} else {
				score = num[1] + 200;
			}
		} else if (num[2] == num[3] || num[3] == num[4]) { // 5장 중 2장의 숫자가 같을 때
			score = num[3] + 200; // 같은 숫자에 200을 더함
		} else { // 위의 어떤 경우에도 해당하지 않을 때
			score = num[4] + 100; // 가장 큰 숫자에 100을 더함
		}
		System.out.print(score);

	}

}