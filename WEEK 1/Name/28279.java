// 문제: 백준 28279번 덱 2
// 링크: https://www.acmicpc.net/problem/28279
// 시간: 1332ms

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // Deque 만들기
        Deque<Integer> deque = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] command = br.readLine().split(" ");

            switch (command[0]) {
                // 맨 앞 X 삽입
                case "1":
                    deque.offerFirst(Integer.parseInt(command[1]));
                    break;
                // 맨 뒤 X 삽입
                case "2":
                    deque.offerLast(Integer.parseInt(command[1]));
                    break;
                // 맨 앞 삭제 및 출력
                case "3":
                	if (deque.isEmpty()) {
                		bw.write("-1\n");
                	} else {
                		bw.write(deque.pollFirst() + "\n");
                	}
                    break;
                // 맨 뒤 삭제 및 출력
                case "4":
                    if (deque.isEmpty()) {
                    	bw.write("-1\n");
                    } else {
                    	bw.write(deque.pollLast() + "\n");
                    }
                    break;
                // 정수 개수 출력
                case "5":
                    bw.write(deque.size() + "\n");
                    break;
                // 비어있는지 확인
                case "6":
                	if (deque.isEmpty()) {
                		bw.write("1\n");
                	} else {
                		bw.write("0\n");
                	}
                    break;
                // 맨 앞 출력
                case "7":
                	if (deque.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.peekFirst() + "\n");
                    }
                    break;
                // 맨 뒤 출력
                case "8":
                	if (deque.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.peekLast() + "\n");
                    }
                    break;
            }
        }

        // 출력 후 flush() 및 close()
        bw.flush();
        bw.close();
        br.close();
    }
}
