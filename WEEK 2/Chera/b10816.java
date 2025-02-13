import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b10816 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] own = new int[N]; // 상근이가 가지고 있는 숫자
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			own[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(own);

		int M = Integer.parseInt(br.readLine());
		int[] target = new int[M]; // 몇개인지 찾아야 할 숫자
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			target[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(own);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			
			int lower = lowerBound(own, target[i]);
			int higher = higherBound(own, target[i]);
			sb.append((higher-lower) + " ");
		}
		
		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();

	}

    // Lower Bound: target 이상인 첫 위치
    private static int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    // Upper Bound: target 초과인 첫 위치
    private static int higherBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
