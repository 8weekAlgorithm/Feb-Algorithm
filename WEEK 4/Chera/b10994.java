/**
 * 문제 : 백준 10994번 별 찍기 - 19
 * 링크 : https://www.acmicpc.net/problem/10994
 * 시간 : 212ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b10994 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int m = 0;
		String arr[][] = new String[1 + 4 * (N - 1)][1 + 4 * (N - 1)];
		stars(N, m, arr);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	static void stars(int N, int m, String[][] arr) {
		if (m < N) {
			for (int i = 2 * m; i < 1 + 4 * (N - 1) - 2 * m; i++) {
				for (int j = 2 * m; j < 1 + 4 * (N - 1) - 2 * m; j++) {
					// 첫줄과 마지막줄 모든칸 *
					if (i == 2 * m || i == 4 * (N - 1) - 2 * m) {
						arr[i][j] = "*";
					}
					// 양끝 세로줄 모든 칸 *
					else if (j == 2 * m || j == 4 * (N - 1) - 2 * m) {
						arr[i][j] = "*";
					}
					// 행 기준 가운데 줄에서 열의 인덱스가 짝수인 칸 *
					else if (j % 2 == 0 && i == 4 * (N - 1) / 2) {
						arr[i][j] = "*";
					}
					// 나머지 공백
					else {
						arr[i][j] = " ";
					}
				}
			}
			stars(N, m + 1, arr);
		}

	}

}
