// 문제: 백준 28075번 스파이
// 링크: https://www.acmicpc.net/problem/28075
// 시간: 136ms

import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] point;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		point = new int[2][3];
		for (int i = 0; i < 2; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++)
				point[i][j] = Integer.parseInt(st.nextToken());
		}

		answer = 0;
		spy(0, -1, 0);

		System.out.println(answer);

	}

	static void spy(int day, int loc, int sum) {
		// day날짜 loc장소 sum합

		// Base Case
		if (day == N) {
			if (sum >= M)
				answer++;
			return;
		}

		// 모든 경우의 수를 방문
		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 2; i++) {
				if (loc == j) // 이전에 방문한 장소면
					spy(day + 1, j, sum + (point[i][j] / 2));
				else // 방문한 장소가 아니면
					spy(day + 1, j, sum + point[i][j]);
			}
		}
	}
}