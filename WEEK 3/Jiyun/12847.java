// 문제: 백준 12847번 꿀 아르바이트
// 링크: https://www.acmicpc.net/problem/12847
// 시간: 284ms

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] pay = new int[N];
		for (int i = 0; i < N; i++)
			pay[i] = Integer.parseInt(st.nextToken());

		long max, sum = 0;
		for (int i = 0; i < M; i++)
			sum += pay[i];
		max = sum;

		for (int right = M; right < N; right++) {
			sum -= pay[right - M];
			sum += pay[right];

			max = Math.max(max, sum);
		}

		System.out.println(max);
	}
}
