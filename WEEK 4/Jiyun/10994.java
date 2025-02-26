// 문제: 백준 10994번 별 찍기 - 19
// 링크: https://www.acmicpc.net/problem/10994
// 시간: 140ms

import java.io.*;
import java.util.*;

public class Main {
	static int INPUT, N;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		INPUT = Integer.parseInt(br.readLine());
		br.close();
		
		N = (INPUT - 1) * 4 + 1;
		map = new char[N][N];
		for (char[] m : map)
			Arrays.fill(m, ' ');

		star(0, N - 1);

		for (char[] m : map) {
			for (char c : m)
				sb.append(c);
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void star(int min, int max) {
		
		if (min > max)
			return;

		for (int i = min; i <= max; i++) {
			map[min][i] = '*';
			map[max][i] = '*';

			map[i][min] = '*';
			map[i][max] = '*';
		}

		star(min + 2, max - 2);
	}
}