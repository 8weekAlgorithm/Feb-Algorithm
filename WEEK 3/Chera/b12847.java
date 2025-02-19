/**
 * 문제 : 백준 12847번 꿀 알바
 * 링크 : https://www.acmicpc.net/problem/12847
 * 시간 : 280ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b12847 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N  = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] salary = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			salary[i] = Integer.parseInt(st.nextToken());
		}
		long max = Integer.MIN_VALUE;
		long sum = 0;
		for(int i = 0; i<N; i++) {
			if(i<M) {
				sum+=salary[i];
			}
			
			if(i>=M) {
				sum += salary[i] - salary[i-M];
			}
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}

}
