// 문제: 백준 1431번 시리얼 번호
// 링크: https://www.acmicpc.net/problem/1431
// 시간: 116ms

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];

		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}

        // 정렬 시작
		Arrays.sort(arr, (o1, o2) -> {

            // 문자열 길이 비교
			if (o1.length() != o2.length()) {
				return Integer.compare(o1.length(), o2.length());
			} else {
                // 숫자 합 비교
				int o1Sum = 0;
				int o2Sum = 0;

                // A의 모든 자리수 합
				for (int i = 0; i < o1.length(); i++) {
					char c = o1.charAt(i);
					if (Character.isDigit(c)) {
						o1Sum += Integer.parseInt(String.valueOf(c));
					}
				}

                // B의 모든 자리수 합
				for (int i = 0; i < o2.length(); i++) {
					char c = o2.charAt(i);
					if (Character.isDigit(c)) {
						o2Sum += Integer.parseInt(String.valueOf(c));
					}
				}

				if (o1Sum != o2Sum) {
					return Integer.compare(o1Sum, o2Sum);
				} else {
                    // 합이 같다면 사전순으로
					return o1.compareTo(o2);
				}
			}
		});

		for (String a : arr) {
			System.out.println(a);
		}
	}
}