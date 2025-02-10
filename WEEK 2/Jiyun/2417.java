// 문제: 백준 2417번 정수 제곱근
// 링크: https://www.acmicpc.net/problem/2417
// 시간: 104ms

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());

		long left = 0;
		long right = n;
		long mid;

		while (left < right) {
			mid = (left + right) / 2;

			if (Math.pow(mid, 2) >= n) {
				right = mid;
			} else {
				left = mid + 1;
			}

		}

		System.out.println(left);
	}
}
