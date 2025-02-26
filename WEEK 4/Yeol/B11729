// 문제: 백준 11729번 하노이 탑 이동 순서
// 링크: https://www.acmicpc.net/problem/11729
// 시간: 532ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	
	//원판을 옮기는 횟수
	static long count = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		hanoi(N, 1, 2, 3);
		
		System.out.println(count);
		
		System.out.println(sb.toString());
	}
	
	//N : 원판의 개수 / from : 첫번째 장대(처음 위치), tmp : 두번째 장대(보조 위치) / to : 세번쨰 장대(최종 위치)
	static void hanoi(int n, int from, int tmp, int to) {
		//원판이 1이면 한번에 끝
		if(n == 1) {
			//from = 1 / to = 3
			sb.append(from).append(" ").append(to).append("\n");
			count++;
			return;
		}
		
		// n-1개의 원판을 from에서 tmp로 옮긴다.
		hanoi(n - 1, from, to, tmp);
		
		// 가장 큰 원판(n)을 from에서 to로 옮긴다.
		sb.append(from).append(" ").append(to).append("\n");
        count++;
        
        // n-1개의 원판을 tmp에서 to로 옮긴다.
        hanoi(n - 1, tmp, from, to);
	}
}
