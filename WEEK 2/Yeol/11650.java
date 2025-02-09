// 문제: 백준 11650번 좌표 정렬하기
// 링크: https://www.acmicpc.net/problem/11650
// 시간: 720 ms

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 좌표정렬 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 좌표 개수 입력
		int N = Integer.parseInt(br.readLine());
		
		// 좌표를 저장할 리스트 생성
		List<int[]> points = new ArrayList<>();

		// 좌표를 리스트에 저장
		for (int i = 0; i < N; i++) {
			// 한 줄씩 입력받아서 공백으로 구뷴
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			// (x, y) 좌표를 배열로 만들어 리스트에 추가
			points.add(new int[] {x, y});
		}

		// 좌표 정렬
		points.sort((a, b) -> (a[0] == b[0]) ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

		// 결과 출력을 위해 StrimgBuilder 사용
		StringBuilder sb = new StringBuilder();
		for (int[] point : points) {
			sb.append(point[0] + " " + point[1] + "\n");
		}

		// 출력
		bw.write(sb.toString());
		bw.flush();

		br.close();
		bw.close();
	}
}
