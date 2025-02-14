// 문제: [기본문제2] 백준 2417번 정수 제곱근 (실버4)
// 링크: https://www.acmicpc.net/problem/2417
// 시간: 100 ms 메모리: 14340 kb

package Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2417 {
	static long n, answer = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// bw.write() <- double 형이 없음 .. 이럴 때는 Sysout만 사용 가능한가 ?
		
		n = Long.parseLong(br.readLine());
		binarySearch(n);
		System.out.println(answer);
		
	}
	
	public static void binarySearch(long n) {
		long left = 0;
		long right = n;
		
		while(left <= right) {
			long mid = (left + right) / 2;
			if(Math.pow(mid, 2) >= n) { // 반환값 double, Math.pow(제곱근)
				answer = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
	}
}
