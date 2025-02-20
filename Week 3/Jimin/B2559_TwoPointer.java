// 문제: 백준 2559 수열 (실버3)
// 링크: https://www.acmicpc.net/problem/2559
// 시간: 252 ms, 메모리: 23788 kb

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B2559_TwoPointer {
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

		// 1. Two Pointer

		// 처음 접근 방식을 left = 0, right = left + K 로 구현했는데, 잘 안 풀림
		// 인터넷에 찾아보니 투 포인터가 단순히 left, right 가 아닌
		// 0 ~ K 까지 더한 값을 defalut
		// 다음 -> 1p) 0의 값을 빼고, 2p) K+1 값을 더함
		// 신박하다 . . .
		// 라고 생각했는데 Sliding Window 푸니까 방식이 거의 동일했다 ..
		
		
		// 0 ~ K까지 더한 값을 구해서 sum 변수에 저장
		int sum = 0;
		for (int i = 0; i < K; i++) {
			sum += arr[i];
		}
        // 가장 큰 값을 저장
		int max = sum;
		
		for (int i = K; i < N; i++) {
			sum += arr[i]; // pointer
			sum -= arr[i - K]; // pointer
			max = Math.max(sum, max);
		}
		
		bw.write(String.valueOf(max));
		
		br.close();
		bw.flush();
		bw.close();
	}
}
