// 문제: 백준 15903번 카드 합체 놀이이
// 링크: https://www.acmicpc.net/problem/15903
// 시간: 288 ms

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextInt();
		long m = sc.nextInt();

		PriorityQueue<Long> pq = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			pq.offer(sc.nextLong());
		}

		for (int i = 0; i < m; i++) {
            
			long first = pq.poll();
			long second = pq.poll();

			long sum = first + second;

			pq.offer(sum);
			pq.offer(sum);
        }
			
        long totalSum = 0;
        for (long num : pq) {
				totalSum += num;
		}
        
		System.out.println(totalSum);
	}
}
