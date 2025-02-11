// 문제: 백준 2012번 등수 매기기
// 링크: https://www.acmicpc.net/problem/2012
// 시간: 768ms

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] exp = new int[N];
		for (int i = 0; i < N; i++)
			exp[i] = Integer.parseInt(br.readLine());

		Arrays.sort(exp);

		int rank = 1;
		long answer = 0;
		for (int e : exp) {
			if (rank != e) {
				answer += rank > e ? rank - e : e - rank;
			}
			rank++;
		}
		
		System.out.println(answer);
	}
}