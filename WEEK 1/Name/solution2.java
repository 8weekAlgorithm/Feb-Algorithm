// 문제: 백준 89828번 문제제목
// 링크: https://www.acmicpc.net/problem/11279
// 시간: 864ms

import java.io.*;
import java.util.*;

public class solution2 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < N; i++) {
			int com = sc.nextInt();
			if (com > 0) {
				pq.add(com);
			} else if (com == 0) {
				Integer out = pq.poll();
				sb.append(out == null ? 0 : out).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	/* 문제 분석
	 * 최대 힙 -> 우선순위 큐 사용하되 Collections.reverseOrder로 최소 힙을 최대 힙으로 바꿔줘야 됨
	*/
}