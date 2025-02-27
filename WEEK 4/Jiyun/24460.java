// 문제: 백준 24460번 특별상이라도 받고 싶어
// 링크: https://www.acmicpc.net/problem/24460
// 시간: 580ms

import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		if (N == 1) {
			System.out.println(map[0][0]);
		} else {
			System.out.println(special(0, 0, N));
		}
	}

	static int special(int sr, int sc, int size) {

		if (size == 2) {
			int[] second = new int[4];
			second[0] = map[sr][sc];
			second[1] = map[sr][sc + 1];
			second[2] = map[sr + 1][sc];
			second[3] = map[sr + 1][sc + 1];

			Arrays.sort(second);
			return second[1];
		}

		int mid = size / 2;
		int[] second = new int[4];
		second[0] = special(sr, sc, mid);
		second[1] = special(sr, sc + mid, mid);
		second[2] = special(sr + mid, sc, mid);
		second[3] = special(sr + mid, sc + mid, mid);
		
		Arrays.sort(second);
		return second[1];
	}
}