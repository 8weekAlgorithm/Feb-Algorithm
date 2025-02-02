# 스택(Stack), 큐(Queue), 우선순위 큐(Priority Queue) 정리

## 1. 스택(Stack)

### 특징

- **후입선출(LIFO, Last In First Out)**: 마지막에 들어온 데이터가 가장 먼저 나간다.
- 주요 메서드:
  - `push(E e)`: 요소 추가
  - `pop()`: 요소 제거 및 반환
  - `peek()`: 최상단 요소 조회 (제거 X)
  - `isEmpty()`: 스택이 비어있는지 확인

### Java 예제

```java
Stack<Integer> stack = new Stack<>();
stack.push(1);
stack.push(2);
stack.push(3);
System.out.println(stack.pop());  // 3
System.out.println(stack.peek()); // 2
```

## 2. 큐(Queue)

### 특징

- **선입선출(FIFO, First In First Out)**: 먼저 들어온 데이터가 먼저 나간다.
- 주요 메서드:
  - `offer(E e)`: 요소 추가
  - `poll()`: 첫 번째 요소 제거 및 반환
  - `peek()`: 첫 번째 요소 조회 (제거 X)
  - `isEmpty()`: 큐가 비어있는지 확인

### Java 예제

```java
Queue<Integer> queue = new LinkedList<>();
queue.offer(1);
queue.offer(2);
queue.offer(3);
System.out.println(queue.poll());  // 1
System.out.println(queue.peek());  // 2
```



## 3. 우선순위 큐(Priority Queue)

### 특징

- 일반적인 큐와 달리 **우선순위가 높은 요소가 먼저 처리됨**.
- Java에서는 `PriorityQueue` 클래스를 사용 (기본적으로 최소 힙 구조).

### Java 예제

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.offer(3);
pq.offer(1);
pq.offer(2);
System.out.println(pq.poll());  // 1
System.out.println(pq.peek());  // 2
```



## 4. 힙(Heap)과 우선순위 큐

- 우선순위 큐는 일반적으로 **완전 이진 트리(Complete Binary Tree) 기반의 힙(Heap) 자료구조**를 사용하여 구현됨.
- Java의 `PriorityQueue`는 **최소 힙(min-heap)** 기반으로 동작하지만, `Comparator`를 사용하여 최대 힙(max-heap)으로 변경 가능.

### Java 최대 힙 예제

```java
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
maxHeap.offer(3);
maxHeap.offer(1);
maxHeap.offer(2);
System.out.println(maxHeap.poll());  // 3 (최대값이 먼저 나옴)
```



## 5. 덱(Deque)

### 특징

- **양방향 큐(Double-Ended Queue)**로, 앞과 뒤에서 요소를 추가하거나 제거할 수 있다.
- `ArrayDeque` 또는 `LinkedList`로 구현 가능.
- 주요 메서드:
  - `offerFirst(E e)`: 앞에 요소 추가
  - `offerLast(E e)`: 뒤에 요소 추가
  - `pollFirst()`: 앞 요소 제거 및 반환
  - `pollLast()`: 뒤 요소 제거 및 반환
  - `peekFirst()`: 앞 요소 조회 (제거 X)
  - `peekLast()`: 뒤 요소 조회 (제거 X)
  - `isEmpty()`: 덱이 비어있는지 확인

### Java 예제

```java
Deque<Integer> deque = new ArrayDeque<>();
deque.offerFirst(1);
deque.offerLast(2);
System.out.println(deque.pollFirst());  // 1
System.out.println(deque.pollLast());   // 2
```



## 6. ArrayDeque vs LinkedList

### ArrayDeque

- **배열 기반**으로 구현되어 있으며, 스택과 큐의 기능을 모두 제공.
- `Stack`과 `Queue`의 대체제로 추천됨.
- `null` 요소 저장 불가.
- **빠른 삽입/삭제(O(1))**, 랜덤 접근 불가능.

#### Java 예제

```java
Deque<Integer> deque = new ArrayDeque<>();
deque.offerFirst(1);
deque.offerLast(2);
System.out.println(deque.pollFirst());  // 1
System.out.println(deque.pollLast());   // 2
```

### LinkedList

- **연결 리스트 기반**으로 구현되어 있으며, 스택, 큐, 덱의 기능을 모두 제공.
- 중간 삽입/삭제가 많은 경우 유리하지만, 메모리 사용량이 큼.
- `null` 요소 저장 가능.

#### Java 예제

```java
Deque<Integer> linkedDeque = new LinkedList<>();
linkedDeque.offerFirst(1);
linkedDeque.offerLast(2);
System.out.println(linkedDeque.pollFirst());  // 1
System.out.println(linkedDeque.pollLast());   // 2
```



## 7. 시간 복잡도 정리

| 연산                | 스택 (`ArrayDeque`) | 큐 (`Queue`) | 우선순위 큐 (`PriorityQueue`) | 덱 (`Deque`)  |
| ----------------- | ----------------- | ----------- | ------------------------ | ------------ |
| 삽입 (`push/offer`) | O(1)              | O(1)        | O(log N)                 | O(1)         |
| 삭제 (`pop/poll`)   | O(1)              | O(1)        | O(log N)                 | O(1)         |
| 조회 (`peek`)       | O(1)              | O(1)        | O(1)                     | O(1)         |
| 검색 (`contains`)   | O(N)              | O(N)        | O(N)                     | O(N)         |
| 비어있는지 확인 (`isEmpty`) | O(1)      | O(1)        | O(1)                     | O(1)         |



이 문서는 GitHub에서 자료구조 개념을 정리하고 Java 코드 예제와 함께 쉽게 학습할 수 있도록 작성되었습니다.


### 💡TIP!

- 문법은 [이곳](https://gist.github.com/ihoneymon/652be052a0727ad59601)에 잘 정리되어 있습니다.

- `VScode`를 사용하면 Markdown 프리뷰를 확인하며 작성할 수 있습니다.

  + [[VSCode] 마크다운 미리보기](https://detail-from-a-to-z.tistory.com/36)
  + 단축키: `Ctrl + Shift + V` 또는 `Ctrl + K V`



