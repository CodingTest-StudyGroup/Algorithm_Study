package com.boj.implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 8979.올림픽
 * @author ashle
 *
 */
public class BOJ_S5_8979_올림픽 {

	private static int N; // 국가의 수
	private static int K; // 등수를 알고 싶은 국가
	private static Medal[] country; // 국가 별 메달 수

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		K = scanner.nextInt();
		country = new Medal[N];

		for (int i = 0; i < N; i++) {
			country[i] = new Medal();
			country[i].num = scanner.nextInt(); // 국가 번호
			country[i].gold = scanner.nextInt(); // 금메달 수
			country[i].silver = scanner.nextInt(); // 은메달 수
			country[i].bronze = scanner.nextInt(); // 동메달 수
		}
		scanner.close();

		int result = CountryRank(country);
		System.out.println(result);

	}

	public static int CountryRank(Medal[] country) {
		int rank = 1;
		int answer = 0;
		for (int i = 0; i < N; i++) {
			if (country[i].num == K)
				answer = i;
		}

		for (int i = 0; i < N; i++) {
			if (country[i].gold > country[answer].gold) // 해당 국가의 금메달 수가 더 적으면 
				rank++; // 등수 밑으로..
			else if ((country[i].gold == country[answer].gold) && (country[i].silver > country[answer].silver))
				// 금메달 수가 같지만, 은메달 수가 더 적으면
				rank++; // 등수 밀으로..
			else if ((country[i].gold == country[answer].gold) && (country[i].silver == country[answer].silver)
					&& (country[i].bronze > country[answer].bronze))
				// 금메달 수와 은메달 수가 같지만, 동메달 수가 더 적으면
				rank++; // 등수 밑으로..
		}
		return rank;
	}

	private static class Medal {
		int num;
		int gold;
		int silver;
		int bronze;
	}
}
