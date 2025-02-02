// 문제: 백준 28279번 문제제목 : 덱 2
// 링크: https://www.acmicpc.net/problem/28279
// 시간: 1000ms

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class solution1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		
		int N = Integer.parseInt(br.readLine()); // 첫 번째 입력: 명령 개수

		for (int i = 0; i < N; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int com = Integer.parseInt(st.nextToken());

			switch (com) {
			// 1 X: 정수 X를 덱의 앞에 넣는다.
			case 1:
				dq.addFirst(Integer.parseInt(st.nextToken()));
				break;
				
			// 2 X: 정수 X를 덱의 뒤에 넣는다.
			case 2:
				dq.addLast(Integer.parseInt(st.nextToken()));
				break;

			// 3: 덱에 정수가 있다면 맨 앞의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
			case 3:
				if (!(dq.isEmpty())) {
					sb.append(dq.pollFirst()).append("\n");
				} else
					sb.append(-1).append("\n");
				break;

			// 4: 덱에 정수가 있다면 맨 뒤의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
			case 4:
				if (!(dq.isEmpty())) {
					sb.append(dq.pollLast()).append("\n");
				} else
					sb.append(-1).append("\n");
				break;

			// 5: 덱에 들어있는 정수의 개수를 출력한다.
			case 5:
				sb.append(dq.size()).append("\n");
				break;

			// 6: 덱이 비어있으면 1, 아니면 0을 출력한다.
			case 6:
				if (dq.isEmpty()) {
					sb.append(1).append("\n");
				} else
					sb.append(0).append("\n");
				break;

			// 7: 덱에 정수가 있다면 맨 앞의 정수를 출력한다. 없다면 -1을 대신 출력한다.
			case 7:
				if (!(dq.isEmpty())) {
					sb.append(dq.peekFirst()).append("\n");
				} else
					sb.append(-1).append("\n");
				break;

			// 8: 덱에 정수가 있다면 맨 뒤의 정수를 출력한다. 없다면 -1을 대신 출력한다.
			case 8:
				if (!(dq.isEmpty())) {
					sb.append(dq.peekLast()).append("\n");
				} else
					sb.append(-1).append("\n");
				break;
			}
			
		}
		System.out.print(sb.toString());

		/* 실패했다면 실패한 이유도 함께 적어주세요.
		 * 1차 : 문제 이해를 못함
		 * - 3,4번 명령이 맨 앞의 정수를 빼고 나머지를 출력하라는 뜻으로 이해 -> 수정 완료
		 * 
		 * 2차 : 기존 Scanner, print 사용 시 하나씩 입력을 받아 하나씩 처리하므로 시간 초과
		 * - Scanner -> BufferedReader + StringTokenizer로 변경
		 * - System.out.println() -> StringBuilder로 변경
		 * 
		 * Scanner는 한 번에 한 개의 값만 읽어와서 변환하는 형식이며, 백준 문제 제출 시 입력이
		 * 수십만 개 이상이기 때문에 속도가 느려짐
		 * BufferedReader는 한 번에 한 줄을 통째로 읽으며, StringTokenizer는 문자열을 숫자로 분리해주므로
		 * 입력 값이 한 줄에 여러 숫자로 이루어져 있고, 많은 줄로 이루어져있는 경우 효과적임
		 * (이 문제에서는 크게 상관 없을 것으로 예상)
		 * 
		 * System.out.println() 역시 Scanner와 마찬가지로 출력하는 데이터가 많아지는 경우 속도가 느려짐
		 * (호출될 때 마다 계속 실행해줘야하기 때문에)
		 * StringBuilder : 모든 결과값들을 한번에 이어서 출력해주기 때문에 성능 좋아짐
		*/
	}
}