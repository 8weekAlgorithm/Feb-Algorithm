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