// 문제: 백준 12891번 DNA 비밀번호
// 링크: https://www.acmicpc.net/problem/12891
// 시간: 584ms

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		String input = br.readLine();
		char[] str = input.toCharArray();

		Map<Character, Integer> count = new HashMap<>();
		count.put('A', 0);
		count.put('C', 0);
		count.put('G', 0);
		count.put('T', 0);

		Map<Character, Integer> map = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		map.put('A', Integer.parseInt(st.nextToken()));
		map.put('C', Integer.parseInt(st.nextToken()));
		map.put('G', Integer.parseInt(st.nextToken()));
		map.put('T', Integer.parseInt(st.nextToken()));

		int left = 0 - P;
		int right = 0;
		count.replace(str[right], count.get(str[right]) + 1);

		int answer = 0;
		while (right < S) {
			left++;
			if ((count.get('A') >= map.get('A')) && (count.get('C') >= map.get('C')) && (count.get('G') >= map.get('G'))
					&& (count.get('T') >= map.get('T')) && left >= 0 && right < S) {
				answer++;
			}
			
			right++;
			if (right >= S)
				break;
			count.replace(str[right], count.get(str[right]) + 1);
			if (left < 0)
				continue;
			count.replace(str[left], count.get(str[left]) - 1);
		}

		System.out.println(answer);
	}
}
