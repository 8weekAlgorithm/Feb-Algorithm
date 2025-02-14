// 문제: 백준 2012번 등수 매기기
// 링크: https://www.acmicpc.net/problem/2012
// 시간: 744 ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 인원수 N
		int N = Integer.parseInt(br.readLine());
		// 기대 등수를 저장할 배열 선언
		int[] expectRank = new int[N];
		// 배열에 저장
		for (int i = 0; i < N; i++) {
			expectRank[i] = Integer.parseInt(br.readLine());
		}

//		그리디 알고리즘?
//		정렬하지 않고 임의로 배정하면 예상 등수와 실제 등수의 차이가 커질 가능성이 높음.
//		하지만 정렬 후 차례대로 배정하면 각 학생이 받을 수 있는 등수 중 가장 가까운 것을 배정할 수 있어서 최소가 됨.
		//정렬 -> 실제 등수
		Arrays.sort(expectRank);
		
		// 불만도의 합 -> int는 안됨..
		long unhappySum = 0;
		//불만도의 합
		for (int i = 0; i < N; i++) {
			// |기대 등수와 실제 등수의 차이| -> 실제 등수는 i+1
			unhappySum += Math.abs(expectRank[i] - (i + 1));
		}
		System.out.println(unhappySum);

		
	}
}
