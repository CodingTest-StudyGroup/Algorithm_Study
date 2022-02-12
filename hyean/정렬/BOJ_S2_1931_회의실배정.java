package com.boj.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_S2_1931_회의실배정 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N; // 회의의 수
	static int[][] meeting;
	static int cnt = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(input.readLine());
		meeting = new int[N][2];
		for(int n = 0; n < N; n++) {
			tokens = new StringTokenizer(input.readLine());
			meeting[n][0] = Integer.parseInt(tokens.nextToken());
			meeting[n][1] = Integer.parseInt(tokens.nextToken());
		}
		
		/*for(int[] row : meeting) {
			System.out.println(Arrays.toString(row));
		}*/
		
		Arrays.sort(meeting, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					if(o1[1] == o2[1]) {
						return o1[0] - o2[0];
					}else {
						return o1[1] - o2[1];
					}
				}
		});

		int end = -1;
		for(int i = 0; i < N; i++) {
			if(meeting[i][0] >= end) {
				end = meeting[i][1];
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	
	static String src = "11\r\n" + 
			"1 4\r\n" + 
			"3 5\r\n" + 
			"0 6\r\n" + 
			"5 7\r\n" + 
			"3 8\r\n" + 
			"5 9\r\n" + 
			"6 10\r\n" + 
			"8 11\r\n" + 
			"8 12\r\n" + 
			"2 13\r\n" + 
			"12 14";

}

