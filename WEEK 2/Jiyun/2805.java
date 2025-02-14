// 문제: 백준 2805번 나무 자르기
// 링크: https://www.acmicpc.net/problem/2805
// 시간: 1000ms

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);

		int N = Integer.parseInt(st.nextToken());
		long target = Long.parseLong(st.nextToken());

		input = br.readLine();
		st = new StringTokenizer(input);

		int[] woods = new int[N];
		for (int i = 0; i < N; i++)
			woods[i] = Integer.parseInt(st.nextToken());

		// 풀이 시작
		Arrays.sort(woods);

		long left = 0;
        long right = woods[woods.length - 1];
        long answer = 0;

        // 이분 탐색
        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = cutting(woods, mid);

            if (sum >= target) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
	}

    // 잘랐을 때 얻을 수 있는 나무의 합
	static long cutting(int[] woods, long height) {
		long sum = 0;
		for (int w : woods) {
			if (w > height)
				sum += w - height;
		}

		return sum;
	}
}