// 문제: 백준 17478번 재귀함수가 뭔가요?
// 링크: https://www.acmicpc.net/problem/17478
// 시간: 116ms

import java.io.*;

public class B17478 {

	// 문자열 한줄마다 언더바를 붙이기 위해서 각 문자열별로 String 변수에 저장함
    static String s1 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
    static String s2 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
    static String s3 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        recursion(sb, n, 0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void recursion(StringBuilder sb, int n, int depth) {
    	// 언더바 4개를 추가하는 String을 따로 만들어서 사용함.
    	// 이를 위해 recursion 메소드에서 depth 매개변수를 따로 받아 사용함(언더바 개수 증가)
        String prefix = "_".repeat(depth * 4);
        sb.append(prefix + "\"재귀함수가 뭔가요?\"\n");

        if (depth == n) {
            sb.append(prefix + "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
        } else {
            sb.append(prefix + s1);
            sb.append(prefix + s2);
            sb.append(prefix + s3);
            // 재귀 반복마다 언더바 4개가 계속해서 더해지도록 설정
            recursion(sb, n, depth + 1);
        }

        sb.append(prefix + "라고 답변하였지.\n");
    }
}
