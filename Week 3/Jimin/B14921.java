// 문제: 백준 14921 용액 합성하기 (골드5)
// 링크: https://www.acmicpc.net/problem/14921
// 시간: 288 ms 메모리: 25612 kb

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B14921 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// Two pointer
		int left = 0;
		int right = N - 1;

		int minAbs = Integer.MAX_VALUE;
		int minVal = Integer.MAX_VALUE;

		while (left < right) {
			int num = arr[left] + arr[right]; // 좌우 포인터의 값의 합

			if (minAbs > Math.abs(num)) { // 합의 절대값이 최소값일 경우
				minAbs = Math.abs(num); 
				minVal = num;
			}

			if (num > 0) { // 합이 양수일 경우, right 감소
				right--;
			} else if (num < 0) { // 합이 음수일 경우, left 증가
				left++;
			} else { // 합이 0 -> 찾았으니 break;
				break;
			}

		}

		bw.write(String.valueOf(minVal));

		br.close();
		bw.flush();
		bw.close();
	}
}
