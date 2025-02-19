import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b14921 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long[] liquid = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			liquid[i] = Long.parseLong(st.nextToken());
		}
		
		int start = 0;
		int end = N-1;
		long min = Long.MAX_VALUE;
		while(start < end) {
			
			long sum = liquid[start] + liquid[end];
			long abs = Math.abs(sum);
			
			if(abs<Math.abs(min)) {
				min = sum;
				if(min == 0) {
					break;
				}
			}
			
			if(sum <0) {
				start++;
			}else {
				end--;
			}
		}
		System.out.println(min);
	}

}
