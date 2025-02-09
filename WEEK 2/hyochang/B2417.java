// 문제: 백준 2417번 정수 제곱근
// 링크: https://www.acmicpc.net/problem/2417
// 시간: 644ms

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B2417 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		long n = Long.parseLong(br.readLine());
		long right = n;
		long left = 0;
		long ans = 0;
		if (n == 0) {//0인 경우에는 출력하고 종료
			bw.write("0");
			bw.flush();
			bw.close();
			return;
		}

		while (left <= right) {//이분탐색
			long center = left + (right - left) / 2;//중앙값 설정
			if (center == 0) {// 아래 조건문 탐색 기준에서 0이 된다면 에러발생
				left = center + 1;
				continue;
			}else if (center <= n / center) {//제곱이 n을 넘어가면
				ans = center;
				left = center + 1;//최솟값을 당겨서 중앙값으로 바꿈
			} else {//못넘는 경우에는 최댓값을 당겨서 중앙값으로 바꿔준다
				right = center - 1;
			}
		}
		if (ans * ans < n) {//문제조건
			ans += 1;
		}
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
	}
}