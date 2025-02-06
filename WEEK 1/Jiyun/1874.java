// 문제: 백준 1874번 스택 수열
// 링크: https://www.acmicpc.net/problem/1874
// 시간: 320ms

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		Deque<Integer> arr = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}

		Deque<Integer> stack = new ArrayDeque<>();

		int cnt = 1; // 1부터 n까지의 수열을 만들기 위한 변수
		boolean no = false; // 수열을 만들 수 없는 경우를 체크하기 위한 변수

		while (!(arr.isEmpty())) {

			// n까지 push했는데도 수열을 만들지 못하는 경우
			if (cnt > n + 1) {
				no = true;
				break;
			}

			// 스택의 맨 위 값이 수열과 같다면 제거 (pop -)
			if (!stack.isEmpty() && stack.peek().equals(arr.peek())) {
				stack.remove();
				arr.remove();
				sb.append("-\n");
			} else {
				// 스택의 맨 위 값이 수열과 다르다면 추가 (push +)
				stack.addFirst(cnt++);
				sb.append("+\n");
			}

		}

		if (no)
			System.out.println("NO");
		else
			bw.write(sb.toString());
		bw.flush();
		bw.close();

	}
}