package com.boj.greedy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S1_17615_볼모으기 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N;
	static char[] balls;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		
		balls = new char[N];
		String str = input.readLine();
		for(int i = 0; i < N; i++) {
			balls[i] = str.charAt(i);
		}
//		System.out.println(Arrays.toString(balls));
		
		int rCnt = 0;
		int bCnt = 0;
		for(int i = 0; i < N; i++) {
			if(balls[i] == 'R') rCnt++;
			if(balls[i] == 'B') bCnt++;
		}
		
		int ans = Math.min(rCnt, bCnt);
		
		int leftCnt = 0; // 왼쪽부터 연속된 색깔의 개수 
		for(int i = 0; i < N; i++) {
			if(balls[0] != balls[i]) break;
			leftCnt++;
		}

		int rightCnt = 0; // 오른쪽부터 연속된 색깔의 개수 
		for(int i = N-1; i >= 0; i--) {
			if(balls[N-1] != balls[i]) break;
			rightCnt++;
		}
		
		// 첫번째 공이 빨강일 때 움직여야되는 수랑 파랑일 때 움직여야 되는 수 
		int minA = 0;
		if(balls[0] == 'R') minA = rCnt-leftCnt;
		else minA = bCnt-leftCnt;
				
		// 마지막 공이 빨강일 때 움직여야되는 수랑 파랑일 때 움직여야 되는 수 
		int minB = 0;
		if(balls[N-1] == 'R') minB = rCnt-rightCnt;
		else minB = bCnt-rightCnt;

		int answer = Math.min(Math.min(ans, minA), Math.min(ans, minB)); // 움직여야 하는 공들의 개수 중 최솟값 
		System.out.println(answer);
	}

}
