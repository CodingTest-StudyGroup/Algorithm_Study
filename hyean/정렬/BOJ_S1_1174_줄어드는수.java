package com.boj.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1174.줄어드는 수
 * 실패....
 * 1038과 거의 비슷!
 * @author ashle
 */
public class BOJ_S1_1174_줄어드는수 {
	
	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
	private static int N; // N번째로 작은 줄어드는 수 구하기
	private static ArrayList<Long> list = new ArrayList<Long>();
	private static int[] nums = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		addNum(0, 0);
		list.sort(null);
		
		if(N > 1023) {
			System.out.println(-1);
		}
		else {
			System.out.println(list.get(N -1));
		}
	}
	
	public static void addNum(long num, int len) {
		if(!list.contains(num)) {
			list.add(num);
		}
		if(len >= 10) return;
		
		addNum((num * 10) + nums[len], len + 1);
		addNum(num, len + 1);
	}
	
}
