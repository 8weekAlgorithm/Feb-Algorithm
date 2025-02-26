/**
 * 문제 : 백준 28075번 스파이
 * 링크 : https://www.acmicpc.net/problem/28075
 * 시간 : 124ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b28075 {
    static int M;
    static int cnt;
    static int day;
    static int[] info;
    static int[] monitor;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 임무를 수행하는 총 일수
        M = Integer.parseInt(st.nextToken()); // 얻고싶은 최소 기여도
        day = N;
        cnt = 0;
        st = new StringTokenizer(br.readLine());
        // 정보 수집 진척도 (0 : 수족관, 1:시청, 2:학교)
        info = new int[3];
        for (int i = 0; i < 3; i++) {
            info[i] = Integer.parseInt(st.nextToken());
        }
        // 감시 진척도 (0 : 수족관, 1:시청, 2:학교)
        monitor = new int[3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            monitor[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 3; i++) {
            spy(1, info[i], i);
            spy(1, monitor[i], i);
        }

        System.out.println(cnt);

    }

    static void spy(int N, int sum, int idx) {

        if (N == day) {
            if (sum >= M) {
                cnt++;
            }
            return;
        }
        if (N < day) {
            for (int i = 0; i < 3; i++) {

                int newSum = sum;
                if (i == idx) {
                    newSum += info[i] / 2;
                } else {
                    newSum += info[i];
                }
                spy(N + 1, newSum, i);

                newSum = sum;
                if (i == idx) {
                    newSum += monitor[i] / 2;
                } else {
                    newSum += monitor[i];
                }
                spy(N + 1, newSum, i);

            }
        }
    }

}
