/**
 * 문제 : 백준 15903번 카드 합체 놀이
 * 링크 : https://www.acmicpc.net/problem/15903
 * 시간 : 148ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PriorityQueue_15903 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		PriorityQueue<Long> qu = new PriorityQueue<Long>();

		int card_cnt = Integer.parseInt(st.nextToken());
		int merge_cnt = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < card_cnt; i++) {
			qu.add(Long.parseLong(st.nextToken()));
		}
		// m번 합치기
		for (int m = 0; m < merge_cnt; m++) {
			long x = qu.poll();
			long y = qu.poll();
			qu.add(x+y);
			qu.add(x+y);
		}
		long res = 0;
		while (!(qu.isEmpty())) {
			res += qu.poll();
		}
		System.out.println(res);

	}

}
