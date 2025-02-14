/**
 * 문제 : 백준 1715번 카드 정렬하기
 * 링크 : https://www.acmicpc.net/problem/1715
 * 시간 : 328ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class PriorityQueue_1715 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Long> pq = new PriorityQueue<>();
		
		long N = Long.parseLong(br.readLine());
		
		for(int i = 0; i<N; i++) {
			long card = Long.parseLong(br.readLine());
			pq.add(card);
		}
//		System.out.println(pq.toString());
		int sum = 0;
		while(!(pq.size() == 1)) {
			long x = pq.poll();
			long y = pq.poll();
			pq.add(x+y);
			sum += (x+y);
			
		}
		System.out.println(sum);
		
		
	}

}
