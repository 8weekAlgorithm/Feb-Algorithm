
# 정렬 (Sorting)

정렬은 데이터를 특정 순서대로 나열하는 알고리즘임. 각 정렬 알고리즘은 성능 차이가 있기 때문에 상황에 맞게 선택해야 함.

## 주요 정렬 알고리즘

### 1. 선택 정렬 (Selection Sort)  
- **방법**: 배열에서 최소값을 찾아서 현재 위치랑 교환함.
- **시간복잡도**: O(N²)
- **장점**: 구현 간단
- **단점**: 성능 비효율적

```java
public class SelectionSort {
    // 선택 정렬 메서드
    public static void selectionSort(int[] arr) {
        // 배열의 각 원소에 대해
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;  // 최소값을 찾을 인덱스
            // 현재 원소와 나머지 원소들 비교
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;  // 더 작은 값 발견 시 최소값 갱신
                }
            }
            // 최소값과 현재 원소 위치 교환
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        selectionSort(arr);  // 선택 정렬 실행
        System.out.println(Arrays.toString(arr));  // [1, 2, 5, 5, 6, 9]
    }
}
```

### 2. 버블 정렬 (Bubble Sort)  
- **방법**: 인접한 두 값을 비교해서 큰 값은 뒤로 밀어냄.
- **시간복잡도**: O(N²)
- **장점**: 구현 간단, 거의 정렬된 배열에선 빠름
- **단점**: 최악의 경우 성능 안 좋음

```java
public class BubbleSort {
    // 버블 정렬 메서드
    public static void bubbleSort(int[] arr) {
        // 배열의 각 원소에 대해
        for (int i = 0; i < arr.length - 1; i++) {
            // 인접한 원소들 비교
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 더 큰 값이 왼쪽에 있으면 교환
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        bubbleSort(arr);  // 버블 정렬 실행
        System.out.println(Arrays.toString(arr));  // [1, 2, 5, 5, 6, 9]
    }
}
```

### 3. 삽입 정렬 (Insertion Sort)  
- **방법**: 현재 원소를 적절한 위치에 삽입하는 방식.
- **시간복잡도**: O(N²)
- **장점**: 이미 정렬된 배열에서는 효율적
- **단점**: 데이터 많으면 비효율적

```java
public class InsertionSort {
    // 삽입 정렬 메서드
    public static void insertionSort(int[] arr) {
        // 배열의 두 번째 원소부터 시작
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];  // 삽입할 원소
            int j = i - 1;
            // 삽입할 자리를 찾음
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];  // 원소를 한 칸씩 뒤로 이동
                j--;
            }
            arr[j + 1] = key;  // 적절한 위치에 삽입
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        insertionSort(arr);  // 삽입 정렬 실행
        System.out.println(Arrays.toString(arr));  // [1, 2, 5, 5, 6, 9]
    }
}
```

### 4. 카운팅 정렬 (Counting Sort)  
- **방법**: 값의 출현 횟수를 세서 정렬함.
- **시간복잡도**: O(N + K) (N은 배열 크기, K는 값의 범위)
- **장점**: 값의 범위가 좁으면 빠름
- **단점**: 값의 범위가 넓으면 비효율적

```java
public class CountingSort {
    // 카운팅 정렬 메서드
    public static void countingSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();  // 배열에서 최대값 찾기
        int[] count = new int[max + 1];  // 출현 횟수 배열

        // 각 원소의 출현 횟수 계산
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        // 정렬된 배열로 재구성
        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (count[i] > 0) {
                arr[index++] = i;  // 원소 삽입
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        countingSort(arr);  // 카운팅 정렬 실행
        System.out.println(Arrays.toString(arr));  // [1, 2, 5, 5, 6, 9]
    }
}
```

### 5. 병합 정렬 (Merge Sort)  
- **방법**: 배열을 반으로 나누고, 나눠진 배열을 정렬한 뒤 합침.
- **시간복잡도**: O(N log N)
- **장점**: 안정적인 정렬, 최악의 경우에도 일정
- **단점**: 추가 메모리 필요

```java
public class MergeSort {
    // 병합 정렬 메서드
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) return;  // 배열 길이가 1 미만이면 리턴
        
        int mid = arr.length / 2;  // 배열 중간 지점
        int[] left = Arrays.copyOfRange(arr, 0, mid);  // 왼쪽 부분
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);  // 오른쪽 부분
        
        mergeSort(left);  // 왼쪽 부분 재귀적으로 정렬
        mergeSort(right);  // 오른쪽 부분 재귀적으로 정렬
        
        merge(arr, left, right);  // 두 배열 합침
    }

    // 두 배열 병합하는 메서드
    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        // 두 배열을 비교하면서 병합
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // 남은 원소들 병합
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        mergeSort(arr);  // 병합 정렬 실행
        System.out.println(Arrays.toString(arr));  // [1, 2, 5, 5, 6, 9]
    }
}
```

### 6. 퀵 정렬 (Quick Sort)  
- **방법**: 피벗을 기준으로 배열을 나누고 재귀적으로 정렬함.
- **시간복잡도**: O(N log N) (평균적으로)
- **장점**: 평균적으로 매우 빠름
- **단점**: 최악의 경우 O(N²)

```java
public class QuickSort {
    // 퀵 정렬 메서드
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);  // 피벗으로 나누기
            quickSort(arr, low, pi - 1);  // 왼쪽 부분 정렬
            quickSort(arr, pi + 1, high);  // 오른쪽 부분 정렬
        }
    }

    // 배열을 피벗 기준으로 나누는 메서드
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  // 피벗값
        int i = (low - 1);  // 작은 값들의 인덱스
        
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;  // 작은 값 발견 시 인덱스 증가
                // 교환
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // 피벗을 올바른 위치로 이동
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        quickSort(arr, 0, arr.length - 1);  // 퀵 정렬 실행
        System.out.println(Arrays.toString(arr));  // [1, 2, 5, 5, 6, 9]
    }
}
```

### 7. 힙 정렬 (Heap Sort)  
- **방법**: 힙 자료구조를 사용해서 정렬함.
- **시간복잡도**: O(N log N)
- **장점**: 추가 메모리 공간 없이 정렬 가능
- **단점**: 구현 복잡함, 비교 연산 많음

```java
public class HeapSort {
    // 힙 정렬 메서드
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // 최대 힙 만들기
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);  // 힙화 작업
        }

        // 원소를 힙에서 꺼내 정렬
        for (int i = n - 1; i > 0; i--) {
            // 루트와 마지막 원소 교환
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // 힙 재구성
            heapify(arr, i, 0);
        }
    }

    // 힙화 작업 메서드
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;  // 부모 인덱스
        int left = 2 * i + 1;  // 왼쪽 자식 인덱스
        int right = 2 * i + 2;  // 오른쪽 자식 인덱스

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // 자식이 부모보다 크면 교환
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);  // 재귀 호출로 힙 재구성
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        heapSort(arr);  // 힙 정렬 실행
        System.out.println(Arrays.toString(arr));  // [1, 2, 5, 5, 6, 9]
    }
}
```

# 자바에서 정렬을 수행하는 방법은?

- `Arrays.sort()` → Dual-Pivot QuickSort 사용
- `Arrays.sort(객체배열, Comparator)` → Tim Sort(Merge Sort + Insertion Sort)
- `Collections.sort()` → List 정렬 시 사용, 내부적으로 `Arrays.sort()` 활용
- `PriorityQueue` → 힙 정렬이 적용된 우선순위 큐

# 이분 탐색 (Binary Search)

이분 탐색은 **정렬된 배열**에서 특정 값을 빠르게 찾는 알고리즘임. 중간값을 기준으로 탐색 범위를 절반씩 줄여가며 찾음.

## 자바에서 이분 탐색 사용하는 방법

### 1. `Arrays.binarySearch()`
- 정렬된 배열에서 이분 탐색을 실행함.

```java
int[] arr = {1, 3, 5, 7, 9};
int index = Arrays.binarySearch(arr, 5);  // 배열에서 5를 찾음
System.out.println(index); // 2
```

### 2. `Collections.binarySearch()`
- 정렬된 리스트에서 이분 탐색을 실행함.

```java
List<Integer> list = Arrays.asList(1, 3, 5, 7, 9);
int index = Collections.binarySearch(list, 5);  // 리스트에서 5를 찾음
System.out.println(index); // 2
```

이분 탐색을 사용하려면 배열이나 리스트가 **정렬되어 있어야** 함.
