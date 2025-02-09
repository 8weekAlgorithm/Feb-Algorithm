// 문제: 백준 11650번 좌표 정렬하기
// 링크: https://www.acmicpc.net/problem/11650
// 시간: 1224ms

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][2];

		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, (o1, o2) -> {
			return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
		});

		for (int[] a : arr) {
			System.out.println(a[0] + " " + a[1]);
		}
	}
}