// 문제: 백준 1874번 스택수열
// 링크: https://www.acmicpc.net/problem/1874
// 시간: 856ms

import java.util.Scanner;
import java.util.Stack;

public class B1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();//출력목록이 담긴 배열
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        int current = 1; //스택에 넣을 함수
        for (int num : arr) {
            while (current <= num) {//해당 수보다 작거나 같을때까지 스택에 넣음
                stack.push(current++);
                result.append("+\n");//넣을때마다 +와 엔터키 추가
            }

            if (stack.peek() == num) {//stack에서 제일 위의 값이 배열에 있는 수와 같아지면 pop
                stack.pop();
                result.append("-\n");//빼면 -와 엔터키 추가
            } else {//수보다 작거나 같은 경우가 아니다=>더이상 스택에 수를 넣을수도 뺄수도 없는 상황
                System.out.println("NO");
                return;//if문 종료
            }
        }

        System.out.println(result);
    }
}