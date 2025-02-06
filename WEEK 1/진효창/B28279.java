// 문제: 백준 28279 덱 2
// 링크: https://www.acmicpc.net/problem/28279
// 시간: 2232ms

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class B28279{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();//시간초과 문제로 한번에 출력하는 stringbulider사용
		int n = sc.nextInt();
		sc.nextLine();//개행처리
		
		Deque<Integer> deque = new LinkedList<Integer>();//deque 생성
		for(int i=0;i<n;i++) {
			String str = sc.nextLine();
			String[] arr = str.split(" ");//공백으로 분리
			int a = Integer.parseInt(arr[0]);//명령어
			switch (a) {
			case 1:
				int num = Integer.parseInt(arr[1]);//숫자변환
				deque.addFirst(num);//앞에 추가
				break;
			case 2:
				int b_num = Integer.parseInt(arr[1]);
				deque.addLast(b_num);//뒤에추가
				break;
			case 3:
				if(deque.isEmpty()) {//비어있는지확인
					sb.append(-1).append("\n");//입력하고 이후 ENTER추가
					break;
				}else {
					sb.append(deque.pollFirst()).append("\n");//맨 앞 값
					break;
				}
			case 4:
				if(deque.isEmpty()) {
					sb.append(-1).append("\n");
					break;
				}else {
					sb.append(deque.pollLast()).append("\n");//맨 뒤 값
					break;
				}
			case 5:
				sb.append(deque.size()).append("\n");//크기
				break;
			case 6:
				if(deque.isEmpty()) {
					sb.append(1).append("\n");
					break;
				}else {
					sb.append(0).append("\n");
					break;
				}
			case 7:
				if(deque.isEmpty()) {
					sb.append(-1).append("\n");					
					break;
				}else {
					sb.append(deque.peekFirst()).append("\n");//제거 없이 앞에만 뽑아옴
					break;
				}
			case 8:
				if(deque.isEmpty()) {
					sb.append(-1).append("\n");
					break;
				}else {
					sb.append(deque.peekLast()).append("\n");//제거 없이 뒤에만뽑아옴
					break;
				}
			}
		}
		System.out.print(sb);
	}
}