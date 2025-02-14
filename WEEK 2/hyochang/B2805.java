// 문제: 백준 2805번 나무 자르기
// 링크: https://www.acmicpc.net/problem/2805
// 시간: 940ms
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());

		int right = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, arr[i]);
		}

		Arrays.sort(arr);

		int ans = 0;
		int left = 0;
		while (left <= right) {
			int center = left + (right - left) / 2;

			long tree = 0;//21억 넘을 수도
			for (int i = 0; i < n; i++) {
				if (arr[i] - center > 0) {
					tree += arr[i] - center;
				}
			}
			if (tree >= m) {// 나무 양이 충분하면낮추고
				ans = center;
				left = center + 1;
			} else { // 나무 양이 부족하면 절단기 높이를 낮춰야 함
				right = center - 1;
			}
		}
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
	}
}
