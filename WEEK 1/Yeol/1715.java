// 문제: 백준 1715번 카드 정렬
// 링크: https://www.acmicpc.net/problem/1715
// 시간: 916 ms

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			pq.offer(sc.nextInt());
		}

		int ans = 0;
		while (pq.size() > 1) {
			int first = pq.poll();
			int second = pq.poll();

			int sum = first + second;

			pq.offer(sum);
			ans += sum;
		}
		
		System.out.println(ans);
		
		sc.close();
	}
}
