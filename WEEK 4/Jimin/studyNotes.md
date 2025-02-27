# **[Week 4] Recursion, Divide and Conquer**



### 1. 재귀(Recursion)

- **함수 내에서 자기 자신을 호출하는 기법**
- 어떤 문제를 풀 때 더 작은 문제로 나누어 같은 방식으로 해결

#### 핵심 개념

1. 기저 조건(Base Case) : 재귀가 멈추는 조건 -> 없으면 무한루프
2. 재귀 단계(Recursion Case) : 문제를 더 작은 문제로 나누어 자기 자신을 호출 -> 기저 조건에 도달할 수 있도록 설정하는 것이 중요! 

#### 장점
- 코드가 간결하고 이해하기 쉬움
- 반복문이 없어도 복잡한 문제 해결 가능
- 분할 정복 알고리즘에서 유용함 (예시: 병합 정렬, 퀵 정렬)

#### 단점
- 스택 오버플로우(Stack Overflow) 위험 : 너무 깊게 호출되면 메모리가 초과됨
- 성능 문제 : 중복 호출이 많으면 비효율적 (예시: 피보나치 수열)
- 반복문보다 속도가 느릴 수 있음

#### 재귀와 반복문의 차이점
|  | 재귀 | 반복문 |
| --- | --- | --- |
| 코드 길이 | 짧고 간결 | 상대적으로 길어질 수 있음 |
| 실행 속도 | 느릴 수 있음 (스택 사용) | 빠름 |
| 메모리 사용 | 더 많음 (스택 프레임 사용) | 적음 |
| 이해도 | 직관적 (특정 문제에서) | 직관적이지 않을 수 있음 |

- 반복문으로 해결 가능하다면 반복문을 쓰는 것이 더 효율적
- 트리 검색, 하노이의 탑 등의 문제는 재귀를 사용하는 것이 효율적
<br>-> 따라서 문제를 풀 때 반복문과 비교해서 어떤 것이 더 효율적인지 생각해보고 풀면 좋을 듯

### 2. 분할 정복(Divide and Conquer)

- 큰 문제를 작은 문제로 나눈 후, 각각을 해결한 다음 결과를 합쳐서 전체 문제를 해결하는 알고리즘

#### 분할 정복의 단계

1. **분할** - 문제를 더 작은 하위 문제로 나눔
2. **정복** - 하위 문제를 해결 (보통 재귀적으로 해결)
3. **결합** - 하위 문제의 결과를 합쳐 원래 문제의 해답을 구함

- 분할 정복이 반드시 재귀를 사용하는 것은 아님 ! !

#### 분할 정복 알고리즘 예시 - 병합 정렬(Merge Sort)

1. 배열을 절반으로 나눔
2. 각각의 부분 배열을 정렬
3. 정렬된 두 배열을 병합하여 하나의 정렬된 배열을 만듦

병합 정렬의 특징
<br> - 시간복잡도 -> O(n log n) 
<br> - 재귀적으로 문제 해결
<br> - 안정 정렬(Stable Sort), 데이터의 상대적 순서가 유지지

```
import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return; // 기저 조건 (배열 크기가 1 이하이면 정렬 완료)
        
        int mid = (left + right) / 2; // 배열을 절반으로 나눔
        mergeSort(arr, left, mid); // 왼쪽 부분 정렬
        mergeSort(arr, mid + 1, right); // 오른쪽 부분 정렬
        merge(arr, left, mid, right); // 병합
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1]; // 임시 배열
        int i = left, j = mid + 1, k = 0;

        // 두 배열을 병합
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        // 원래 배열에 복사
        for (i = left, k = 0; i <= right; i++, k++) {
            arr[i] = temp[k];
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2, 7, 1, 6};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr)); // [1, 2, 3, 4, 5, 6, 7, 8]
    }
}
```

### 3. 재귀와 분할 정복의 차이점

| 구분 | 재귀(Recursion) | 분할 정복(Divide and Conquer) |
| --- | --- | --- |
| 개념 | 함수가 자기 자신을 호출하는 기법 | 문제를 작은 문제로 나누고 해결 후 합치는 기법 |
| 사용 방식 | 단순히 자기 자신을 호출하여 반복 | 하위 문제로 나누고 정복 후 합침 |
| 기저 조건 | 기저 조건이 없으면 무한 호출 | 기저 조건을 설정하여 문제를 작게 해결 |
| 대표 알고리즘 | 피보나치, 팩토리얼 | 병합 정렬, 퀵 정렬, 이진 탐색 |
| 특징 | 직접적으로 동일한 문제를 반복 해결 | 나눈 문제를 독립적으로 해결한 후 결합 |

결론 : 재귀 - 방법 / 분할 정복 - 전략 (지선생님 띵언)