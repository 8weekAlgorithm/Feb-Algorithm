// 문제: [정렬-응용1] 백준 1431번 시리얼 번호 (실버3)
// 링크: https://www.acmicpc.net/problem/1431
// 시간: 108 ms 메모리: 14340 kb

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class B1431 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine()); // 기타의 개수

		String[] str = new String[N];
		
		for(int i=0; i<N; i++) {
			str[i] = br.readLine();
		}
		
		Arrays.sort(str, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() < o2.length()) return -1; // A와 B의 길이가 다르면
				else if(o1.length() == o2.length()) { // A와 B의 길이가 같다면
					if(numSum(o1) < numSum(o2)) return -1; // 문자열의 숫자의 합 비교
					else if(numSum(o1) == numSum(o2)) { // 숫자 합 마저 같다면
						return o1.compareTo(o2); // 사전순으로 비교
						// compareTo() -> 두 개의 문자열을 비교
						// 0 : 두개의 문자열이 동일, 양수 : 호출하는 객체가 인자보다 순서가 앞설 때, 음수 : 인자가 더 앞설 때 출력
					}
					else return 1;
				}
				else return 1;
			}
		});
		
		for(String s : str) {
			bw.write(s);
			bw.newLine();
		}
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static int numSum(String s) {
		int sum = 0;
		for(char c : s.toCharArray()) {
			if(48 <= c && c <= 57) sum += c - '0';
		}
		return sum;
	}
}