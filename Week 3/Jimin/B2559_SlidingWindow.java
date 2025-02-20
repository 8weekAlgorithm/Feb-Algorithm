// 문제: 백준 2559 수열 (실버3)
// 링크: https://www.acmicpc.net/problem/2559
// 시간: 244 ms, 메모리: 24244 kb

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B2559_SlidingWindow {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 2. Sliding Window
		int max = 0;
		int sum = 0;

		for (int i = 0; i < N; i++) {
			sum += arr[i];
			
			// 최초에 나온 합을 최댓값으로 잡아놓음
			if(i == K - 1) max = sum;
			
			// 처음 길이를 벗어났을 때부터 한 칸씩 밀어주면서 최댓값 비교
			if(i >= K) {
				sum -= arr[i-K];
				max = Math.max(max, sum);
			}
		}
		
		bw.write(String.valueOf(max));

		br.close();
		bw.flush();
		bw.close();
	}

}
