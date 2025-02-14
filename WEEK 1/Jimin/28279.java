// 백준 28279번 덱 2 (실버2)

import java.io.*;
import java.util.*;

public class Deque2 {
	public static void main(String[] args) throws IOException {
		
		// 정수로 저장하는 덱
		Deque<Integer> deque = new LinkedList<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringTokenizer st;
		
        // 명령의 수 입력
		int N = Integer.parseInt(br.readLine());
        
		// 명령의 수만큼 입력 받기
		for (int i=0; i<N; i++) {
			
			// 명령의 종류 입력 받기
			st = new StringTokenizer(br.readLine());

			switch (Integer.parseInt(st.nextToken())) {
			// 1. 정수 X를 덱의 앞에 넣는다.
			case 1: 
				deque.addFirst(Integer.parseInt(st.nextToken()));
				break;
				
			// 2. 정수 X를 덱의 뒤에 넣는다.	
			case 2: 
				deque.addLast(Integer.parseInt(st.nextToken()));
				break;
				
			// 3. 덱에 정수가 있다면 맨 앞의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.	
			case 3: 
				bw.write(!deque.isEmpty() ? String.valueOf(deque.pollFirst()) : "-1");
				bw.newLine();
				break;
				
			// 4. 덱에 정수가 있다면 맨 뒤의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.	
			case 4: 
				bw.write(!deque.isEmpty() ? String.valueOf(deque.pollLast()) : "-1");
				bw.newLine();
				break;
				
			// 5. 덱에 들어있는 정수의 개수를 출력한다.	
			case 5: 
				bw.write(String.valueOf(deque.size()));
				bw.newLine();
				break;
				
			// 6. 덱이 비어있으면 1, 아니면 0을 출력한다.
			case 6: 
				bw.write(deque.isEmpty() ? "1" : "0");
				bw.newLine();
				break;
				
			// 7. 덱에 정수가 있다면 맨 앞의 정수를 출력한다. 없다면 -1을 대신 출력한다.
			case 7: 
				bw.write(!deque.isEmpty() ? String.valueOf(deque.peekFirst()) : "-1");
				bw.newLine();
				break;
				
			// 8. 덱에 정수가 있다면 맨 뒤의 정수를 출력한다. 없다면 -1을 대신 출력한다.	
			case 8: 
				bw.write(!deque.isEmpty() ? String.valueOf(deque.peekLast()) : "-1");
				bw.newLine();
				break;
			}
		}
		br.close();
		bw.flush(); // 남이있는 데이터 모두 출력
		bw.close();
	}
}