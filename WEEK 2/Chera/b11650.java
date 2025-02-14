/**
 * 문제 : 백준 좌표정렬하기 11650번
 * 링크 : https://www.acmicpc.net/problem/11650
 * 시간 : 708ms
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class b11650 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, new Comparator<int[]>() {

			public int compare(int[] o1, int[] o2) {
				return o1[0]!=o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
			}

		});
		for(int i = 0; i<N; i++) {
			bw.write(arr[i][0] + " " + arr[i][1]);
			bw.newLine();
			
		}
		bw.close();
		

	}

}
