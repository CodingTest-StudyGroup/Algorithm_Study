package com.boj.greedy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_S4_1026_보물 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N;
	static Integer[] A;
	static int[] B;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		
		A = new Integer[N];
		B = new int[N];
		tokens = new StringTokenizer(input.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(tokens.nextToken());
		}
		tokens = new StringTokenizer(input.readLine());
		for(int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(tokens.nextToken());
		}
		
		int[] sortB = B.clone();
		Arrays.sort(sortB);
		
		Arrays.sort(A, Collections.reverseOrder());
		int ans = 0;
		for(int i = 0; i < N; i++) {
			ans += A[i] * sortB[i];
		}
		
		System.out.println(ans);
		

	}

}
