package com.boj.implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 16926.배열 돌리기
 * @author ashle
 *
 */
public class BOJ_S2_16926_배열돌리기1 {

	private static int N;
	private static int M;
	private static int R; // 회전 수
	private static int[][] arr;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		N = scanner.nextInt();
		M = scanner.nextInt();
		R = scanner.nextInt();

		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = scanner.nextInt();
			}
		}		
		// 입력 완료!

		// 다차원 배열 값 문자열 출력하는 법!
//		System.out.println(Arrays.deepToString(arr));

//		for(int r = 0; r<arr.length; r++) {
//			int[] inArr = arr[r];
//			for(int c = 0; c<inArr.length; c++) {
//				System.out.print(inArr[c] + " ");
//			}
//			System.out.println();
//		}

		int num = Math.min(N, M) / 2; // 테두리를 따라 몇번 돌아야 하는지!
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };

		while (R > 0) { // 입력받은 회전 수만큼
			for (int i = 0; i < num; i++) {
				int r = i;
				int c = i;
				int temp = arr[r][c];
				int dir = 0;

				while (dir < 4) { 
					int nr = r + dx[dir];
					int nc = c + dy[dir];

					if (nr >= i && nc >= i && nr < N - i && nc < M - i) { // 더이상 갈 곳이 없으면 방향 틀기
						arr[r][c] = arr[nr][nc];
						r = nr;
						c = nc;
					} else {
						dir++;
					}
				}
				arr[r + 1][c] = temp; 
			}
			R--;
		}
		
		// 출력!
		for (int i = 0; i < arr.length; i++) {
			int[] inArr = arr[i];
			for (int j = 0; j < inArr.length; j++) {
				System.out.print(inArr[j] + " ");
			}
			System.out.println();
		}
	}
}
