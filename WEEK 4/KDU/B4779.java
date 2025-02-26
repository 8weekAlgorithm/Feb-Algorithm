// 문제: 백준 4779번 칸토어 집합
// 링크: https://www.acmicpc.net/problem/4779
// 시간: 304ms

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B4779 {

	static String[] str;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String input;

        /* 이 문제의 경우 공백이 나오기 전까지 계속해서 입력값을 받으므로
         * br.readline()에 null이 나오기 전까지 while문으로 계속해서 입력값을 받아야됨*/
		while ((input = br.readLine()) != null && !input.isEmpty()) {
			int n = Integer.parseInt(input);

			str = new String[(int) Math.pow(3, n)];

			for (int i = 0; i < str.length; i++) {
				str[i] = "-";
			}

            //입력값의 3^n만큼 함수에 넣어줌
			cantor(0, (int) Math.pow(3, n));

			for (String string : str) {
				sb.append(string);
			}sb.append("\n");
			
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static void cantor(int n, int m) {
		if (m - n == 1) {
			return;
		}
        // 재귀를 돌리는 구간
        // 시작지점인 0부터 3^n까지 값을 받고 구간을 3군데로 나누어 처리한다.
        // 1. n ~ n + (m - n) / 3 : 0부터 문자열의 1/3지점까지 진행
        // 2. n + (m - n) * 2 / 3 ~ m : 문자열의 2/3지점부터 끝까지 진행
        // 3. n + (m - n) / 3 ~ n + (m - n) * 2 / 3 : 문자열의 1/3지점부터 문자열의 2/3지점까지는 삭제 진행
		cantor(n, n + (m - n) / 3)행
		cantor(n + (m - n) * 2 / 3, m);
		remove(str, n + (m - n) / 3, n + (m - n) * 2 / 3);
	}

    // 가운데 문자열을 공백으로 만드는 함수
    // 시작점과 끝지점을 입력값으로 받아서 공백으로 만들어줌
	public static void remove(String[] str, int start, int end) {
		for (int i = start; i < end; i++) {
			str[i] = " ";
		}
	}

}
