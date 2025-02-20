// 문제: 백준 29700번 우당탕탕 영화예매매
// 링크: https://www.acmicpc.net/problem/29700
// 시간: 360ms

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] theater = new int[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				if (line.charAt(j) == '0')
					theater[i][j] = 0;
				else
					theater[i][j] = 1;
			}
		}

		// 풀이 시작
		int answer = 0;

		for (int i = 0; i < N; i++) {
			int left = 0;
			int right = K - 1;

			int sum = 0;
			for (int j = left; j <= right && j < M; j++)
				sum += theater[i][j];

			for (int j = 0; j <= M - K; j++) {
                if (sum == 0) answer++;

                sum -= theater[i][left++];
                if (right < M - 1)
                    sum += theater[i][++right];
            }
		}

		System.out.println(answer);
	}
}
