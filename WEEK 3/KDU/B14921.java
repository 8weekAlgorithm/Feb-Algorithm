// 문제: 백준 14921번 용액 합성하기
// 링크: https://www.acmicpc.net/problem/14921
// 시간: 296ms

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B14921 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// left 포인트, right 포인트 초기화 설정
		int left = 0;
		int right = n - 1;
		/* min : 0에 가까운 절댓값을 찾고 최소값을 갱신하는 변수
		 * sum : 두 용액을 합친 값을 저장하는 변수
		 * ans : 최소값을 찾았을 때 0에 가까운 값을 저장하는 변수 
		 * */
		int min = Integer.MAX_VALUE;
		int sum = 0;
		int ans = 0;

		
		while (left<right) {
			sum = arr[left] + arr[right];
			if (sum > 0) { //sum이 기준값인 0보다 크므로 right를 감소시켜줘야됨
				right--;
			}else if (sum<0) { //sum이 기준값인 0보다 작으므로 left를 증가시켜줘야됨
				left++;
			}else {
				// sum이 0인 경우 결과값에 0을 저장함
				ans = sum;
				break;
			}
			/* 처음에는 단순히 Math.min을 이용하여 최솟값을 갱신했으나,
			 * 이렇게 되면 결과값에 절대값만 출력이 가능하고 절대값을 씌우기 전
			 * 원본 값을 저장하기 위해서 직접 최솟값을 갱신함
			 * */
//			min = Math.min(Math.abs(sum), min);
			if (min > Math.abs(sum)) {
				min = Math.abs(sum);
				ans = sum;
			}
		}
		
		sb.append(ans);
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
		br.close();

	}

}
