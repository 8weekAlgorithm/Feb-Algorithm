// 문제: [이분탐색-응용2] 백준 2805번 나무 자르기 (실버2)
// 링크: https://www.acmicpc.net/problem/2805
// 시간: 484 ms 메모리: 119364 kb

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 나무의 수
		int N = Integer.parseInt(st.nextToken());
		// 나무의 높이
		int M = Integer.parseInt(st.nextToken());

		// 나무의 높이를 저장할 배열 선언
		int[] arr = new int[N];
		
		int minH = 0;
		int maxH = Integer.MIN_VALUE;
		
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i] > maxH) maxH = Math.max(maxH, arr[i]);
		}
		
		while (minH <= maxH) {
			long sum = 0;
			int mid = (minH + maxH) / 2;
			
			for (int i = 0; i < N; i++) {
				if (arr[i] > mid) {
					sum += arr[i] - mid;
				}
			}

			if(sum >= M) {
				minH = mid + 1;
			} else {
				maxH = mid - 1;
			}
		}
		System.out.println(maxH);
	}
}
