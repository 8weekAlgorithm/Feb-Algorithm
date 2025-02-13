// 문제: 백준 1431번 시리얼 번호
// 링크: https://www.acmicpc.net/problem/1431
// 시간: 108 ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] serialNumbers = new String[N];
		
		for(int i = 0; i < N; i++) {
			serialNumbers[i] = br.readLine();
		}
		
//		Arrays.sort()의 결과는
//		음수(음수 값 리턴 시 a가 b보다 앞에 배치됨)
//		0(같으면 순서 유지)
//		양수(양수 값 리턴 시 b가 a보다 앞에 배치됨)
		
		Arrays.sort(serialNumbers, (a, b) -> {
            // 1. 길이가 짧은게 먼저
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }
            
            // 2. 숫자의 합이 작은게 먼저
            int sumA = 0, sumB = 0;
            for (char c : a.toCharArray()) {
            	//Character.isDigit()는 주어진 문자 c가 숫자인지 확인하는 메서드
                if (Character.isDigit(c)) { // 
                	sumA += c - '0';
                }
            }
            
            for (char c : b.toCharArray()) {
                if (Character.isDigit(c)) {
                	sumB += c - '0';
                }
            }
            
            if (sumA != sumB) {
                return sumA - sumB;
            }
            
            // 3. 사전순 정렬 -> Arrays.sort()와 같음
            return a.compareTo(b);
        });

        for (String serial : serialNumbers) {
            System.out.println(serial);
        }
    }
}