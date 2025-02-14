/**
 * 문제 : 백준 1874번 스택 수열
 * 링크 : https://www.acmicpc.net/problem/1874
 * 시간 : 1308ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Stack_1874 {
	public static void main(String[] args) throws IOException {
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> stack_x = new Stack<>();
		Queue<String> qu = new ArrayDeque<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
//		System.out.println(N);
		int first = Integer.parseInt(br.readLine());
		for (int i = 1; i <= first ; i++) {
			stack.push(i);
			stack_x.push(i);
			qu.add("+");

		}
		
		stack.pop();
		qu.add("-");
//		System.out.println(qu.toString());

		for (int n = 0; n < N-1; n++) {
			int num = Integer.parseInt(br.readLine());
//			System.out.println(stack.peek());
			if (stack.isEmpty() || num > stack.peek()) {
				for (int i = stack_x.peek()+1; i <=num; i++) {
					stack.push(i);
					stack_x.push(i);
					qu.add("+");
				}
				stack.pop();
				qu.add("-");
			}else if(num==stack.peek()){
				stack.pop();
				qu.add("-");
			}else {
				break;
			}
		}
		if(stack.isEmpty()) {
			int size = qu.size();
			for(int i = 0; i<size; i++) {
				System.out.println(qu.poll());
			}
		}else {
			System.out.println("NO");
		}
		

	}

}
