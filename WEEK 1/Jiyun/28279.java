// 문제: 백준 28279번 덱2
// 링크: https://www.acmicpc.net/problem/28279
// 시간: 4292ms

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Deque<Integer> deque = new ArrayDeque<>();
		int n = Integer.parseInt(br.readLine());

		// 명령의 수 n만큼 실행
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			
			switch (command) {

			// 요소 삽입
			case 1:
				deque.offerFirst(Integer.parseInt(st.nextToken()));
				break;
			case 2:
				deque.offerLast(Integer.parseInt(st.nextToken()));
				break;

			// 요소 삭제
			case 3:
				if (deque.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(deque.pollFirst());
				}
				break;
			case 4:
				if (deque.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(deque.pollLast());
				}
				break;

			// 요소 확인
			case 5:
				System.out.println(deque.size());
				break;
			case 6:
				if (deque.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
				break;

			// 맨앞, 맨뒤 요소
			case 7:
				if (deque.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(deque.peekFirst());
				}
				break;
			case 8:
				if (deque.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(deque.peekLast());
				}
				break;
			}
		}
	}
}