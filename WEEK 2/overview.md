# 정렬, 이분 탐색

### 💡 필수 내용

- **정렬 (Sorting)**
  + 데이터를 특정한 순서로 정렬하는 알고리즘.
  + 주요 정렬 알고리즘
    - 선택 정렬(Selection Sort)
    - 버블 정렬(Bubble Sort)
    - 삽입 정렬(Insertion Sort)
    - 카운팅 정렬(Counting Sort)
    - 병합 정렬(Merge Sort)
    - 퀵 정렬(Quick Sort)
    - 힙 정렬(Heap Sort)
    - ...

- **이분 탐색 (Binary Search)**
  + 정렬된 배열에서 특정 값을 빠르게 찾는 탐색 알고리즘.
  + 중간값을 기준으로 왼쪽 또는 오른쪽으로 탐색 범위를 줄이며 찾는다.


<br/>

### ❓ 유용한 내용

- 각 정렬 알고리즘의 시간복잡도를 확인했는가?
  + 모든 정렬 알고리즘이 효율적인 건 아니다. 선택 정렬, 버블 정렬, 삽입 정렬의 시간복잡도는 O(N²)이다.

- 자바에서 정렬을 수행하는 방법은?
  + `Arrays.sort()` → Dual-Pivot QuickSort
  + `Arrays.sort(객체배열, Comparator)` → Tim Sort(Merge Sort + Insertion Sort)
  + `Collections.sort()` → List 정렬 시 사용, 내부적으로 `Arrays.sort()` 활용
  + `PriorityQueue` → 힙 정렬이 적용된 우선순위 큐

- 자바에서 이분 탐색을 사용하는 방법은?
  + `Arrays.binarySearch()` → 정렬된 배열에서 이분 탐색
  + `Collections.binarySearch()` → 정렬된 리스트에서 이분 탐색
  + 메서드를 사용하기 전에 반환값을 확인하자.

<br/>

### 📂 기본 문제

- 정렬 : [백준 11650](https://www.acmicpc.net/problem/11650)
- 이분 탐색  : [백준 2417](https://www.acmicpc.net/problem/2417)

<br/>

 ### 📂 응용 문제

- 정렬
  + 실버 4 | [백준 1431](https://www.acmicpc.net/problem/1431)
  + 실버 3 | [백준 2012](https://www.acmicpc.net/problem/2012)

- 이분 탐색
  + 실버 4 | [백준 10816](https://www.acmicpc.net/problem/10816)
  + 실버 2 | [백준 2805](https://www.acmicpc.net/problem/2805)
  + 골드 4 | [백준 2110](https://www.acmicpc.net/problem/2110)

