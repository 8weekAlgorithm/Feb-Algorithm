/**
 * 문제 : 백준 2559번. 수열
 * 링크 : https://www.acmicpc.net/problem/2559
 * 시간 : 252ms
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2559_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N]; // 온도

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int max = 0;
		int sum = 0;

		for (int i = 0; i < N; i++) {
			sum += arr[i];
			if(i == k-1) {
				max = sum;
			}
			if(i>=k) {
				sum -= arr[i-k];
				max = Math.max(max, sum);
			}
		}

		System.out.println(max);

	}

}
