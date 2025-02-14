// 문제: 백준 11279번 문제제목
// 링크: https://www.acmicpc.net/problem/11279
// 시간: 864ms

import java.io.*;
import java.util.*;

public class Main {
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
}