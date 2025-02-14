// 문제: 백준 15903번 문제제목
// 링크: https://www.acmicpc.net/problem/15903
// 시간: 276ms

import java.util.PriorityQueue;
import java.util.Scanner;

public class solution4 {

    public static void main(String[] args) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Scanner sc = new Scanner(System.in);
        
        // 카드의 값이 1000000까지 들어갈수 있고 합체를 15000번까지 할수 있으므로
        // res에 최대값이 150억까지 들어갈 수 있으며 이는 int 범위를 초과하므로(21억)
        // long으로 수정해줘야됨
        long res = 0;
        
        int n = sc.nextInt(); // 카드의 개수
        int m = sc.nextInt(); // 카드 합체 횟수
        
        for (int i = 0; i < n; i++) {
            pq.offer(sc.nextLong());
        }
        
        
        for (int i = 0; i < m; i++) {
            long first = pq.poll();
            long second = pq.poll();
            long sum = first + second;
            pq.offer(sum);
            pq.offer(sum);
//            System.out.println(pq);
        }
        
        while (!pq.isEmpty()) {
            res += pq.poll();
        }

        System.out.println(res);
    }
}