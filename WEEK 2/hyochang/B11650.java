// 문제: 백준 11650번 좌표 정렬하기
// 링크: https://www.acmicpc.net/problem/11650
// 시간: 644ms

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B11650 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, new Comparator<int[]>() {//컴퍼레이터로 조건 만족

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[0]==o2[0]) {//같으면
					return Integer.compare(o1[1], o2[1]);//y값을 비교
				}
				return Integer.compare(o1[0], o2[0]);//원래 조건대로로
			}
		});
		for(int i=0;i<n;i++) {
			sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}