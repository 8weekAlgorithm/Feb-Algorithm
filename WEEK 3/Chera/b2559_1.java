/**
 * 문제 : 백준 2559번 수열
 * 링크 : https://www.acmicpc.net/problem/2559
 * 시간 : 1004ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2559_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N]; // 온도
		
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int max = Integer.MIN_VALUE;
		for(int i = 0; i<N-k+1; i++) {
			int sum = 0;
			for(int j = i; j<k+i; j++) {
				sum+=arr[j];
			}
			max = Math.max(max, sum);
		}

		System.out.println(max);
		
	}

}
