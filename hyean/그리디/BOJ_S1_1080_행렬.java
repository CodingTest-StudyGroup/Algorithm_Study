package com.boj.greedy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S1_1080_행렬 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, M;
	static int[][] A;
	static int[][] B;
	

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		A = new int[N][M];
		B = new int[N][M];
		for(int r = 0; r < N; r++) {
			String str = input.readLine();
			for(int c = 0; c < M; c++) {
				A[r][c] = str.charAt(c)-'0';
			}
		}
		for(int r = 0; r < N; r++) {
			String str = input.readLine();
			for(int c = 0; c < M; c++) {
				B[r][c] = str.charAt(c)-'0';
			}
		}
		
//		for(int[] row : A) {
//			System.out.println(Arrays.toString(row));
//		}
//		for(int[] row : B) {
//			System.out.println(Arrays.toString(row));
//		}
		
		int cnt = 0;
		for(int r = 0; r <= N-3; r++) {
			for(int c = 0; c <= M-3; c++) {
				if(A[r][c] != B[r][c]) {
					cnt++; // 두개가 다르면 cnt 증가 
					for (int i = r; i < r + 3; i++) { 
						for (int j = c; j < c + 3; j++) { 
							A[i][j] = (A[i][j] == 0) ? 1 : 0; // 뒤집음 
						} 
					}	
				}
			}
		}
		
		boolean isSame = true;
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(A[r][c] != B[r][c]) {
					isSame = false; // 다 뒤집어봤는데도 못바꾸면 false 
					break;
				}
			}
		}

		System.out.println(isSame ? cnt : -1);
	}

}
