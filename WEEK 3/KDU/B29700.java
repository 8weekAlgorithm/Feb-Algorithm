// 문제: 백준 29700번 우당탕탕 영화예매
// 링크: https://www.acmicpc.net/problem/29700
// 시간: 616ms

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B29700 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int count = 0;
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			//한 라인당 line으로 받음
			char[] line = s.toCharArray();
			for (int j = 0; j < m-k+1; j++) { // 슬라이딩 윈도우가 최대로 이동할 수 있는 거리만큼 반복
				// char 배열에 저장된 값들 중 cutting해서 String 변수에 집어넣어줌
				// j부터 j+k까지 가져와야 k만큼의 숫자를 차례대로 받을 수 있음
				String part = new String(Arrays.copyOfRange(line, j, j+k));
				// 전부 0인 경우 count 증가
				if (!part.contains("1")) {
					count++;
				}
			}
		}
		sb.append(count);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}

}
