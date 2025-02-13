// 문제: 백준 10816번 숫자 카드2
// 링크: https://www.acmicpc.net/problem/2805
// 시간: 940ms
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B10816 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		int[] checking = new int[20000001];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			int temp = Integer.parseInt(st.nextToken())+10000000;
			checking[temp]++;
		}

		int m = Integer.parseInt(br.readLine());
		StringTokenizer st1 = new StringTokenizer(br.readLine()); 
		for (int i = 0; i < m; i++) {
			int temp = Integer.parseInt(st1.nextToken())+10000000;
			sb.append(checking[temp]).append(" ");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}