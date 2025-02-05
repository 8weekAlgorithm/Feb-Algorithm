// 문제: 백준 15903번 카드 합체 놀이
// 링크: https://www.acmicpc.net/problem/15903
// 시간: 000ms--실패

import java.util.PriorityQueue;
import java.util.Scanner;

public class B15903 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        PriorityQueue<Integer> card = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            card.add(sc.nextInt());
        }
        int[] list = new int[n];
        for (int i = 0; i < m; i++) {
            int t1 = card.poll();
            int t2 = card.poll();
            int t3 = t1 + t2;
            card.add(t3);
            card.add(t3);
        }
        int ans = 0;
        while (!card.isEmpty()) {
            ans += card.poll();
        }
        System.out.println(ans);
    }
}