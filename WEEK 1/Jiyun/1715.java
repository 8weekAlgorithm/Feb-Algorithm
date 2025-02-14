// 문제: 백준 1715번 카드 정렬하기
// 링크: https://www.acmicpc.net/problem/1715
// 시간: 332ms


import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> cards = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			cards.add(Integer.parseInt(br.readLine()));
		}

		int result = 0;

		// 가장 작은 두 카드를 더한 후 삽입
		// 이 과정을 카드가 한 장 남을 때까지 반복
		while (cards.size() > 1) {
			int a = cards.remove();
			int b = cards.remove();

			result += a+b;
			cards.add(a + b);
		}
		
		System.out.println(result);
	}
}