// 문제: 백준 28075번 스파이
// 링크: https://www.acmicpc.net/problem/28075
// 시간: X
// 못풀었지만 코드 공유(지피티 참조)

import java.io.*;
import java.util.*;

public class B28075 {
    static int n, m;
    static int[] arr;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[6];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 3; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        combination(0, 0, n);

        sb.append(count);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void combination(int index, int sum, int remaining) {
        if (remaining == 0) {
            if (sum >= m) {
                count++;
            }
            return;
        }

        for (int i = index; i < arr.length; i++) {
            int value = arr[i];

            // 🎯 1️⃣ 원래 값을 그대로 선택하는 경우
            combination(i, sum + value, remaining - 1);

            // 🎯 2️⃣ 값을 반으로 줄여서 다시 선택하는 경우 (가능할 때만)
            while (value / 2 >= 1) {
                value /= 2;
                combination(i, sum + value, remaining - 1);
            }
        }
    }
}
