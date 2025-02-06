// 문제: 백준 11279 최대 힙
// 링크: https://www.acmicpc.net/problem/11279
// 시간: 856ms

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B11279 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();//시간초과가 있을 수 있으므로
		int n = sc.nextInt();

		PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());//힙=>PriorityQueue로 생성
        //collections.reverseOrder=>역순으로 정렬할때 쓰는 매서드

		for (int i = 0; i < n; i++) {
			int cmd = sc.nextInt();
			if (cmd == 0) {
				if (heap.isEmpty())//비어있으면
					sb.append(0).append("\n");//sb에 추가
				else
					sb.append(heap.poll()).append("\n");//힙에서 나오는 값은 최댓값(reverseorder)
			} else {
				heap.add(cmd);
			}
		}
		System.out.println(sb);

	}
}