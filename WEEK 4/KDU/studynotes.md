## 재귀(Recursion)

- 함수가 자기 자신을 호출하여 문제를 해결하는 기법으로 일반적으로 
기저 조건(Base Case)과 재귀 호출(Recursive Case)로 구성됨.

### 재귀 함수의 동작 원리

1. **기저 조건(Base Case)**: 재귀 호출이 중단되는 조건
2. **재귀 단계(Recursive Case)**: 문제를 점진적으로 해결하는 단계
3. **호출 스택(Call Stack) 사용**: 함수 호출이 쌓이며 LIFO(Last In First Out) 방식으로 처리됨

✅ **장점**

- 코드가 간결하고 논리적으로 이해하기 쉬움
- 문제를 더 직관적으로 해결할 수 있음 (예: DFS, 트리 순회)

❌ **단점**

- 스택 메모리를 사용하므로 **Stack Overflow** 가능성이 있음
- 반복문보다 실행 속도가 느릴 수 있음
- 불필요한 중복 계산이 많을 수 있음 (ex. 피보나치 수열)

### 재귀 예제 1 : 팩토리얼

```java
public class Factorial {
    public static int factorial(int n) {
        if (n == 0) return 1; // 기저 조건
        return n * factorial(n - 1); // 재귀 호출
    }

    public static void main(String[] args) {
        System.out.println(factorial(5)); // 출력: 120
    }
}
```

### 재귀 예제 2 : 피보나치 수열

```java
import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    private static Map<Integer, Integer> memo = new HashMap<>();

    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (memo.containsKey(n)) return memo.get(n);

        int result = fibonacci(n - 1) + fibonacci(n - 2);
        memo.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(6)); // 8
    }
}
```

- 메모이제이션(Memoziation) 사용
→ 한 번 계산된 결과는 저장하여 재귀로 호출 시 다시 재귀로 들어가지 않고 결과값만 리턴하도록 만들면 중복 연산을 방지할 수 있음

## 분할 정복(Divide and Conquer)

- 문제를 작은 문제로 나누고(Divide), 개별적으로 해결하고(Solve), 합쳐서(Combine) 최종 해를 도출하는 방식

### 분할 정복의 동작 과정

1. **분할(Divide)**: 문제를 작은 문제로 나눈다.
2. **정복(Conquer)**: 작은 문제들을 해결한다.
3. **결합(Combine)**: 해결된 부분 문제들을 결합하여 최종 결과를 만든다.

✅ **장점**

- 큰 문제를 작은 문제로 나눠 해결할 수 있음
- 정렬, 탐색, 행렬 연산 등에서 유용하게 사용됨

❌ **단점**

- 재귀를 사용하므로 스택 메모리를 사용
- 일부 경우(예: 작은 데이터셋)에서는 일반 반복문보다 비효율적

### 분할 정복 예제  1 : 합병 정렬(Merge Sort)

```java
import java.util.Arrays;

public class MergeSort {
    // 배열을 Merge Sort 방식으로 정렬하는 함수
    public static void mergeSort(int[] arr, int left, int right) {
        // 기저 조건: 배열 크기가 1 이하일 경우 종료
        if (left >= right) return; 

        // 중간 지점 찾기
        int mid = left + (right - left) / 2;

        // 왼쪽 부분 배열 정렬
        mergeSort(arr, left, mid);
        // 오른쪽 부분 배열 정렬
        mergeSort(arr, mid + 1, right);

        // 정렬된 두 부분을 병합
        merge(arr, left, mid, right);
    }

    // 두 개의 정렬된 부분 배열을 병합하는 함수
    public static void merge(int[] arr, int left, int mid, int right) {
        // 왼쪽, 오른쪽 부분 배열 생성
        int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0, j = 0, k = left;

        // 작은 값을 비교하며 정렬
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) arr[k++] = leftArr[i++];
            else arr[k++] = rightArr[j++];
        }

        // 남은 요소 추가
        while (i < leftArr.length) arr[k++] = leftArr[i++];
        while (j < rightArr.length) arr[k++] = rightArr[j++];
    }

    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr)); // 출력: [3, 9, 10, 27, 38, 43, 82]
    }
}

```

### 분할 정복 예제  2 : 퀵 정렬(Quick Sort)

```java
import java.util.Arrays;

public class QuickSort {
    // 퀵 정렬 함수
    public static void quickSort(int[] arr, int left, int right) {
        // 기저 조건: 배열 크기가 1 이하일 경우 종료
        if (left >= right) return;

        // 배열을 나누고 피벗을 기준으로 정렬
        int pivot = partition(arr, left, right);
        
        // 피벗 왼쪽 부분 정렬
        quickSort(arr, left, pivot - 1);
        // 피벗 오른쪽 부분 정렬
        quickSort(arr, pivot + 1, right);
    }

    // 피벗을 기준으로 배열을 나누는 함수
    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right]; // 마지막 요소를 피벗으로 선택
        int i = left - 1;

        // 피벗보다 작은 요소는 왼쪽으로 이동
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        // 피벗을 올바른 위치로 이동
        swap(arr, i + 1, right);
        return i + 1; // 피벗 위치 반환
    }

    // 배열의 두 요소를 교환하는 함수
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {10, 80, 30, 90, 40, 50, 70};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr)); // 출력: [10, 30, 40, 50, 70, 80, 90]
    }
}

```