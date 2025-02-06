// 문제: 백준 1715번 문제제목
// 링크: https://www.acmicpc.net/problem/1715
// 시간: 852ms

import java.util.PriorityQueue;
import java.util.Scanner;

public class solution5 {

    public static void main(String[] args) {
        PriorityQueue<Long> pq = new PriorityQueue<>();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] sum = new long[n-1];
        long res = 0;

        for (int i = 0; i < n; i++) {
            pq.offer(sc.nextLong());
        }
        
//        System.out.println(pq);
        
        // 카드를 합치는 횟수는 카드개수-1임
        // 가장 우선순위가 작은 카드 2개를 빼서 더하고 다시 집어넣어줌
        for (int i = 0; i < n - 1; i++) {
            long a = pq.poll();
            long b = pq.poll();
            sum[i] = a+b;
            pq.offer(a+b);
        }
        
        for (long l : sum) {
            res += l;
        }
        System.out.println(res);
    }

}