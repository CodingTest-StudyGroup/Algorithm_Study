package com.boj.greedy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_S3_1449_수리공항승 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	static int N, L;
	static double[][] water;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		L = Integer.parseInt(tokens.nextToken());

		water = new double[N][2];
		tokens = new StringTokenizer(input.readLine());
		for (int i = 0; i < N; i++) {
			int dir = Integer.parseInt(tokens.nextToken());
			water[i][0] = dir - 0.5;
			water[i][1] = dir + 0.5;

		}


		Arrays.sort(water, new Comparator<double[]>() {
			@Override
			public int compare(double[] o1, double[] o2) {
				return Double.compare(o1[0], o2[0]);
			}
		});
		
		double start = water[0][0] + L;
		int cnt = 1;
		for(int i = 1; i < N; i++) {
			if(start < water[i][1]) {
				start = water[i][0] + L;
				cnt++;
			}
		}
		
		System.out.println(cnt);

	}


	 

}
