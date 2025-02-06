
// 백준 1874 스택 수열 (실2) 828ms

import java.util.Scanner;
import java.util.Stack;

public class StackSequence {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 개수 입력
		int n = sc.nextInt();
		
		Stack<Integer> stack = new Stack<>();

		int num = 1;
		// StringBuilder 사용 -> 출력을 한번에 하기 위해 사용, 에러 발생 시 에러 메세지만 출력해야 함
		StringBuilder sb = new StringBuilder();
		boolean err = false;

		for (int i = 0; i < n; i++) {
			// pop 해야 하는 숫자를 입력 받음
			int current = sc.nextInt();
			// pop 해야 하는 숫자보다 작을 시에 push (+)
			while (current >= num) {
				stack.push(num++);
				sb.append("+\n");
			}
			// pop 해야 하는 숫자와 동일한 경우 pop (-)
			if (stack.peek() == current) {
				stack.pop();
				sb.append("-\n");
			} else {
				// 동일한 숫자가 나오지 않았다면
				err = true;
				// 에러 발생 시에는 굳이 끝까지 돌릴 필요 없으니까 break;
				//break;
			}
		}
		if (err) {
			System.out.println("NO");
		} else {
			System.out.println(sb);
		}
		sc.close();
	}
}