// 문제: 백준 11279번 최대 힙
// 링크: https://www.acmicpc.net/problem/11279
// 시간: 896ms

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));

    	// 최대 힙 생성
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			int command = Integer.parseInt(br.readLine());

			if (command == 0) {
				if (maxHeap.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(maxHeap.poll());
				}
			} else {
				maxHeap.offer(command);
			}
		}
	}
}