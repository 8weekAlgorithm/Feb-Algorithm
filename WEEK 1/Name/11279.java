// 문제: 백준 11279번 최대 힙
// 링크: https://www.acmicpc.net/problem/11279
// 시간: 324ms

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 연산 개수 N 입력
        int N = Integer.parseInt(br.readLine());

        // 최대 힙 만들기
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            // 연산 정보 x 입력
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (maxHeap.isEmpty()) {
                    // 힙이 비었으면 0 출력
                    bw.write("0\n");
                } else {
                    // 가장 큰 값 꺼내서 출력
                    bw.write(maxHeap.poll() + "\n");
                }
            } else {
                // 힙에 x 추가
                maxHeap.offer(x);
            }
        }

        // 출력 후 flush() 및 close()
        bw.flush();
        bw.close();
        br.close();
    }
}

