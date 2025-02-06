/**
 * 문제 : 백준 1966번 프린터 큐
 * 링크 : https://www.acmicpc.net/problem/1966
 * 시간 : 128ms
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Queue_1966 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			//중요도 내림차순 정렬 큐
			PriorityQueue<Integer> numQu_sort = new PriorityQueue<>(Collections.reverseOrder());
			//중요도 큐
			Deque<Integer> numQu = new ArrayDeque<>();
			// 문서 큐
			Deque<Integer> docQu = new ArrayDeque<>();

			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// 문서의 개수
			int N = Integer.parseInt(st.nextToken());
			// 궁금한 문서 위치
			int M = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			// 중요도를 중요도큐에 추가
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				numQu.add(Integer.parseInt(st.nextToken()));
				arr[i] = numQu.getLast();
			}
			for (int i : numQu) {
				numQu_sort.add(i);
			}

			// 문서 큐 생성
			for (int i = 0; i < N; i++) {
				docQu.addLast(i);
			}
			// 궁금한 문서의 중요도 반환
			int target = arr[M];

			int cnt = 0;
			// 궁금한 문서가 제일 앞으로 올때까지 (-> 문서의 번호가 제일 앞에 있고, 중요도도 제일 앞에 있을 때까지)
			while (!(docQu.peek() == M && numQu_sort.peek() == target)) {
//				System.out.println("현재 문서: " + docQu.peek() + ", 현재 중요도: " + numQu.peek());
				// if(현재 문서의 중요도가 가장 높지 않을때) else()
				if (!(numQu.peek() == numQu_sort.peek())) {
					int x = numQu.poll();
					int y = docQu.poll();
					numQu.addLast(x);
					docQu.addLast(y);
//					System.out.println(docQu.toString());
				} else {
					numQu.poll();
					docQu.poll();
					numQu_sort.poll();
					cnt++;
				}

			}
			System.out.println(cnt + 1);

		}
	}

}
