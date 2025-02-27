// 문제: 백준 4779번 칸토어 집합
// 링크: https://www.acmicpc.net/problem/4779
// 시간: 272ms

import java.io.*;

public class Main {
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		String line;
		while ((line = br.readLine()) != null) {
			int N = Integer.parseInt(line);

			if (N == 0) {
				sb.append("-");
			} else {
				sb.append("-");
				Cantor(N);
			}
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void Cantor(int n) {
		// 미안한데 나도 코드 이해못함 ㄹㅇ로
		// 그냥 재귀 위치 막 바꾸다보니 됐음
		
		// Base Case
		if (n == 0)
			return;
		
		int length = (int) Math.pow(3, n-1);

		Cantor(n - 1); // 재귀 호출

		for (int i = 0; i < length; i++)
			sb.append(" ");
		sb.append("-");

		Cantor(n - 1);
	}
}
