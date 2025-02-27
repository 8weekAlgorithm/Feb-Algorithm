// 문제: 백준 28075번 스파이
// 링크: https://www.acmicpc.net/problem/28075
// 시간: 124ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class B28075 {
        static int[] spy = new int[6];
        static int n;// 일수
        static int m;// 목표 기여도
        static int success;// 성공횟수
    
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
            StringTokenizer st = new StringTokenizer(br.readLine());
    
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
    
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 3; i++) {
                spy[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 3; i < 6; i++) {
                spy[i] = Integer.parseInt(st.nextToken());
            }
            // 첫날 임무 장소 한거+ 누적 포인+진행일수
    
            for (int i = 0; i < 6; i++) {
                mission(i, spy[i], 1);
            }
            System.out.println(success);
        }
    
        private static void mission(int kind, int total, int cur) {
            // TODO Auto-generated method stub cur=> 종료하게 해주는 조건//
    
    //		if (total >= m) {// 기여도가 넘어가면 success++ return 종료->
            //여기서 갈라지는 분기가 여러개일 수 있는데 여기서 종료해버린다면 하나의 경우로 합쳐짐 
    //			success++;
    //			return;
    //		}
            if (cur == n) {// n일까지 수행하고 m을 못넘으면 그냥 return만 //넘어가면 success++ return
                if (m <= total) {
                    success++;
                    return;
                } else {
                    return;
                }
            }
            for (int i = 0; i < 6; i++) {
                if (i % 3 == kind % 3) {
                    mission(i, total + spy[i] / 2, cur + 1);
                } else {
                    mission(i, total + spy[i], cur + 1);
                }
            }
        }
    }
