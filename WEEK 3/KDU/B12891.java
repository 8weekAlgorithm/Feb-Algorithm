// 문제: 백준 12891번 DNA 비밀번호
// 링크: https://www.acmicpc.net/problem/12891
// 시간: 292ms

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B12891 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		String string = br.readLine();
		st = new StringTokenizer(br.readLine());
		int a_count = Integer.parseInt(st.nextToken());
		int c_count = Integer.parseInt(st.nextToken());
		int g_count = Integer.parseInt(st.nextToken());
		int t_count = Integer.parseInt(st.nextToken());
		int count = 0;
		
		// start 포인터와 end 포인터 설정
		int start = 0; 
		int end = p-1; 

		int a = 0;
		int c = 0;
		int g = 0;
		int t = 0;
		/* 해당 반복문 : 슬라이딩 윈도우를 위한 초기 셋팅값 저장
		 * ※ 초기값에서도 비밀번호 조건을 갖추는 경우 카운트해줘야됨
		 * */
		for (int i = start; i <= end; i++) {
			char dna = string.charAt(i);
			if (dna == 'A') {
				a++;
			} else if (dna == 'C') {
				c++;
			} else if (dna == 'G') {
				g++;
			} else if (dna == 'T') {
				t++;
			}
		}
		// 초기값 비밀번호 조건 확인
		if (a >= a_count && c >= c_count && g >= g_count && t >= t_count) {
			count++;
		}
		
		/* start를 오른쪽으로 옮기기 전에 dna_prev에 문자 저장
		 * end는 오른쪽으로 옮긴 후 dna_next에 문자 저장
		 * start에 저장된 문자를 확인하고 그에 해당하는 문자 카운트 1 감소
		 * end에 저장된 문자를 확인하고 그에 해당하는 문자 카운트 1 증가
		 * 마지막으로 비밀번호 조건을 갖추는 경우 카운트 해주는 조건문 추가
		 * */
		while (end < s) {
			char dna_prev = string.charAt(start);
			start++;
			end++;
			//Stringoutofindex를 방지하기 위한 break
			if (end == s) {
				break;
			}
			char dna_next = string.charAt(end);
			if (dna_prev == 'A') {
				a--;
			} else if (dna_prev == 'C') {
				c--;
			} else if (dna_prev == 'G') {
				g--;
			} else if (dna_prev == 'T') {
				t--;
			}
			if (dna_next == 'A') {
				a++;
			} else if (dna_next == 'C') {
				c++;
			} else if (dna_next == 'G') {
				g++;
			} else if (dna_next == 'T') {
				t++;
			}
			if (a >= a_count && c >= c_count && g >= g_count && t >= t_count) {
				count++;
			}
		}

		sb.append(count);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}
	/* 초기 코드
	 * -> 포인터를 옮기는 while문 + 문자열을 찾는 for문
	 * 이중 for문으로 구현하였으나 시간초과 발생
	 * 수정 -> 초기값을 셋팅해놓고 슬라이딩 윈도우를 이용하여 처음 값과 끝 값만 조절함
	 * 
	 * */

}