// 문제: 백준 10994 별 찍기 - 19 (실버4)
// 링크: https://www.acmicpc.net/problem/10994
// 시간: 192 ms, 메모리: 16648 kb

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B10994 {
	static String[][] str;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 별찍기 패턴 4n - 3

		N = Integer.parseInt(br.readLine());
		
		str = new String[4 * N - 3][4 * N - 3];

		recursion(N, 0, 4 * N - 4);
		
		for(int i=0; i<4*N-3; i++) {
			for(int j=0; j<4*N-3; j++) {
				bw.write(str[i][j]);
			}
			bw.newLine();
		}
		br.close();
		bw.flush();
		bw.close();
	}

	public static void recursion(int n, int start, int end) {
		if (n == 1) {
			str[start][end] = "*";
			return;
		}
		for (int i = start; i <= end; i++) {
			for (int j = start; j <= end; j++) {
				if (i == start || i == end || j == start || j == end) {
					str[i][j] = "*";
				} else {
					str[i][j] = " ";
				}
			}
		}
		recursion(n - 1, start + 2, end - 2);
	}
}
