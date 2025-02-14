// 문제: 백준 1966번 문제제목
// 링크: https://www.acmicpc.net/problem/1966
// 시간: 000ms

import java.util.*;

public class solution6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int T = sc.nextInt();
        for (int tc = 0; tc < 1; tc++) {
            Deque<int[]> q = new ArrayDeque<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            int n = sc.nextInt();
            int m = sc.nextInt();
            int count = 0;
            for (int i = 0; i < n; i++) {
                int priority = sc.nextInt();
                q.offer(new int[] {i,priority});
                pq.offer(priority);
            }
            while (!q.isEmpty()) {
                int[] current = q.poll();
                int index = current[0];
                int priority = current[1];
                
                if(priority == pq.peek()) {
                    count++;
                    pq.poll();
                    if(index == m) {
                        System.out.println(count);
                        break;
                    }
                }
                else {
                    q.offer(current);
                }
            }

        }
        sc.close();
    }

}