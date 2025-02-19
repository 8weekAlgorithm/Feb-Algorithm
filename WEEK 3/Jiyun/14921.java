// 문제: 백준 14921번 용액 합성하기
// 링크: https://www.acmicpc.net/problem/14921
// 시간: 332ms

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] flask = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			flask[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(flask);

		// 풀이 시작
		int left = 0;
		int right = N - 1;

		int result = flask[left] + flask[right];
		while (left < right) {
			int sum = flask[left] + flask[right];

			if (Math.abs(sum) < Math.abs(result)) {
				result = sum;
			}

			if (sum == 0) {
				break;
			}

			if (sum > 0) {
				right--;
			} else if (sum < 0) {
				left++;
			}
		}

		System.out.println(result);
	}
}
