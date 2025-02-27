# **재귀& 분할정복**


## **1. 재귀**  
- 함수 내에 본인을 호출
```java
void recursion(int cur) {
    if (cur == 10) { // 종료 조건
        return;
    }
    recursion(cur + 1); // 자기 자신을 호출
}
```
- 피보나치, 팩토리얼, 유클리드 호제법 등등


### **개념**
- 본인 자신을 지속적으로 호출하기 때문에 시행횟수(n)가 커질수록 메모리 사용량이 커짐
- 복잡한 반복문 구조를 간결하게 표현할 수 있음
- 특정한 규칙을 찾는다면 예상하기 힘든 상황을 구현할 수 있음 

### **언제 사용?**
- n개에서 k를 뽑는 nCk(조합)을 구할 때,`nCk = n-1Ck + n-1Ck-1`의 성질을 활용 
```java
int combination(int n, int k) {
    if (k == 0 || k == n) return 1; // 종료 조건
    return combination(n - 1, k) + combination(n - 1, k - 1);
}
```
- DFS, 백트래킹
```java
void dfs(int node, boolean[] visited, List<List<Integer>> graph) {
    visited[node] = true;
    for (int next : graph.get(node)) {
        if (!visited[next]) {
            dfs(next, visited, graph);
        }
    }
}
```
 

---

## **2. 분할정복**
- **큰 문제를 작은 문제로 나누어 해결**하고, 이를 합쳐서 최종 답을 도출하는 알고리즘 기법

### **개념**
- 문제를 절반으로 나누어 처리하는 방식  
- 분할(재귀적으로 문제를 나누고) → 정복(각각 해결) → 합병(결과를 합침)  
- 시간복잡도 줄일 수 있음음 (ex. `O(N²) → O(N log N)`)  

### **언제 사용?**
- 거듭제곱- **기존 방식 (`O(N)`) → 분할정복(`O(log N)`)로 최적화 가능**
```java
public class Power {
    static long power(long base, long exp) {
        if (exp == 0) return 1;
        long half = power(base, exp / 2);
        if (exp % 2 == 0) return half * half;
        else return half * half * base;
    }

    public static void main(String[] args) {
        System.out.println(power(2, 10)); // 출력: 1024
    }
}

```
- **이진 탐색 (Binary Search)**
```java
public class BinarySearch {
    static int binarySearch(int[] arr, int left, int right, int target) {
        if (left > right) return -1;
        int mid = (left + right) / 2;

        if (arr[mid] == target) return mid;
        else if (arr[mid] > target) return binarySearch(arr, left, mid - 1, target);
        else return binarySearch(arr, mid + 1, right, target);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        System.out.println(binarySearch(arr, 0, arr.length - 1, 7)); // 출력: 3 (인덱스)
    }
}

```
---

## ** 정리**
| 개념 | 재귀| 분할정복 |
|------|----------------|----------------|
| **정의** | 자기 자신을 호출하는 함수 | 문제를 작은 부분으로 나누어 해결 |
| **주요 활용** | 팩토리얼, 피보나치, DFS, 백트래킹 | 거듭제곱, 정렬(퀵 정렬, 병합 정렬), 이진 탐색 |
| **장점** | 코드가 간결하고 가독성이 높음 | 시간 복잡도를 줄일 수 있음 |
| **단점** | 메모리 사용량 증가 (스택 오버플로우 위험) | 코드가 복잡해질 수 있음 |
| **시간 복잡도** | 보통 `O(2^N)` (비효율적일 수 있음) | `O(log N)` 또는 `O(N log N)`으로 최적화 가능 |
