// 문제: 백준 29700 우당탕탕 영화예매 (실버4)
// 링크: https://www.acmicpc.net/problem/29700
// 시간: 308 ms, 메모리: 28252 kb

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B29700 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		String[] arr = new String[N];
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine();
		}
		
		// Sliding Window
		
		int count = 0;
		int sum;
		
		for(String str : arr) {
			sum = 0; // 줄마다 sum 초기화 필수 ! (이 코드 작성 안해서 자꾸 답이 틀리게 나왔음)
			for(int i=0; i<M; i++) {
				sum += str.charAt(i) - '0';
				
				if(i == K - 1 && sum == 0) count++;
				
				if(i >= K) {
					sum -= str.charAt(i-K) - '0';
					if(sum == 0) count++;
				}
			}
		}
		
		bw.write(String.valueOf(count));
		
		br.close();
		bw.flush();
		bw.close();
	}
}
