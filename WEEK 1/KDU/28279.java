// 문제: 백준 28279번 문제제목 : 덱 2
// 링크: https://www.acmicpc.net/problem/28279
// 시간: 000ms

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
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

		// 실패했다면 실패한 이유도 함께 적어주세요.
		//
	}
}