

// 백준 1966 프린터 큐 (실3) 252ms

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class PrinterQueue {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// Test case
		int T = sc.nextInt();
		
		for(int test_case = 0; test_case < T; test_case++) {
			int N = sc.nextInt(); // 문서의 개수
			int M = sc.nextInt(); // 인쇄할 문서의 index
			boolean check = true;
			// 인쇄 순서 count 
			int count = 0;
			
			Queue<Integer> queue = new LinkedList<>();
			PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
			
			// 데이터 추가
			for(int i = 0; i < N; i++) {
				int num = sc.nextInt();
				queue.add(num);
				priorityQueue.add(num);
			}
			
			while(check) {
				int maxNum = priorityQueue.peek(); // 중요도 가장 높은 수
				int current = queue.peek(); // 현재 맨 앞의 수
				
				if (current == maxNum) { // 현재 맨 앞의 수가 중요도가 가장 큰 수 일 때
					priorityQueue.poll();
					queue.poll(); // 인쇄
					count++;
					
					if (M == 0) { // 중요도가 가장 큰 수가 맨 앞에 있을 때
						System.out.println(count); // 순서를 출력
						check = false; // while 문 빠져나옴
					} else {
						M--; // 아닌 경우 index-1
					}
				} else { // 중요도가 큰 수가 맨 앞에 없는 경우
					queue.add(queue.poll()); // 앞의 수를 뒤에 다시 추가
					if(M == 0) { // 만약 출력해야 하는 인덱스가 맨 앞인 경우
						M = priorityQueue.size() - 1; // 인덱스 수를 맨 뒤로 변경
					} else {
						M--; // 아닌 경우 index-1
					}
				}
				
			}
			
		}
		sc.close();
	}
}