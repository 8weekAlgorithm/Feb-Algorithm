// 문제: 백준 29700 우당탕탕 영화예매
// 링크: https://www.acmicpc.net/problem/29700
// 시간: 312ms

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B29700 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextwToken());// 세로
		int m = Integer.parseInt(st.nextToken());// 가로
		int k = Integer.parseInt(st.nextToken());// 학생수

		int ans = 0;
		for (int j = 0; j < n; j++) {
			String str = br.readLine();
			int cnt = 0;
			for (int i = 0; i < m; i++) {
				if (str.charAt(i) == '0') {
					cnt++;
				} else {//0이 나오면 초기화 되기 때문에 초기화
					if (cnt >= k) {
						ans += cnt - k + 1;
					}
					cnt = 0;
				}
			}
			// k이상이면 차이만큼+?
			if (cnt >= k) {
				ans += cnt - k + 1;
			}
		}
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
	}
}