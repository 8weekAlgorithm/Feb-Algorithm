// 문제: 백준 1966번 프린터 큐
// 링크: https://www.acmicpc.net/problem/1966
// 시간: 124ms

import java.io.*;
import java.util.*;

class Paper {
	int imp;
	int order;
	
	public Paper(int importance, int order) {
		this.imp = importance;
		this.order = order;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		// 테스트케이스 만큼 실행
		for (int t = 0; t < T; t++) {
			Deque<Paper> deque = new ArrayDeque<>();
			PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
			
			// 입력 받기
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < n; i++) {
				int temp = Integer.parseInt(st.nextToken());
				deque.add(new Paper(temp, i));
				maxHeap.add(temp);
			}


			// 문제 풀이
			int print = 0;
            while (!deque.isEmpty()) {
                Paper front = deque.remove();
                
                // 중요도가 가장 높은 문서라면
                if (front.imp == maxHeap.peek()) {
                    maxHeap.poll();
                    print++;

                    if (front.order == m) { // 찾는 문서가 인쇄되면
                    	System.out.println(print);
                        break;
                    }
                } else {
                    // 아니라면
                    deque.addLast(front);
                }
            }
		}

		br.close();
	}
}