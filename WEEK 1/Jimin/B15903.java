
// 백준 15903 카드 합체 놀이 (실1) 284ms

import java.util.PriorityQueue;
import java.util.Scanner;

public class CardCombine {
	public static void main(String[] args) {
		
		// bufferdReader 쓰면 더 빠를 수 있긴 한데 귀찮아서 Scanner 씀
		Scanner sc = new Scanner(System.in);

		// 카드의 개수 
		int n = sc.nextInt();
		// 카드 합체 횟수
		int m = sc.nextInt();
		// 카드 수 합계
		long sum = 0;
		
		// * 숫자가 매우 크므로 long 타입으로 ! <- int 타입으로 해서 실패함 ...
		PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
		
		// 카드를 우선순위 큐에 하나씩 넣기
		for(int i = 0; i < n; i++) {
			priorityQueue.add(sc.nextLong());
		}
		
		// 카드 합체 횟수만큼 for 문 돌리기 -> 젤 작은 두 수를 꺼내서 더한 다음에 다시 add
		for(int i = 0; i < m; i++) {
			long card1 = priorityQueue.poll();
			long card2 = priorityQueue.poll();
			priorityQueue.add(card1+card2);
			priorityQueue.add(card1+card2);
		}
		
		// 카드 합체 후 모두 꺼내면서 수를 전부 더해주기
		while (!priorityQueue.isEmpty()) {
			sum += priorityQueue.poll();
		}
		
		// 수 합계 출력
		System.out.println(sum);
		sc.close();
	}
}