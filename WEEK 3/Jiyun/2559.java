// 문제: 백준 2559번 수열
// 링크: https://www.acmicpc.net/problem/2559
// 시간: 244ms

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] temp = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			temp[i] = Integer.parseInt(st.nextToken());

		// 풀이 시작
		int left = 0;
		int right = K;
		int max = 0;
		
		for (int i = left; i < right; i++)
			max += temp[i];

		int sum = max;
		for (int i = 0; i < N - K; i++) {
			sum -= temp[left++];
			sum += temp[right++];
			
			max = Math.max(max, sum);
		}

		System.out.println(max);
	}
}
