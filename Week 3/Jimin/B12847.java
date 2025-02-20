// 문제: 백준 12847 꿀 아르바이트 (실버3)
// 링크: https://www.acmicpc.net/problem/12847
// 시간: 276 ms, 메모리: 25408 kb

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B12847 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		long[] arr = new long[n]; // 데이터 타입 훼이크에 또 속았다 .. ㅂㄷㅂㄷ
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// Sliding Window
		long sum = 0;
		long max = 0;

		for (int i = 0; i < n; i++) {
			sum += arr[i];

			if (i == m - 1)
				max = sum;

			if (i >= m) {
				sum -= arr[i-m];
				max = Math.max(max, sum);
			}
		}
		
		bw.write(String.valueOf(max));
		
		br.close();
		bw.flush();
		bw.close();
	}
}
