// 문제: 백준 12891 DNA 비밀번호 (실버2)
// 링크: https://www.acmicpc.net/problem/12891
// 시간: 288 ms, 메모리: 20448 kb

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B12891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken()); // 문자열 길이
        int P = Integer.parseInt(st.nextToken()); // 비밀번호 길이

        String str = br.readLine(); // DNA 문자열

        int[] required = new int[4]; // 필요한 ACGT 개수
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            required[i] = Integer.parseInt(st.nextToken());
        }

        // 현재 윈도우에서의 A, C, G, T 개수
        int[] count = new int[4];

        // 초기 윈도우 설정 (처음 P개의 문자를 카운트)
        for (int i = 0; i < P; i++) {
            addChar(count, str.charAt(i));
        }

        int sum = 0;
        if (isValid(required, count)) sum++;

        // 슬라이딩 윈도우 적용 (ChatGPT 활용)
        for (int i = P; i < S; i++) {
            // 윈도우의 맨 앞 문자 제거
            removeChar(count, str.charAt(i - P));
            // 윈도우의 맨 뒤 문자 추가
            addChar(count, str.charAt(i));

            if (isValid(required, count)) sum++;
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        br.close();
        bw.close();
    }

    // DNA 문자 추가
    private static void addChar(int[] count, char c) {
        switch (c) {
            case 'A': count[0]++; break;
            case 'C': count[1]++; break;
            case 'G': count[2]++; break;
            case 'T': count[3]++; break;
        }
    }

    // DNA 문자 제거
    private static void removeChar(int[] count, char c) {
        switch (c) {
            case 'A': count[0]--; break;
            case 'C': count[1]--; break;
            case 'G': count[2]--; break;
            case 'T': count[3]--; break;
        }
    }

    // 현재 부분 문자열이 조건을 만족하는지 확인
    private static boolean isValid(int[] required, int[] count) {
        for (int i = 0; i < 4; i++) {
            if (count[i] < required[i]) return false;
        }
        return true;
    }
}
