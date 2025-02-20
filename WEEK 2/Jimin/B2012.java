// 문제: [정렬-응용2] 백준 2012번 등수 매기기 (실버3)
// 링크: https://www.acmicpc.net/problem/2012
// 시간: 820 ms 메모리: 60852 kb

package Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2012 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		// 각 사람의 예상 등수 입력
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		// 불만도의 합 -> int로 했다가 틀림 . .
		long sum = 0;
		
		for(int i=1; i<=N; i++) {
			sum += Math.abs(arr[i-1] - i);
		}
		
		System.out.println(sum);
		
		br.close();
	}
}
