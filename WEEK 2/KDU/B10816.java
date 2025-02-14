// 문제: 백준 10816번 숫자 카드 2
// 링크: https://www.acmicpc.net/problem/10816
// 시간: 1324ms

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // N과 카드값 입력 받음
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // M과 key 카드값 입력 받음
        int M = Integer.parseInt(br.readLine());

        int[] arr_test = new int[M];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr_test[i] = Integer.parseInt(st1.nextToken());
        }

        // 이분탐색을 위한 정렬 진행
        Arrays.sort(arr);
        
        // key 다음 값이 처음 나오는 index에서 key값이 처음나오는 index를 빼줘서 저장해주는 count배열 생성
        int[] count = new int[M];
        
        for (int i = 0; i < M; i++) {
			count[i] = afterindex(arr, arr_test[i]) - beforeindex(arr, arr_test[i]);
			sb.append(count[i]).append(" ");
		}
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
        
    }
    
    /* Q. 아래 코드를 보면 똑같은 이분탐색인데 arr[mid]>=key냐 arr[mid]>key냐 
     * 이 조건으로 beforeindex와 afterindex가 갈리게 된다. 그 이유는?
     * A. beforeindex의 경우 key값이 처음 나오는 index를 추출해야 된다.
     * arr[mid]>=key인 경우 가운데 값이 key인 경우에도 right를 계속 줄이므로 결국 key값이 여러개인 경우
     * key가 가장 먼저 나오는 index에서 left와 right가 만나게 된다.
     * 하지만 afterindex의 경우는 key 다음 값이 나오는 경우의 첫번째 index를 추출해야된다.
     * arr[mid]>key인 경우 가운데 값이 key인 경우는 포함하지 않으므로 결국 key값이 여러개인 경우
     * right는 key 다음 값의 가장 첫번째 index로 이동하게 된다.
     * 
     * Q. 만약 key값이 배열에 없다면?
     * A. 그렇게 된다면 beforeindex와 afterindex 모두 key값이 배열에 위치해야하는 index값을 출력하게 된다.
     * ex) arr = {1,3,5,7,9}일때 key값이 4라면
     *     afterindex(arr,4) = 2 (4가 들어갈 위치 인덱스 반환)
     *     beforeindex(arr,4) = 2 (4가 들어갈 위치 인덱스 반환)
     *     => 최종적으로 없는 key값을 찾으면 개수는 항상 0이 됨!
     * */
    
    // 카드를 정렬하고 이분탐색 시 key값이 처음 나오는 index를 추출하는 메소드
    public static int beforeindex(int[] arr, int key) {
    	int left = 0;
    	int right = arr.length;
    	while(left<right) {
    		int mid = (left+right)/2;
    		if(arr[mid]>=key) right = mid;
    		else left = mid+1;
    	}
    	return left; // key값이 처음 나오는 위치 반환
    }
    
    // 카드를 정렬하고 이분탐색 시 key 다음 값이 처음 나오는 index를 추출하는 메소드
    public static int afterindex(int[] arr, int key) {
    	int left = 0;
    	int right = arr.length;
    	while(left<right) {
    		int mid = (left+right)/2;
    		if(arr[mid]>key) right = mid;
    		else left = mid+1;
    	}
    	return left; // key 다음 값이 처음 나오는 위치 반환
    }
    
    

    
}