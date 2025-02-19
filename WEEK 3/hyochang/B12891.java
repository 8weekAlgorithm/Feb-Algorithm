// 문제: 백준 12891번 DNA 비밀번호
// 링크: https://www.acmicpc.net/problem/12891
// 시간: 272ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12891 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int s = Integer.parseInt(st.nextToken());// 문자열 길이
		int p = Integer.parseInt(st.nextToken());// 암호 길이

		String str = br.readLine();

		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		int cnt_a = 0;
		int cnt_c = 0;
		int cnt_g = 0;
		int cnt_t = 0;
		int ans = 0;
		for (int i = 0; i < p; i++) {
			char o = str.charAt(i);
			switch (o) {
			case 'A':
				cnt_a++;
				break;
			case 'C':
				cnt_c++;
				break;
			case 'G':
				cnt_g++;
				break;
			case 'T':
				cnt_t++;
				break;
			default:
				break;
			}
		}

		if (cnt_a >= a && cnt_c >= c && cnt_g >= g && cnt_t >= t) {
			ans++;
		}

		for (int i = 1; i <= s-p; i++) {
			char out = str.charAt(i-1);
			switch (out) {
			case 'A':
				cnt_a--;
				break;
			case 'C':
				cnt_c--;
				break;
			case 'G':
				cnt_g--;
				break;
			case 'T':
				cnt_t--;
				break;
			default:
				break;
			}
			char in = str.charAt(i+p-1);
			switch (in) {
			case 'A':
				cnt_a++;
				break;
			case 'C':
				cnt_c++;
				break;
			case 'G':
				cnt_g++;
				break;
			case 'T':
				cnt_t++;
				break;
			default:
				break;
			}
			if (cnt_a >= a && cnt_c >= c && cnt_g >= g && cnt_t >= t) {
				ans++;
			}
		}
		System.out.println(ans);
	}

}
