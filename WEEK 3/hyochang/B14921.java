// 문제: 백준 14921번 용액 합성하기
// 링크: https://www.acmicpc.net/problem/14921
// 시간: 304ms

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B14921 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int[] liquid = new int[n];
		String[] temp = (br.readLine()).split(" ");
		for (int i = 0; i < n; i++) {
			liquid[i] = Integer.parseInt(temp[i]);
		}

		int right = n - 1;
		int left = 0;
		int ans = Integer.MAX_VALUE;
		while (left < right) {
			int sum = liquid[left] + liquid[right];
			int absum = Math.abs(liquid[left] + liquid[right]);
			if (sum == 0) {
				ans = 0;
				break;
			} else if (sum < 0) {
				left++;
			} else {
				right--;
			}
			if (absum < Math.abs(ans)) {
				ans = sum;
			}
		}
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
	}
}