// 문제: 백준 28279번 덱2
// 링크: https://www.acmicpc.net/problem/28279
// 시간: 4440ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

			if (command == 1) {
				deque.addFirst(Integer.parseInt(st.nextToken()));
			} else if (command == 2) {
				deque.addLast(Integer.parseInt(st.nextToken()));
			} else if (command == 3) {
				if (deque.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(deque.getFirst());
					deque.removeFirst();
				}
			} else if (command == 4) {
				if (deque.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(deque.getLast());
					deque.removeLast();
				}
			} else if (command == 5) {
				System.out.println(deque.size());
			} else if (command == 6) {
				if (deque.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			} else if (command == 7) {
				if (deque.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(deque.getFirst());
				}
			} else {
				if (deque.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(deque.getLast());
				}
			}
		}
	}

}
