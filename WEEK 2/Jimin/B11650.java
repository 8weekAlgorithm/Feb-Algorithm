// 문제: [기본문제1] 백준 11650번 좌표 정렬하기 (실버5)
// 링크: https://www.acmicpc.net/problem/11650
// 시간: 672 ms 메모리: 49256 kb

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11650 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 점의 개수 N 입력
		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		// 기존의 Arrays.sort 에 람다식을 이용
		Arrays.sort(arr, (arr1, arr2) -> {
			if (arr1[0] == arr2[0]) {
				return arr1[1] - arr2[1];
			} else {
				return arr1[0] - arr2[0];
			}
		});
		
		for(int i=0; i<N; i++) {
			bw.write(arr[i][0] + " " + arr[i][1]);
			bw.newLine();
		}
		br.close();
		bw.flush();
		bw.close();
	}
}