/**
 * 문제 : 백준 정수 제곱근 2417번
 * 링크 : https://www.acmicpc.net/problem/2417
 * 시간 : 104ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class b2417 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long N = Long.parseLong(br.readLine());
		
		long left = 0;
		long right = N;
		
		while (left < right) {
			long mid = (left + right)/2;
			if(Math.pow(mid, 2) >= N) {
				right = mid;
			}else {
				left = mid+1;
			}
			
		}
		
		bw.write(String.valueOf(left));
		bw.flush();
		bw.close();
		
	}

}
