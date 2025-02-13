// 문제: 백준 2110번 공유기 설치
// 링크: https://www.acmicpc.net/problem/2110
// 시간: 260ms

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);

		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int[] map = new int[N];

		for (int i = 0; i < N; i++)
			map[i] = Integer.parseInt(br.readLine());

		// 문제 풀이
		Arrays.sort(map);

		int left = 1;
		int right = map[map.length - 1] - map[0];
		int answer = 0;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (check(map, mid, C)) {
				answer = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		System.out.println(answer);
	}

	// 공유기 설치가 가능한지 확인
	static boolean check(int[] map, int distance, int C) {

		int install = 1;
		int prev = map[0];

        // 주어진 거리 이상의 간격으로 설치
		for (int i = 1; i < map.length; i++) {
			if (map[i] - prev >= distance) {
				install++;
				prev = map[i];
			}
		}

		if (install >= C)
			return true;
		else
			return false;
	}
}