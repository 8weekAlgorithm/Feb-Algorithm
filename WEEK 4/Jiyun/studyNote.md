# 재귀

재귀(Recursion)는 함수가 자기 자신을 호출하는 프로그래밍 기법이다. 특정 문제를 더 작은 부분 문제로 나누어 해결할 때 유용하게 사용할 수 있다.

### 핵심 개념
- 기저 사례(Base Case): 재귀가 멈추는 조건. 기저 사례가 없으면 무한 루프에 빠질 수 있다.
- 재귀 관계(Recursive Case): 문제를 더 작은 문제로 쪼개어 자기 자신을 호출한다.


### 동작 방식
재귀 함수가 호출되면 시스템의 호출 스택(Call Stack)에 함수가 하나씩 쌓이게 된다. 기저 사례에 도달하면 반환되어 스택에서 함수가 하나씩 제거되면서 연산된다.

이 과정에서 스택 프레임(Stack Frame)을 사용하기 때문에, 너무 깊은 재귀 호출은 스택 오버플로우(Stack Overflow) 위험이 있다.


### 활용 사례

- 분할 정복(Divide and Conquer): 큰 문제를 작은 문제로 나누고, 각 문제를 해결한 후에 합쳐서 최종 답을 구한다.

- 깊이 우선 탐색(DFS): 한 노드를 방문한 후 재귀적으로 인접 노드를 탐색한다.

- 백트래킹(Backtracking): 가능한 모든 경우를 탐색하되, 정답이 아닌 경로는 가지치기하여 효율적으로 해결한다.


### 예시 코드

```java
public class RecursionExample {
    public static int factorial(int n) {
        if (n == 1) return 1; // 기저 사례
        return n * factorial(n - 1); // 재귀 호출
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
}
```

<br>

# 분할 정복

분할 정복(Divide and Conquer)은 큰 문제를 작은 문제로 나누고(Divide), 이를 해결한 후(Conquer), 다시 결합하여(Combine) 원래 문제를 해결하는 알고리즘 기법이다. 일반적으로 재귀를 활용해 구현된다.

### 핵심 개념
- 분할(Divide)
  + 문제를 더 작은 하위 문제로 나눈다.
  + 각 하위 문제는 원래 문제와 동일한 형태를 가진다.

- 정복(Conquer)
  + 하위 문제를 해결한다.
  + 하위 문제의 크기가 충분히 작아지면 직접 해결한다. (Base Case)

- 병합(Combine)
  + 하위 문제의 결과를 결합해 최종 결과를 도출한다.

### 활용 사례

- 병합 정렬(Merge Sort), 퀵 정렬(Quick Sort)

- 이진 탐색(Binary Search): 탐색 범위를 절반씩 줄여가며 탐색한다.

- 스트라센 알고리즘(Strassen’s Matrix Multiplication): 행렬 곱셈을 $O(N^3)$에서 $O(N$^$2.81)$로 최적화한다.

- 최근접 점 쌍 문제(Closest Pair of Points): 평면 상의 점 중 가장 가까운 두 점을 찾는 문제로, 분할 정복을 이용해 $O(N log N)$으로 해결 가능하다.

### 예시 코드
```java
public class PowerDivideConquer {
    public static long power(long base, int exp) {
        if (exp == 0) return 1; // 기저 사례
        long half = power(base, exp / 2);
        return (exp % 2 == 0) ? half * half : half * half * base;
    }

    public static void main(String[] args) {
        System.out.println(power(2, 10));
    }
}
```