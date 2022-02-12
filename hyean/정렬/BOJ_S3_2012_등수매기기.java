package com.boj.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 2012.등수 매기기
 * @author ashle
 *
 */
public class BOJ_S3_2012_등수매기기 {
	
	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder output = new StringBuilder();

	private static int N;
	private static int[] predict;
	private static long answer = 0;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		
		predict = new int[N];
		
		for(int i = 0; i < N; i++) {
			predict[i] = Integer.parseInt(input.readLine());
		}
		
		Arrays.sort(predict);
		
		for(int i = 0; i < N; i++) {
			if(predict[i] != i+1) {
				answer += Math.abs((i+1) - predict[i]);
			}
		}
		
		output.append(answer);
		System.out.println(output);
		

	}

}
