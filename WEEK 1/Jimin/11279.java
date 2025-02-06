// 백준 11279번 최대 힙 (실버2)

import java.io.*;
import java.util.*;

public class MaxHeap {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// PriorityQueue는 기본적으로 작은 숫자가 먼저 나오는 최소 힙 방식
		// 만약 큰 숫자가 먼저 나오게 하고 싶다면, Collections.reverseOrder()를 사용
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i=0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x > 0) { // 만약, x가 자연수라면
				maxHeap.add(x); // 배열에 x 값 추가
			} else if (x == 0) { // 만약, x가 0이라면
				// 배열에서 가장 큰 값을 출력하고 그 값을 배열에서 제거
				bw.write(maxHeap.isEmpty() ? "0" : String.valueOf(maxHeap.poll())); 
				bw.newLine();
			}
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
