// 문제: 백준 17478번 재귀함수가 뭔가요?
// 링크: https://www.acmicpc.net/problem/17478
// 시간: 164ms

import java.io.*;

public class Main {
	static StringBuilder sb;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		br.close();

		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		WhatIs(0);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void WhatIs(int depth) {

		// 언더바 추가
		String bar = "";
		for (int i = 0; i < depth; i++)
			bar += "____";

		sb.append(bar + "\"재귀함수가 뭔가요?\"\n");

		// Base Case
		if (depth == N) {
			sb.append(bar + "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n" + bar + "라고 답변하였지.\n");
			return;
		}

		sb.append(bar + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n" + bar
				+ "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n" + bar
				+ "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
		
		WhatIs(depth += 1); // 재귀 호출
		
		sb.append(bar + "라고 답변하였지.\n");
	}
}
