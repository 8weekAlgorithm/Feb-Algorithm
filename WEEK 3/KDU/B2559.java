// 문제: 백준 2559번 수열
// 링크: https://www.acmicpc.net/problem/2559
// 시간: 248ms


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B2559 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int sum = 0;
		int maxsum = 0;
		// 크기 k의 슬라이딩 윈도우의 초기값을 설정해줌(0~k-1의 누적합)
		for (int i = 0; i < k; i++) {
			sum += arr[i];
		}
		maxsum = sum;

		// 슬라이딩 윈도우를 오른쪽으로 한칸씩 이동하면서 누적합을 갱신함
		for (int i = k; i < arr.length; i++) {
			// 오른쪽으로 한칸 이동(arr[i]), 왼쪽으로 한칸 이동(-arr[i-k])
			sum += arr[i] - arr[i - k];
			maxsum = Math.max(maxsum, sum);
		}
		sb.append(maxsum);
		bw.write(sb.toString());

		bw.flush();
		bw.close();
		br.close();
	}
}

