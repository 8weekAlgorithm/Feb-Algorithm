// 문제: 백준 2417번 정수 제곱근
// 링크: https://www.acmicpc.net/problem/2417
// 시간: X - 오답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 정수제곱근 {
	public static void main(String[] args) throws NumberFormatException, IOException {
        // BufferedReader 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        long n = Long.parseLong(br.readLine());

        // 이분 탐색을 위한 초기 설정
        long left = 0;
        long right = n;
        
        // 이분 탐색
        while (left <= right) {
            long mid = (left + right) / 2;
            if (mid * mid > n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
        
        br.close();

    }
}


