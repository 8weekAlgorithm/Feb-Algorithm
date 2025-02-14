// 문제: 백준 1874번 문제제목
// 링크: https://www.acmicpc.net/problem/1874
// 시간: 924ms

import java.util.Scanner;
import java.util.Stack;

public class solution3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] target = new int[n];
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        
        // 결과값을 한번에 출력하기 위해 stringbuilder를 이용함
        StringBuilder sb = new StringBuilder(); 

        // arr : 숫자를 순서대로 넣기 위해 만든 수열 배열(1,2,3...)
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        // target : 입력값을 받아 배열에 저장함
        for (int i = 0; i < target.length; i++) {
            target[i] = sc.nextInt();
        }

        // 첫번째 반복문 : 우선 스택에 계속 push를 해줌 
        for (int i : arr) {
            stack.push(i);
            sb.append("+").append("\n");
            
            // 두번째 반복문 : stack의 제일 윗 값이 입력 배열 값과 같아질 때(=입력된 수열을 만들기 위한 i번째 수열 값을 뽑아낼 수 있음)
            // 예외 처리 : stack이 비어있으면 안되고, 입력 수열값을 다뽑을때까지 반복
            // count : target을 도는 인덱스이자, pop이 발생하는 count임
            while (!(stack.isEmpty()) && count < target.length && stack.peek() == target[count]) {
                stack.pop();
                sb.append("-").append("\n");
                count++;
            }
        }

        // pop을 전부 다 하면 입력값 갯수만큼 진행됨
        // 만약 pop 갯수가 입력값보다 적어진다면, 이는 스택 수열을 구현할 수 없는 상황이므로 NO 출력
        if (count != n) {
            System.out.println("NO");
        }else {
            System.out.println(sb);
        }
        
        /* 1차 시도 : 문제 이해가 불가능해서 이해하는데만 1시간 정도 걸림..
         * 2차 시도 : 문제 이해 후 구현하려고 할때 반복문 구현이 어려웠음
         * -> target은 배열로 저장하여 풀었으나, 순서대로 비교하는 입력값(1,2,3..)을 단순히 for문으로 구현하려고 했으나
         * 그렇게 되면 가독성이 떨어지고 조건을 걸기 어려워서 arr배열에 집어넣은 후 for-each 문으로 구현함
         * -> 두 번째 반복문에서 단순히 for문을 통해 구현하려고 했으나, 이렇게 되면 count < target.length 조건을
         * 걸기 어려워져 구현이 불가능했음(실제 불가능한지는 확인을 해봐야 할듯)
         * -> NO 예외처리를 위해 Stringbuilder를 이용하여 결과값을 저장 후 한번에 출력함
        */
    }
}