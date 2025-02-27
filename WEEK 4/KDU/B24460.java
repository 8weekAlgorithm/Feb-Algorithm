// 문제: 백준 24460번 특별상이라도 받고 싶어
// 링크: https://www.acmicpc.net/problem/24460
// 시간: 616ms

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B24460 {


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int res = HCPC(n, arr);

		sb.append(res);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}

	public static int HCPC(int n, int[][] arr) {
		// 기저 조건 셋팅
		if (n == 1) {
			return arr[0][0];
		}
		int mid = n / 2;
		int[][] newarr = new int[mid][mid];
		// n/2개의 새로운 배열을 만듦
        // 새로운 배열에 두 번째 최솟값을 찾은 값을 배열에 하나씩 배정해줌
        // 이 때, secondmin은 2배씩 건너뛰면서 돌아야 정상적으로 찾을 수 있음
        // ex) 4x4 배열을 도는 경우 (0,0) -> (0,2) -> (2,0) -> (2,2)로 차례대로 secondmin 수행
		for (int i = 0; i < mid; i++) {
			for (int j = 0; j < mid; j++) {
				newarr[i][j] = secondmin(arr, i*2, j*2);
			}
		}
        // 반으로 줄어든 인덱스와 배열을 가지고 재귀 시작
		return HCPC(mid, newarr);
	}

    // 2차원 배열에서 두 번째 최솟값을 찾아 리턴하는 함수
    // 이를 통해 간단하게 두번째 최솟값을 찾을 수 있음
	public static int secondmin(int[][] arr, int startRow, int startCol) {
		int[] values = new int[4];
		values[0] = arr[startRow][startCol];
		values[1] = arr[startRow][startCol+1];
		values[2] = arr[startRow+1][startCol];
		values[3] = arr[startRow+1][startCol+1];
		Arrays.sort(values);
		return values[1];
	}
}
