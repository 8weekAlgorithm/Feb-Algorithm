// 문제: 백준 12847번 꿀 아르바이트
// 링크: https://www.acmicpc.net/problem/12847
// 시간: 268ms

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B12847 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//
		
		long sum = 0; // 일급을 저장하는 변수
		
		int start = 0; // 시작점 포인터 변수
		int end = m-1; // 끝점 포인터 변수(일을 할 수 있는 날로 기준)
		
		// 슬라이딩 윈도우를 위한 초기값 셋팅
		for (int i = 0; i < m; i++) {
			sum += arr[i];
		}
		// max의 초기값을 초기 sum 값으로 설정함
		// why? -> 만약 이렇게 초기화를 해주지 않으면 가장 초기값이 max인 경우 찾지 못하게 됨!
		long max = sum;
		
		// end가 n-2까지 이동할때까지 반복(슬라이딩 윈도우)
		while (end<n-1) {
			// start 포인터 오른쪽 이동 후 빼줌
			// start 포인터를 반영할 때는 기존 start 인덱스에 들어있는 값을 빼준다음 start를 변경해야 됨
			sum -= arr[start++];
			
			// end 포인터 오른쪽 이동 후 더해줌
			// end 포인터를 반영할 때는 end를 먼저 변경하고 그에 해당하는 인덱스 값을 더해줘야됨
			sum += arr[++end];
			max = Math.max(sum, max); // 최대값 갱신
		}
		sb.append(max);
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
		br.close();
	}

}
