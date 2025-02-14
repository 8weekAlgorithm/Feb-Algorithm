/**
* 문제 : 백준 2012 등수 매기기
* 링크 : https://www.acmicpc.net/submit/2012/
* 시간 : 768ms
*/



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class b2012 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	int N = Integer.parseInt(br.readLine());
	int[] seq = new int[N]; // 예상 등수 배열
	int[] correct = new int[N]; // 실제 등수
	for(int i = 0; i<N; i++) {
		seq[i] = Integer.parseInt(br.readLine());
		correct[i] = i+1;
	}
//	System.out.println(Arrays.toString(seq));
//	System.out.println(Arrays.toString(correct));
	
	Arrays.sort(seq);
	
	long sum = 0;
	
	for(int i = 0; i<N; i++) {
		sum+=Math.abs(seq[i]-correct[i]);
	}

	bw.write(Long.toString(sum));
	bw.flush();
	bw.close();
	
	}

}
