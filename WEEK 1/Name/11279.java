// 문제: 백준 11279번 최대 힙
// 링크: https://www.acmicpc.net/problem/11279
// 시간: 852ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				if (maxHeap.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(maxHeap.peek());
					maxHeap.remove();

				}
			} else {
				maxHeap.add(num);
			}
		}
	}
}