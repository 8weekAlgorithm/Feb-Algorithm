# 재귀(Recursion)와 분할 정복(Divide and Conquer)

## 1. 재귀(Recursion)

### 개념
재귀는 함수가 자기 자신을 호출하는 기법을 의미함. 작은 문제를 해결하는 함수를 만들어서 큰 문제를 해결하는 방식으로 활용됨.

### 기본 구조
```java
public static void recursiveFunction(int n) {
    if (n <= 0) { // 종료 조건 (Base Condition)
        return;
    }
    System.out.println("재귀 호출: " + n);
    recursiveFunction(n - 1); // 자기 자신을 호출
}
```

### 재귀 호출의 핵심 개념
1. **기저 조건(Base Condition)**: 재귀 호출을 멈추는 조건이 필요함.
2. **자기 자신 호출(Self Call)**: 함수 내에서 자기 자신을 호출하여 문제를 해결함.
3. **스택(Stack) 활용**: 재귀 호출은 내부적으로 스택을 사용하여 동작함.

### 예제: 팩토리얼 계산
```java
public static int factorial(int n) {
    if (n == 0) return 1; // 종료 조건
    return n * factorial(n - 1); // 재귀 호출
}
```

---

## 2. 분할 정복(Divide and Conquer)

### 개념
분할 정복(Divide and Conquer)은 문제를 작은 부분 문제로 나누고(Divide), 각각을 해결한 후(Conquer), 다시 합치는(Combine) 방식으로 문제를 해결하는 알고리즘 패턴임.

### 기본 구조
1. **분할(Divide)**: 문제를 작은 부분 문제로 나눔.
2. **정복(Conquer)**: 각 부분 문제를 재귀적으로 해결함.
3. **결합(Combine)**: 해결된 부분 문제를 합쳐서 원래 문제의 해답을 구함.

### 예제: 거듭제곱 계산 (a^b)
```java
public static long power(long a, long b) {
    if (b == 0) return 1; // 종료 조건
    long half = power(a, b / 2);
    if (b % 2 == 0) {
        return half * half;
    } else {
        return half * half * a;
    }
}
```

### 예제: 병합 정렬 (Merge Sort)
```java
public static void mergeSort(int[] arr, int left, int right) {
    if (left >= right) return;
    
    int mid = (left + right) / 2;
    mergeSort(arr, left, mid);
    mergeSort(arr, mid + 1, right);
    merge(arr, left, mid, right);
}

public static void merge(int[] arr, int left, int mid, int right) {
    int[] temp = new int[right - left + 1];
    int i = left, j = mid + 1, k = 0;
    
    while (i <= mid && j <= right) {
        if (arr[i] <= arr[j]) temp[k++] = arr[i++];
        else temp[k++] = arr[j++];
    }
    
    while (i <= mid) temp[k++] = arr[i++];
    while (j <= right) temp[k++] = arr[j++];
    
    System.arraycopy(temp, 0, arr, left, temp.length);
}
```

### 분할 정복 활용 예시
1. **이진 탐색(Binary Search)**: 정렬된 배열에서 특정 값을 빠르게 찾는 알고리즘.
2. **퀵 정렬(Quick Sort)**: 피벗을 기준으로 작은 값과 큰 값으로 나누어 정렬.
3. **병합 정렬(Merge Sort)**: 배열을 반씩 나누어 정렬한 후 합치는 방식.
4. **행렬 곱셈(Matrix Multiplication)**: 큰 행렬을 작은 행렬로 나누어 계산.
5. **거듭제곱(Power Calculation)**: 반복문보다 빠르게 값을 계산할 때 활용.

---

## 3. 재귀와 분할 정복의 차이점
| 구분 | 재귀(Recursion) | 분할 정복(Divide and Conquer) |
|------|---------------|----------------------------|
| 개념 | 함수가 자기 자신을 호출하는 기법 | 문제를 작은 부분 문제로 나누어 해결 |
| 주요 특징 | 기저 조건(Base Case)이 필요함 | 문제를 나누고 해결한 후 합치는 과정 포함 |
| 예제 | 팩토리얼, 피보나치, 하노이 탑 | 병합 정렬, 퀵 정렬, 이진 탐색 |
| 활용 방식 | 단순한 문제 해결에 적합 | 복잡한 문제를 효율적으로 해결 |

---

## 4. 주의할 점
1. **기저 조건을 반드시 설정해야 함**: 재귀 호출이 무한 반복되지 않도록 종료 조건을 설정해야 함.
2. **스택 오버플로(Stack Overflow) 주의**: 너무 깊은 재귀 호출은 메모리를 초과할 수 있음.
3. **반복문과 비교하여 효율성 고려**: 반복문으로 해결 가능한 경우 불필요한 재귀 사용을 피하는 것이 좋음.

---

이 내용은 GitHub에 올려서 정리하면 좋을 것 같음. 추가적인 설명이 필요하면 말해줘!
