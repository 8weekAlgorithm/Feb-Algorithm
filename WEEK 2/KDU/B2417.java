// 문제: 백준 2417번 정수 제곱근
// 링크: https://www.acmicpc.net/problem/2417
// 시간: 104ms

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 이분 탐색은 반드시 배열/리스트가 정렬되어 있어야 함!
// 헷갈릴 수 있겠지만 이런 문제들은 기본적으로 정렬된 숫자들을 통해 비교하므로 상관없음
// 1차 시도 : 문제 이해가 힘들어 인터넷의 도움을 받음..
// 2차 시도 : 초기 high값을 n으로 설정하였더니 시간제한에 걸려 실패함
// -> high의 값을 실제 찾고자하는 q값으로 설정하여 조금이라도 시간을 줄이고자 함

public class B2417 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		long n = Long.parseLong(br.readLine());

		long low = 0;
		// 계속 시간초과되서 조금이라도 덜 돌도록 high의 값을 실제 q값으로 미리 설정해놨음(제곱근+1)
		long high = (long) Math.sqrt(n) + 1;

		/* mid값을 설정하여 좌측을 low, 우측을 high로 잡고 low와 high가 같아질때까지 돌게 함
		 * 걸고자 하는 조건인 mid^2가 n보다 크거나 같으면 찾고자 하는 값이 mid보다 좌측에 있다는 말
		 * -> high의 값을 mid로 설정하여 왼쪽만 탐색하게 설정
		 * mid^2가 n보다 작으면 찾고자 하는 값이 mid보다 우측에 있다는 말
		 * -> low의 값을 mid+1로 설정
		 * */
		while (low < high) {
			long mid = (low + high) / 2;
			if (mid * mid >= n) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}

		sb.append(low);
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();

	}
}
