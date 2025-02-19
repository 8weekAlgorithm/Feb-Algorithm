/**
 * 문제 : 백준 29700번 우당탕탕 영화예매
 * 링크 : https://www.acmicpc.net/problem/29700
 * 시간 : 732ms,   메모리 : 304152KB
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b29700 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 좌석 세로줄
		int M = Integer.parseInt(st.nextToken()); // 좌석 가로줄
		int K = Integer.parseInt(st.nextToken()); // 동아리원 수
		String[] seat = new String[N];
		for (int i = 0; i < N; i++) {
			seat[i] = br.readLine();

		}
		StringBuilder possible = new StringBuilder();
		for (int k = 0; k < K; k++) {
			possible.append(0);
		}
	

		int sum = 0;
		for (int i = 0; i < N; i++) {
			StringBuilder sb = new StringBuilder();
			String str = null;
			for(int j = 0; j<M; j++) {
				sb.append(seat[i].charAt(j));
				
				if(j == K-1) {
					str = sb.toString();
				}
				
				if(j>=K) {
					str = sb.substring(j-K+1);
				}
				
				if(str != null && str.equals(possible.toString())) {
					sum++;
				}
			}

		}
		System.out.println(sum);
	}

}
