// 문제: 백준 1431번 시리얼 번호
// 링크: https://www.acmicpc.net/problem/1431
// 시간: 112ms

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class test {
	
	/* comparator란? -> 클래스 외부에서 새로운 메서드를 만들면 새로운 정렬 기준을 만들 수 있음!
	 * 2번째 정렬 기준인 숫자 합을 구하기 위해서 새로운 정렬 기준을 만들려고 함
	 * 문자열을 하나씩 뜯어서 만약 요소가 숫자라면 그 숫자를 누적으로 저장함
	 * 이 때, 해당 char 변수를 '0'을 더한다면 0에 해당하는 아스키코드인 48을 더하게 됨
	 * 그렇다면 숫자 값에 48을 더한 값이 저장되게 되고 각 숫자합을 비교할 수 있게 됨(자동변환)
()	 * */
	static int sumNumbers(String string) {
		int sum = 0;
		for (char c : string.toCharArray()) {
			if(Character.isDigit(c)) {
				sum += c + '0';
			}
		}
		return sum;
	}
	
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		String[] serial = new String[N];
		
		for (int i = 0; i < N; i++) {
			serial[i] = br.readLine();
		}
		
		/* Arrays.sort를 통해 정렬을 진행했으며,
		 * 첫번째 정렬 기준 : 문자열의 길이
		 * 두번째 정렬 기준 : 새로 만든 정렬 기준(sumNumbers)
		 * 세번째 정렬 기준 : 문자 사전 순서(compareTo)
		 * 위쪽 주석 한 내용은 메소드 참조 연산자이며, 원래는 그 밑에 있는 람다 표현식으로 써야됨
		 * */
		
		// 메소드 참조 연산자(::) 사용
//		Arrays.sort(serial,Comparator
//				.comparingInt(String::length)
//				.thenComparingInt((test::sumNumbers))
//				.thenComparing(String::compareTo));
		
		// 람다 표현식(->) 사용
        Arrays.sort(serial, Comparator
                .comparingInt((String s) -> s.length()) // 문자열 길이 기준 정렬
                .thenComparingInt((String s) -> test.sumNumbers(s)) // 숫자 합 기준 정렬
                .thenComparing((String s1,String s2) -> s1.compareTo(s2))); // 알파벳순 정렬
		
		for (String string : serial) {
			sb.append(string).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}
