// 문제: 백준 28075 스파이 (실버3)
// 링크: https://www.acmicpc.net/problem/28075
// 시간: 120 ms, 메모리: 14284 kb

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B28075 {

	static int[][] arr = new int[2][3];
	static int N, M;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 임무 수행 일수
		M = Integer.parseInt(st.nextToken()); // 얻고 싶은 최소 기여도

		for (int i = 0; i < 2; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		recursion(0, -1, 0);
		
		bw.write(String.valueOf(count));
		
		br.close();
		bw.flush();
		bw.close();
	}

	public static void recursion(int n, int J, int sum) {
		if(n == N) {
			if(sum >= M) {
				count++;
			}
			return;
		}

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				int num = arr[i][j];
				if(j == J) {
					num /= 2;
				}
				recursion(n + 1, j, sum + num);
			}
		}
	}
}
