// 문제: 백준 10994번 별찍기 - 19
// 링크: https://www.acmicpc.net/problem/10994
// 시간: 164ms

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B10994 {

	static StringBuilder sb;
	static String[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

        /*배열의 초기값 설정
          배열은 처음에 null로 초기값이 셋팅되므로 시각화를 위하여 공백으로 초기화
          배열의 크기는 4*n-3
        */ 
		arr = new String[4 * n - 3][4 * n - 3];
		for (int i = 0; i < 4 * n - 3; i++) {
			for (int j = 0; j < 4 * n - 3; j++) {
				arr[i][j] = " ";
			}
		}
        
		/* n=1일때는 가운데 값이 별로 채워져있음
           그렇지 않은 경우에는 함수 호출
           (테두리를 줄이기 위해 이동하는 변수 start,end)
           (재귀 basecode를 위한 변수 n 설정)
        */
		
		recursion(0, 4 * n - 4, n);
		

		for (int i = 0; i < 4 * n - 3; i++) {
			for (int j = 0; j < 4 * n - 3; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}

	public static void recursion(int start, int end, int n) {
		if (n == 1) {
            // 별 그림의 정 가운데 위치에 별을 찍기 위한 코드
			arr[(start+end)/2][(start+end)/2] = "*";
		} else {
            // 테두리에만 별을 찍는 행위
            // start와 end를 움직이면서 테두리를 줄임!
			for (int i = start; i <= end; i++) {
				arr[start][i] = "*"; // 상단 가로줄
				arr[end][i] = "*"; // 하단 가로줄
				arr[i][start] = "*"; // 좌측 세로줄
				arr[i][end] = "*"; // 우측 세로줄
			}
            // start+2, end-2를 통해 재귀 호출
			recursion(start + 2, end - 2, n - 1);
		}
	}

}
