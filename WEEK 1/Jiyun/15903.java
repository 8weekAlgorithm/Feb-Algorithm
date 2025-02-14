// 문제: 백준 15903번 카드 합체 놀이
// 링크: https://www.acmicpc.net/problem/15903
// 시간: 144ms

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		PriorityQueue<Long> cards = new PriorityQueue<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			cards.add(Long.parseLong(st.nextToken()));

		br.close();

		// 제일 작은 2개 카드를 꺼내 더한 후 삽입
		for (int i = 0; i < m; i++) {
			long a = cards.remove();
			long b = cards.remove();
		
			cards.add(a + b);
			cards.add(a + b);
		}

		// 합 계산
		long result = 0;
		for (int i = 0; i < n; i++) {
			result += cards.remove();
		}

		System.out.println(result);
	}
}