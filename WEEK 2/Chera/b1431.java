/**
 * 문제 : 백준 1431 시리얼 번호
 * 링크 : https://www.acmicpc.net/problem/1431
 * 시간 : 104ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class b1431 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String[] serial = new String[N]; 
		for(int i = 0; i<N; i++) {
			serial[i] = br.readLine();
		}
		
		Arrays.sort(serial, new Comparator<String>() {
		    public int compare(String o1, String o2) {
		        if (o1.length() != o2.length()) {
		            return o1.length() - o2.length(); // 길이 비교
		        }
		        
		        int num1 = findNum(o1); 
		        int num2 = findNum(o2);
		        
		        if (num1 != num2) {
		            return num1 - num2; // 숫자 비교
		        }
		        
		        return o1.compareTo(o2); // 사전순 비교
		    }
		});
		for(int i = 0; i<serial.length; i++) {
			System.out.println(serial[i]);
		}
		
	}
	
	static int findNum(String str) {
		int sum = 0;
		char[] num = str.toCharArray();
		for(int i = 0; i<num.length; i++) {
			boolean ok = true;
			if((int) num[i] >= 65){
				ok = false;
			}
			if(ok) {
				sum+= num[i]-'0'; // num[i] : char형, '0' : 48 || 0을 빼줘서 정수로 만들기
			}
		}
		
		return sum;
	}

}
