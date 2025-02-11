// 문제: 백준 10816번 숫자 카드 2
// 링크: https://www.acmicpc.net/problem/10816
// 시간: 1476ms

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		// 입력 받기
		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);

		int[] cards = new int[N];
		for (int i = 0; i < N; i++)
			cards[i] = Integer.parseInt(st.nextToken());

		int M = Integer.parseInt(br.readLine());
		input = br.readLine();
		st = new StringTokenizer(input);

		int[] find = new int[M];
		for (int i = 0; i < M; i++)
			find[i] = Integer.parseInt(st.nextToken());

		br.close();

		// 문제 풀이
		Arrays.sort(cards);

		for (int target : find) {

			int left = 0;
			int right = cards.length;

			// lowerBound : target이 처음 나타나는 위치
			while (left < right) {
				int mid = (left + right) / 2;

				if (cards[mid] >= target) {
					right = mid;
				} else {
					left = mid + 1;
				}
			}
			int start = left;

			left = 0;
			right = cards.length;

			// upperBound : target 다음 값이 처음 나타나는 위치
			while (left < right) {
				int mid = (left + right) / 2;

				if (cards[mid] > target) {
					right = mid;
				} else {
					left = mid + 1;
				}
			}
			int end = left;

			sb.append((end - start) + " ");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}