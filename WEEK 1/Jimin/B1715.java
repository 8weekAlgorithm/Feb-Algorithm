// 백준 1715 카드 정렬하기 (골5) 884ms

import java.util.PriorityQueue;
import java.util.Scanner;

public class CardSort {
	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);

		// 카드의 개수
		int N = sc.nextInt();
		
		int count = 0;
		// 우선순위 큐 
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

		// 카드 넣기
		for (int i = 0; i < N; i++) {
			priorityQueue.add(sc.nextInt());
		}

		while (N > 1) { // while(true) 했다가 런타임 에러(NullPoint) 발생함 -> N이 2 이상이여야지 while 문을 돌 수 있음
			int card1 = priorityQueue.poll();
			int card2 = priorityQueue.poll();
			count += card1 + card2;
			
			if(priorityQueue.isEmpty()) {
				break;
			} else {
				priorityQueue.add(card1 + card2);
			}
		}
		
		System.out.println(count);
		sc.close();
	}
}