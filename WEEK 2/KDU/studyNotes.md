## 정렬

- 데이터를 특정한 순서(오름차순, 내림차순 등)로 정렬하는 알고리즘들을 통칭함.

### 주요 정렬 알고리즘

- 선택 정렬
    - 주어진 리스트에서 가장 작은 원소를 찾아 첫 번째 자리로 이동시키는 방식
    - 시간 복잡도 : O($N^2$)
    - ex) 배열에 {9,6,7,3,5}가 있는 경우 → 4회전을 통해 오름차순 완성
    
    ![selection sort](https://gmlwjd9405.github.io/images/algorithm-selection-sort/selection-sort.png)
    
- 버블 정렬
    - 인접한 두 개의 원소를 비교하여 큰 값을 오른쪽으로 이동
    - 시간 복잡도
        - 최선 : $O(N)$(이미 정렬된 경우)
        - 평균/최악 : $O(N^2)$
    - ex) 배열에 {7,4,5,1,3}가 있는 경우 → 4회전을 통해 오름차순 완성
    
    ![bubble sort](https://gmlwjd9405.github.io/images/algorithm-bubble-sort/bubble-sort.png)
    
- 삽입 정렬
    - 이미 정렬된 부분을 유지하며, 새로운 원소를 적절한 위치에 삽입
    - 처음 Key 값은 두 번째 데이터부터 시작하며, key값과 그 앞의 데이터와 비교하여 key값보다 더 큰 값은 오른쪽으로 보내버림
    - 시간 복잡도
        - 최선 : $O(N)$(거의 정렬된 경우)
        - 평균/최악 : $O(N^2)$
    - ex) 배열에 {8,5,6,2,4}가 있는 경우 → 4회전을 통해 오름차순 완성
        
        ![image.png](attachment:22d5b364-6ff9-4bab-a20a-f32e52842737:image.png)
        
- 병합 정렬
    - 분할 정복(Divide & Conquer) 알고리즘
        - 문제를 작은 2개의 문제로 분리하고 각각을 해결한 다음, 결과를 모아서 문제를 해결하는 전략이며, 순환 호출을 이용하여 구현
    - 배열을 반으로 나누고, 각각 정렬한 후 병합
    - 시간 복잡도
        - 모든 경우 $O(N \r log N)$
    - ex) 입력값으로 {21,10,12,20,25,13,15,22}가 들어오는 경우
    
    ![Merge sort](https://gmlwjd9405.github.io/images/algorithm-merge-sort/merge-sort-concepts.png)
    
- 카운팅 정렬
    - 비(非)비교 정렬 알고리즘, 데이터 크기 범위가 제한적일 때 매우 빠름
    - 각 값의 빈도를 세어 정렬하는 방법
    - 데이터의 최댓값을 기준으로 빈도수를 저장할 배열을 만들고, 누적 합 배열을 생성하여 출력 배열에 정렬된 값을 배치함
    - 시간 복잡도
        
        
        | 단계 | 작업 | 시간 복잡도 |
        | --- | --- | --- |
        | 1. 최대값 k 찾기 | 배열에서 최댓값 찾기 | $O(N)$ |
        | 2. 카운트 배열 생성 | 크기 k+1 배열 초기화 | $O(K)$ |
        | 3. 빈도수 카운팅 | 원본 배열 순회하여 카운팅 | $O(N)$ |
        | 4. 누적 합 계산 | 카운트 배열 순회 | $O(K)$ |
        | 5. 정렬된 배열 생성 | 원본 배열 순회하여 정렬된 위치에 배치 | $O(N)$ |
        | **총합** | **$O(N+K)$** |  |
    - ex) 입력값 : {3,1,2,2,4,5}
    
    ![counting sort1](https://blog.kakaocdn.net/dn/tSwL3/btq8724jF6R/MxyXgbbkdYsNzEZjTXSoR0/img.png)
    
    ![counting sort2](https://blog.kakaocdn.net/dn/qzqVi/btq89L1CPoF/YfW34fAGUxeNp7etU6jnbK/img.png)
    
    ![counting sort3](https://blog.kakaocdn.net/dn/WYRyM/btq89dROGiM/JT2a6yxvgQD39z7iSyM5d1/img.png)
    
    ![counting sort4](https://blog.kakaocdn.net/dn/QiWZZ/btq89vkmDh7/40myVsVLfxYVPs9fKtu7s0/img.png)
    
- 퀵 정렬
    - 분할 정복(Divide & Conquer) 알고리즘
    - 기준이 되는 피벗(pivot)을 선택한 후, 작은 값과 큰 값을 나누어 정렬하는 방식
    - 시간 복잡도
        - 최선 : $O(NlogN)$
        - 평균 : $O(NlogN)$
        - 최악 : $O(N^2)$ (피벗을 가장 작은 값이나 가장 큰 값으로 하면 가까워짐)
    - ex) 입력값 : {5,3,8,4,9,1,6,2,7}
        
        ![quick sort](https://gmlwjd9405.github.io/images/algorithm-quick-sort/quick-sort.png)
        
- 힙 정렬
    - 완전 이진 트리 사용
    - 최대 힙 : 부모 노드의 값이 자식 노드보다 항상 크거나 같음
        
        ```
            50
           /  \
          30   40
         /  \  /
        10  5 20
        ```
        
    - 최소 힙 : 부모 노드의 값이 자식 노드보다 항상 작거나 같음
        
        ```
            5
           /  \
          10   20
         /  \  /
        30  50 40
        ```
        
    - 시간 복잡도
        - 힙을 구성하는 과정 : $O(N)$
        - 최대 힙에서 정렬하는 과정 : $O(NlogN)$
    - 최대 힙 삽입 과정
        
        ![heap sort1](https://gmlwjd9405.github.io/images/data-structure-heap/maxheap-insertion.png)
        
    - 최대 힙 삭제 과정
        
        ![heap sort2](https://gmlwjd9405.github.io/images/data-structure-heap/maxheap-delete.png)
        
- 이분 탐색
    - 정렬된 배열에서 특정 값을 빠르게 찾는 알고리즘
    - 시간 복잡도
        - 최선 : $O(1)$(첫 번째 시도에 찾는 경우)
        - 최악 : $O(logN)$
    - 이분 탐색의 동작 과정
        - ex) 입력값 : [2,3,4,10,40]
        1. 배열의 중간 값(mid)을 찾음
        
        ```jsx
        배열: [2, 3, 4, 10, 40]
        mid = (0 + 4) / 2 = 2 → arr[2] = 4
        ```
        
        1. 새로운 탐색 범위 설정
        
        ```jsx
        배열: [10, 40]
        mid = (3 + 4) / 2 = 3 → arr[3] = 10
        ```
        
    - 빠른 검색 속도를 제공하므로 검색할 값이 많고 정렬된 데이터가 있다면 매우 유용한 알고리즘임

### ❓각 정렬 알고리즘의 시간복잡도

- $O(N^2)$ → 선택 정렬, 버블 정렬, 삽입정렬
- $O(NlogN)$ → 병합 정렬, (퀵 정렬), 힙 정렬
- $O(N)$ → 카운팅 정렬
- ※ 반드시 O(N)이 좋다? → 데이터 갯수와 N이 몇번 반복되느냐에 따라 달라질수도 있음

### 자바 내부 정렬 방법

1. `Arrays.sort()`
    - Dual-Pivot QuickSort 알고리즘 사용
    - 시간 복잡도 : $O(NlogN)$ ※ 최악인 경우 $O(N^2)$
    - 빠르고 메모리 추가 할당 없음
2. `Arrays.sort(객체배열, Comparator)`
    - 객체 배열을 정렬할 때 사용함
    - 내부적으로 Tim Sort(Merge Sort + Insertion Sort) 알고리즘을 사용함
    - 시간 복잡도 : $O(NlogN)$
    - ※ Comparator 사용 시 여러 정렬 기준을 사용할 시 `.thencomparing`을 통해 추가 가능함
3. `Collections.sort()`
    - `List<T>` 컬렉션을 정렬할 때 사용
    - 내부적으로 `Arrays.sort()` 를 호출하여 동작함
    - 정렬 알고리즘 : Tim Sort(Merge Sort + Insertion Sort)
4. `PriorityQueue`
    - 자동으로 최소 힙(오름차순 정렬)으로 정렬됨.
    - 우선순위가 높은 원소를 먼저 꺼낼 때 유용.
    - 시간 복잡도
        - 원소 추가 : $O(logN)$
        - 원소 제거 : $O(logN)$

### 자바 내부 이분 탐색 방법

1. `Arrays.binarySearch()` → 배열에서 사용함
2. `Collections.binarySearch()` → 리스트에서 사용함