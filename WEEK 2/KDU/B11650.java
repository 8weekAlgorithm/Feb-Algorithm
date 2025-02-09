// 문제: 백준 11650번 좌표 정렬하기
// 링크: https://www.acmicpc.net/problem/11650
// 시간: 732ms

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// x좌표와 y좌표를 묶어서 정렬해야하기 때문에 Position이라는 클래스를 만들어서
// x좌표와 y좌표를 동시에 관리하기로 함
class Position{
	int x;
	int y;
	
	public Position() {}
	
	public Position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
}

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		Position[] xy = new Position[n];
		
		// for문 안에서 객체를 생성해주고 x,y좌표에 입력값을 넣어줌
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			xy[i] = new Position();
			xy[i].x = Integer.parseInt(st.nextToken());
			xy[i].y = Integer.parseInt(st.nextToken());
			
		}
		
		/* 자바에서 사용하는 정렬 방법 중 배열이나 리스트에 사용이 가능한 Arrays.sort를 사용하였다.
		 * 1) 객체의 별도 정렬 기준을 셋팅하기 위해 Comparator를 사용함
		 * 2) 정렬 기준이 2개이므로 여러 정렬 기준을 적용할 때 사용하는 .thenComparing()을 이용하였다.
		 * */
		Arrays.sort(xy, Comparator.comparingInt((Position p) -> p.x).thenComparing(p -> p.y));
		
		// Stringbuilder를 이용하여 값들을 저장하고 bufferedwriter를 통해 출력함
		for (int i = 0; i < n; i++) {
			sb.append(xy[i].getX()).append(" ").append(xy[i].getY()).append("\n");
		}
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
    }
}

// 