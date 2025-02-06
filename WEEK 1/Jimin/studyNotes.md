# **[Week 1] Stack , Queue , Priority Queue , Deque**



### 1. 스택(Stack)

---
##### 📌 개념
- **접시를 쌓아 올리는 구조**와 비슷한 자료구조

##### 📌 특징
- **LIFO(Last In, First Out, 후입선출)**
- **맨 위(Top)에서만 삽입(push)과 삭제(pop) 가능**

##### 📌 주요 메서드
| 메서드      | 설명                                |
| :---------- | :---------------------------------- |
| `push(x)`   | 요소 `x`를 스택의 맨 위(Top)에 추가 |
| `pop()`     | 맨 위 요소를 제거하고 반환          |
| `peek()`    | 맨 위 요소를 확인 (삭제 X)          |
| `isEmpty()` | 스택이 비어있는지 확인              |

##### 📌 장점

- 구현이 간단하고 빠름 → 삽입/삭제 연산이 O(1)
- 재귀 함수 실행 시 **호출 스택(Call Stack)** 으로 사용됨

##### 📌 단점

- 원하는 요소를 중간에서 바로 꺼낼 수 없음
- 크기를 미리 정해야 할 수도 있음

##### 📌 사용 예시

- 웹 브라우저의 **뒤로 가기(이전 페이지)**
- 프로그램의 **실행 취소(Undo)**
- 수식 계산 (괄호 검사)

##### 📌 코드 예시

```java
import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // 데이터 추가 (Push)
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("스택: " + stack);

        // 데이터 삭제 (Pop)
        int popped = stack.pop();
        System.out.println("Pop된 요소: " + popped);
        System.out.println("Pop 후 스택: " + stack);

        // 맨 위의 요소 확인 (Peek)
        int top = stack.peek();
        System.out.println("현재 맨 위 요소: " + top);
    }
}
```

출력

```java
스택: [10, 20, 30]
Pop된 요소: 30
Pop 후 스택: [10, 20]
현재 맨 위 요소: 20
```



### 2. 큐(Queue)

---
##### 📌 개념
- **줄 서기**와 같은 구조

##### 📌 특징

- **FIFO(First In, First Out, 선입선출)**
- **한쪽(Rear)에서 삽입, 반대쪽(Front)에서 삭제**

##### 📌 주요 메서드

| 메서드       | 설명                                 |
| ------------ | ------------------------------------ |
| `enqueue(x)` | 요소 `x`를 큐의 끝(Rear)에 추가      |
| `dequeue()`  | 큐의 앞(Front)에서 요소 제거 후 반환 |
| `peek()`     | 큐의 맨 앞 요소 확인 (삭제 X)        |
| `isEmpty()`  | 큐가 비어있는지 확인                 |

##### 📌 장점

- 순서대로 처리해야 하는 작업에 적합
- 데이터가 들어온 순서를 유지

##### 📌 단점

- 중간 데이터를 빠르게 접근할 수 없음
- 배열 기반 큐는 크기가 고정될 수 있음

##### 📌 사용 예시

- 프린터 대기열
- 프로세스 스케줄링 (운영체제에서 작업을 처리하는 순서)
- 네트워크 패킷 처리

##### 📌 코드 예시

```java
import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        // 데이터 추가 (Enqueue)
        queue.add(1);
        queue.add(2);
        queue.add(3);

        System.out.println("큐: " + queue);

        // 데이터 삭제 (Dequeue)
        int removed = queue.poll();
        System.out.println("Dequeue된 요소: " + removed);
        System.out.println("Dequeue 후 큐: " + queue);

        // 맨 앞의 요소 확인 (Peek)
        int front = queue.peek();
        System.out.println("현재 맨 앞 요소: " + front);
    }
}
```
출력
```java
큐: [1, 2, 3]
Dequeue된 요소: 1
Dequeue 후 큐: [2, 3]
현재 맨 앞 요소: 2
```



### 3. 우선순위 큐(Priority Queue)

---
##### 📌 개념
- **일반 큐와 다르게** 데이터가 들어온 순서대로 나가는 것이 아니라, **우선순위(priority)가 높은 데이터가 먼저 나옴**

##### 📌 특징

- **우선순위가 높은 요소가 먼저 나옴**
- **Heap(힙) 자료구조를 사용해서 구현하는 경우가 많음**

##### 📌 주요 메서드

| 메서드      | 설명                                    |
| ----------- | --------------------------------------- |
| `add(x)`    | 요소 `x` 추가 (우선순위에 맞게 정렬됨)  |
| `poll()`    | 우선순위가 가장 높은 요소 제거 후 반환  |
| `peek()`    | 우선순위가 가장 높은 요소 확인 (삭제 X) |
| `isEmpty()` | 큐가 비어있는지 확인                    |

##### 📌 장점

- 중요한 데이터를 먼저 처리할 수 있음
- 삽입/삭제 연산이 빠름 → Heap 기반일 경우, O(log N)

##### 📌 단점

- 구현이 일반 큐보다 복잡함
- 배열로 구현하면 삽입/삭제 시 정렬이 필요해서 비효율적일 수 있음

##### 📌 사용 예시

- 운영체제에서 **CPU 스케줄링** (긴급한 프로세스를 먼저 실행)
- 다익스트라(Dijkstra) 알고리즘 (최단 경로 찾기)
- 네트워크 라우팅 (긴급 데이터 먼저 전송)

##### 📌 코드 예시

```java
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
		    // PriorityQueue는 기본적으로 작은 숫자가 먼저 나오는 최소 힙 방식!
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
				// 만약 큰 숫자가 먼저 나오게 하고 싶다면, Collections.reverseOrder()를 사용해서 내림차순 우선순위 큐를 만들 수 있음
				// PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        // 데이터 추가 (Enqueue)
        priorityQueue.add(5);
        priorityQueue.add(1);
        priorityQueue.add(10);
        priorityQueue.add(3);

        System.out.println("우선순위 큐: " + priorityQueue);

        // 데이터 삭제 (Dequeue) - 가장 작은 값이 먼저 나옴
        int removed = priorityQueue.poll();
        System.out.println("Dequeue된 요소: " + removed);
        System.out.println("Dequeue 후 우선순위 큐: " + priorityQueue);

        // 맨 앞의 요소 확인 (Peek)
        int top = priorityQueue.peek();
        System.out.println("현재 맨 앞 요소: " + top);
    }
}

```

출력

```java
우선순위 큐: [1, 3, 10, 5]
Dequeue된 요소: 1
Dequeue 후 우선순위 큐: [3, 5, 10]
현재 맨 앞 요소: 3
```



### 4. 덱(Deque, Double-Ended Queue)

---
##### 📌 개념
* 스택과 큐의 특성을 모두 가지고 있음

##### 📌 특징
1. **양쪽 끝에서 삽입(Insertion)과 삭제(Deletion) 가능**
2. **FIFO(선입선출) & LIFO(후입선출) 둘 다 가능**
3. **연결 리스트(LinkedList) 또는 배열(Array)로 구현 가능**
    - **`LinkedList`를 기반으로 하면 삽입/삭제가 빠름 → O(1), 하지만 메모리 사용 증가**
    - **`ArrayDeque`를 기반으로 하면 접근 속도가 빠름 → O(1)**

##### 📌 종류
- **일반 덱(Deque)**
    - 앞과 뒤에서 삽입/삭제가 모두 가능한 가장 기본적인 덱
- **앞쪽에서만 삽입/삭제 가능한 덱 (Input Restricted Deque)**
    - 뒤쪽에서는 삽입 불가능, **앞에서만 삽입/삭제 가능**
- **뒤쪽에서만 삽입/삭제 가능한 덱 (Output Restricted Deque)**
    - 앞쪽에서는 삽입 불가능, **뒤에서만 삽입/삭제 가능**

##### 📌 주요 메서드
| 메서드        | 설명                     |
| ------------- | ------------------------ |
| `addFirst(x)` | 앞쪽에 값 `x` 추가       |
| `addLast(x)`  | 뒤쪽에 값 `x` 추가       |
| `pollFirst()` | 앞쪽에서 값 제거 후 반환 |
| `pollLast()`  | 뒤쪽에서 값 제거 후 반환 |
| `peekFirst()` | 앞쪽 값 확인 (삭제 X)    |
| `peekLast()`  | 뒤쪽 값 확인 (삭제 X)    |
| `isEmpty()`   | 덱이 비어있는지 확인     |
| `size()`      | 덱의 크기 확인           |

##### 📌 시간 복잡도
- 삽입/삭제가 매우 빠른 자료구조 → 양방향에서 삽입/삭제가 필요한 문제에서 자주 사용됨

| 연산       | 시간 복잡도 |
| ---------- | ----------- |
| 앞/뒤 삽입 | **O(1)**    |
| 앞/뒤 삭제 | **O(1)**    |
| 앞/뒤 조회 | **O(1)**    |

##### 📌 활용 예시
- **회전 큐 문제**
    - 특정 숫자를 찾아가면서 삭제해야 하는 문제 (ex: 요세푸스 문제)
- **슬라이딩 윈도우 알고리즘**
    - 주어진 범위에서 최댓값/최솟값을 찾는 문제
- **수식 계산 (중위 → 후위 변환)**
    - 연산자를 저장하는 데 활용됨
- **페이지 캐시 교체 (LRU 캐시)**
    - 가장 오래된 데이터를 삭제하고 새로운 데이터를 추가하는 데 사용됨



### 4. Stack , Queue , Priority Queue , Deque 비교 정리

---
| 비교 항목   | 스택(Stack)               | 큐(Queue)                        | 우선순위 큐(Priority Queue)        | 덱(Deque, Double-Ended Queue)              |
| ----------- | ------------------------- | -------------------------------- | ---------------------------------- | ------------------------------------------ |
| 삽입 방식   | 맨 위(Top)에 추가         | 뒤(Rear)에 추가                  | 우선순위에 따라 삽입               | 앞/뒤에 추가                               |
| 삭제 방식   | 맨 위(Top)에서 제거       | 앞(Front)에서 제거               | 우선순위가 높은 것부터 제거        | 앞/뒤에 제거                               |
| 순서 개념   | LIFO (후입선출)           | FIFO (선입선출)                  | 우선순위에 따라 처리               | 양쪽에서 삽입/삭제 가능                    |
| 사용 예시   | 실행 취소, 함수 호출 스택 | 프린터 대기열, 프로세스 스케줄링 | 네트워크 패킷, 다익스트라 알고리즘 | 슬라이딩 윈도우, LRU 캐시                  |
| 장점        | 빠른 삽입/삭제            | 순차적 처리에 적합               | 중요한 작업을 먼저 처리            | 스택 + 큐의 장점 결합                      |
| 단점        | 중간 데이터 접근 불가능   | 중간 데이터 접근 불가능          | 구현이 복잡                        | 중간 데이터 접근 느림                      |
| Java 클래스 | Stack<E>                  | Queue<E> (LinkedList 활용)       | PriorityQueue<E>                   | Deque<E> (LinkedList 또는 ArrayDeque 활용) |