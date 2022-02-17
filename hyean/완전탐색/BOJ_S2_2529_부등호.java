package com.boj.bruteforcing;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_S2_2529_부등호 {
	
	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder output = new StringBuilder();
	private static StringTokenizer tokens;
	
	private static int k; // 부등호 문자의 개수를 나타내는 정수
	private static String[] symbol; // 부등호
	private static int[] num = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	private static int[] cases;
	private static boolean[] isSelected;
	private static int correct;
	private static String caseTostring;
	private static ArrayList<String> result = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		k = Integer.parseInt(input.readLine());
		
		symbol = new String[k];
		isSelected = new boolean[10];
		cases = new int[k+1];
		tokens = new StringTokenizer(input.readLine());
		for(int i = 0; i < k; i++) {
			symbol[i] = tokens.nextToken();
		}
		// 입력완료
		
		permutation(0);

		Collections.sort(result); // 오름차순 정렬
		System.out.println(result.get(result.size()-1)); // 최대 정수
		System.out.println(result.get(0)); // 최소 정수
		
	}
	
	//nPr : 10개 숫자 중 k+1개를 순서 따져서 뽑기
	public static void permutation(int cnt) {
		if(cnt == k+1) {
			correct = 0;
			for(int i = 0; i < k; i++) {
				if((symbol[i].equals(">") && cases[i] > cases[i+1]) || (symbol[i].equals("<") && cases[i] < cases[i+1])) {
					correct++;		
				}
			} // symbol[i]로 cases[i] 와 cases[i+1]의 식이 성립이 된다면 correct 증가!
			if(correct == k) {
				caseTostring = Arrays.toString(cases);
				// int배열 cases를 문자열로 변환
				caseTostring = caseTostring.substring(1, caseTostring.length()-1).replace(", ", "");
				result.add(caseTostring);
			}
			
			return;
		}
		
		for(int i = 0; i < 10; i++) {
			if(isSelected[i]) continue;
			cases[cnt] = num[i];
			isSelected[i] = true;
			
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}

}
