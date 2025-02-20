// 문제: [이분탐색-응용1] 백준 10816번 숫자 카드 2 (실버4)
// 링크: https://www.acmicpc.net/problem/10816
// 시간: 1016 ms 메모리: 175576 kb

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B10816 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 숫자 카드 수 N
		int N = Integer.parseInt(br.readLine());
		
		// 완탐 -> 시간 초과, 해결법으로 HashMap 사용
		HashMap<Integer, Integer> map = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			// getOrDefault -> 찾는키가 존재하면 해당 키의 value 반환, 존재하지 않으면 0을 반환
			map.put(num, map.getOrDefault(num, 0)+1);
		}
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());
			bw.write(map.getOrDefault(num, 0) + " ");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}