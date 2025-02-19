/**
 * 백준 : 문제 12891번 DNA 비밀번호
 * 링크 : https://www.acmicpc.net/problem/12891
 * 시간 : 288ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b12891 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		String dna = br.readLine();
		

		st = new StringTokenizer(br.readLine());
		int[] min = new int[4];
		for(int i = 0; i<4; i++) { // 0:'A'  1:'C'  2:'G',  3:'T'
			min[i] = Integer.parseInt(st.nextToken());
		}

		int[] count = new int[4];
		int sum = 0;
		for(int i = 0; i<S; i++) {
			countNum(count, dna.charAt(i));

			if(i>=P) {
				minus(count, dna.charAt(i-P));
			}
			
			if(i>=P-1&&condi(count, min)) {
				sum++;
			}
			
		}
		System.out.println(sum);
	}
	
	static  int[] countNum(int[] count, char a) {
		if(a=='A') {
			count[0]++;
		}
		if(a=='C') {
			count[1]++;
		}
		if(a=='G') {
			count[2]++;
		}
		if(a=='T') {
			count[3]++;
		}
		
		return count;
	}
	
	static boolean condi(int[] count, int[] min) {
		if(count[0]>=min[0] && count[1]>=min[1] && count[2]>=min[2] && count[3]>=min[3]) {
			return true;
		}
		return false;
	}
	
	static int[] minus(int[] count, char a) {
		if(a=='A') {
			count[0]--;
		}
		if(a=='C') {
			count[1]--;
		}
		if(a=='G') {
			count[2]--;
		}
		if(a=='T') {
			count[3]--;
		}
		
		return count;
	}

}
