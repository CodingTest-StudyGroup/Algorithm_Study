package com.ssafy;

import java.util.Scanner;

public class P1541_잃어버린괄호 {

	public static void main(String[] args){

		Scanner scan = new Scanner(System.in);
		String equation = scan.next();
		scan.close();
		
		String[] nums = equation.split("\\-");
		int[] intNums = new int[nums.length];
		
		for (int i=0; i<nums.length; i++) {
			int sum = 0;
			String[] temp = nums[i].split("\\+");
			for (String n : temp) {
				sum += Integer.parseInt(n);
			}
			intNums[i] = sum;
		}
		
		int result = intNums[0];
		
		for(int i=1; i<intNums.length; i++) {
			result -= intNums[i];
		}
		
		System.out.println(result);
		
	}// main

}
