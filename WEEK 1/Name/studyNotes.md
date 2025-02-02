# 1주차: 스택, 큐, 우선순위 큐

## 📖 목차

[1. 스택(Stack)](#스택(Stack)) 

[2. 큐(Queue)](https://www.notion.so/2-Queue-18ebdd83228c8043a6d0e07d51b7be3f?pvs=21) 

[3. 우선순위 큐(Priority Queue)](https://www.notion.so/3-Priority-Queue-18ebdd83228c80f1bf30fcf2be38b744?pvs=21) 

[4. 덱(Deque)](https://www.notion.so/4-Deque-18ebdd83228c80e4b404cdbfcbea9b33?pvs=21) 

[5. **정리: 시간 복잡도 비교표**](https://www.notion.so/5-18ebdd83228c806d8f79c18148ec8470?pvs=21) 

[**6. 연결 리스트(Linked List) 기반 vs 힙(Heap) 기반 차이점**](https://www.notion.so/6-Linked-List-vs-Heap-18ebdd83228c80f4a6c0eafdc85252ed?pvs=21) 

[7. 완전 이진 트리(Complete Binary Tree)란?](https://www.notion.so/7-Complete-Binary-Tree-18ebdd83228c8079b555e45c6eebf61b?pvs=21) 

---

### 📌 Stack과 Queue 클래스를 이용하지 않는 이유?

- Stack 클래스는 Vector를 상속받아 구현되어 있음

![image](https://github.com/user-attachments/assets/e1d7573d-fc00-4b58-872d-3ffbce475532)


Vector 클래스는 동기화 처리가 되어있어 성능↓ (불필요한 성능 오버헤드 발생)

→ 더 빠른 ArrayDeque 사용을 권장

- Queue는 인터페이스이며 직접 구현한 클래스가 없음

![image](https://github.com/user-attachments/assets/9357047c-e25a-4841-822a-016c58945c00)


더 나은 대체 클래스인 ArrayDeque를 사용함

📌 **레거시(Legacy) 클래스 : 새로운 대체 클래스가 나와서 사용을 권장하지 않는 클래스**

---

## 1. 스택(Stack)

- 스택 구현(ArrayDeque 인스턴스 생성)

```jsx
Deque<Integer> stack = new ArrayDeque<>();
```

- push() - 스택에 데이터 추가

```jsx
stack.push(10);
stack.push(20);
stack.push(30);
```

- pop() - 스택의 최상단 요소 제거 및 반환

```jsx
System.out.println("Popped: " + stack.pop()); // 30
```

- peek() - 최상단 요소 조회 (제거하지 않음)

```jsx
System.out.println("Top element: " + stack.peek()); // 20
```

- isEmpty() - 스택이 비어있는지 확인

```jsx
System.out.println("Is stack empty? " + stack.isEmpty()); // false
```

출력 결과

```jsx
Stack after pushes: [30, 20, 10]
Popped: 30
Top element: 20
Is stack empty? false
Final stack: [20, 10]
```

---

## 2. 큐(Queue)

- 큐 구현(ArrayDeque 인스턴스 생성)

```jsx
 Deque<Integer> queue = new ArrayDeque<>();
```

- offer() - 큐에 데이터 추가 (add()도 사용 가능)

```jsx
queue.offer(10);
queue.offer(20);
queue.add(30);
```

- poll() - 큐의 첫 번째 요소 제거 및 반환

```jsx
System.out.println("Polled: " + queue.poll()); // 10
```

- peek() - 첫 번째 요소 조회 (제거하지 않음)

```jsx
 System.out.println("Front element: " + queue.peek()); // 20
```

- isEmpty() - 큐가 비어있는지 확인

```jsx
System.out.println("Is queue empty? " + queue.isEmpty()); // false
```

출력 결과

```jsx
Queue after offers: [10, 20, 30]
Polled: 10
Front element: 20
Is queue empty? false
Final queue: [20, 30]
```

---

### 📌 Stack, Queue의 중간 값 check? → 배열 변환 or 반복문

 1. toArray() 활용 (*시간 복잡도 : O(N)*)

```jsx
// 스택을 배열로 변환
Object[] array = stack.toArray();

// 특정 인덱스 요소 접근
int index = 2; // 예: 중간값 (0-based index)
System.out.println("Element at index " + index + ": " + array[index]); // 30
```

출력 결과

```jsx
Stack: [50, 40, 30, 20, 10]
Element at index 2: 30
```

 2. toArray() 활용 (*시간 복잡도 : O(N)*)

```jsx
// 스택을 List로 변환
List<Integer> list = new ArrayList<>(stack);

// 특정 인덱스 요소 접근
int index = 2;
System.out.println("Element at index " + index + ": " + list.get(index)); // 3
```

출력 결과

```jsx
Element at index 2: 30
```

 3. 반복문 활용 (*시간 복잡도 : O(N)*)

```jsx
int targetIndex = 2;
int currentIndex = 0;

for (int num : stack) {
	if (currentIndex == targetIndex) {
		System.out.println("Element at index " + targetIndex + ": " + num);
		break;
	}
currentIndex++;
```

출력 결과

```jsx
Element at index 2: 30
```

---

## 3. 우선순위 큐(Priority Queue)

### 🔥 **왜 `ArrayDeque`를 사용할 수 없을까?**

1. `ArrayDeque`는 **선입선출(FIFO) 큐** 또는 **후입선출(LIFO) 스택**을 지원하지만, **정렬 기능이 없음**.
2. **우선순위 큐는 정렬이 필요**하므로, **힙(Heap) 자료구조를 사용하는 `PriorityQueue<E>`를 사용해야 함**.
3. `PriorityQueue<E>`는 **O(log N)**의 시간 복잡도로 삽입 및 삭제가 가능하며, 항상 **우선순위가 높은 요소를 먼저 반환**함.

### 우선순위 큐 구현(PriortiyQueue 인스턴스 생성) - **`최소 힙`**

```jsx
PriorityQueue<Integer> pq = new PriorityQueue<>();
```

- push() - 스택에 데이터 추가

```jsx
pq.offer(50);
pq.offer(10);
pq.offer(30);
pq.add(20);
pq.add(40);
```

- poll() - 우선순위가 가장 높은 요소(최솟값) 제거 및 반환

```jsx
while (!pq.isEmpty()) {
            System.out.println("Polled: " + pq.poll()); // 오름차순 정렬된 값 출력
        }
```

### 우선순위 큐 구현(PriortiyQueue 인스턴스 생성) - **`최대 힙`**

```jsx
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
```

- poll() - 우선순위가 가장 높은 요소(최대값) 제거 및 반환

```jsx
while (!maxHeap.isEmpty()) {
            System.out.println("Polled: " + maxHeap.poll()); // 내림차순 정렬된 값 출력
        }
```

### 우선순위 큐 구현(PriortiyQueue 인스턴스 생성) - `사용자 정의 객체(Comparator)`

```jsx
import java.util.PriorityQueue;
import java.util.Comparator;

class Task {
    String name;
    int priority;

    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task{name='" + name + "', priority=" + priority + "}";
    }
}

public class CustomPriorityQueue {
    public static void main(String[] args) {
        // 우선순위를 낮은 값부터 처리하는 큐 (작은 priority가 먼저 나옴)
        PriorityQueue<Task> taskQueue = new PriorityQueue<>(Comparator.comparingInt(t -> t.priority));

        taskQueue.offer(new Task("Task A", 3));
        taskQueue.offer(new Task("Task B", 1));
        taskQueue.offer(new Task("Task C", 2));

        while (!taskQueue.isEmpty()) {
            System.out.println("Processing: " + taskQueue.poll());
        }
    }
}

```

---

## 4. 덱(Deque)

### 🔹 **Deque의 특징**

- 일반적인 **큐(Queue)**는 **FIFO(First-In-First-Out, 선입선출)** 방식.
- **Deque**는 **앞과 뒤에서 모두 삽입/삭제 가능**하므로 **스택(Stack)과 큐(Queue) 역할을 모두 수행**할 수 있음.
- `ArrayDeque`는 `Deque`의 구현체로, **빠르고 메모리를 효율적으로 사용**하는 자료구조.

### `ArrayDeque`로 덱(Deque) 구현 예제

```jsx
import java.util.ArrayDeque;
import java.util.Deque;

public class DequeExample {
    public static void main(String[] args) {
        // ArrayDeque를 사용한 Deque 생성
        Deque<Integer> deque = new ArrayDeque<>();

        // 앞과 뒤에서 요소 추가
        deque.addFirst(10);
        deque.addLast(20);
        deque.offerFirst(5);
        deque.offerLast(25);

        System.out.println("Deque: " + deque);  // [5, 10, 20, 25]

        // 앞과 뒤에서 요소 제거
        System.out.println("Removed from front: " + deque.pollFirst());  // 5
        System.out.println("Removed from back: " + deque.pollLast());    // 25

        System.out.println("Deque after removals: " + deque);  // [10, 20]

        // 앞과 뒤 요소 조회
        System.out.println("Front element: " + deque.peekFirst());  // 10
        System.out.println("Back element: " + deque.peekLast());    // 20
    }
}

```

- 출력 결과

```jsx
Deque: [5, 10, 20, 25]
Removed from front: 5
Removed from back: 25
Deque after removals: [10, 20]
Front element: 10
Back element: 20

```

### `Deque` 의 주요 메서드

### 🔹 **삽입 연산**

| 메서드 | 설명 |
| --- | --- |
| `addFirst(E e)` | 앞쪽에 요소 삽입 (예외 발생 가능) |
| `offerFirst(E e)` | 앞쪽에 요소 삽입 (실패 시 `false` 반환) |
| `addLast(E e)` | 뒤쪽에 요소 삽입 (예외 발생 가능) |
| `offerLast(E e)` | 뒤쪽에 요소 삽입 (실패 시 `false` 반환) |

### 🔹 **삭제 연산**

| 메서드 | 설명 |
| --- | --- |
| `removeFirst()` | 앞쪽 요소 제거 및 반환 (예외 발생 가능) |
| `pollFirst()` | 앞쪽 요소 제거 및 반환 (큐가 비어있으면 `null` 반환) |
| `removeLast()` | 뒤쪽 요소 제거 및 반환 (예외 발생 가능) |
| `pollLast()` | 뒤쪽 요소 제거 및 반환 (큐가 비어있으면 `null` 반환) |

### 🔹 **조회 연산**

| 메서드 | 설명 |
| --- | --- |
| `getFirst()` | 앞쪽 요소 조회 (예외 발생 가능) |
| `peekFirst()` | 앞쪽 요소 조회 (`null` 반환 가능) |
| `getLast()` | 뒤쪽 요소 조회 (예외 발생 가능) |
| `peekLast()` | 뒤쪽 요소 조회 (`null` 반환 가능) |

---

## 5. **정리: 시간 복잡도 비교표**

| 자료구조 | **삽입 (Push/Offer)** | **삭제 (Pop/Poll)** | **조회 (Peek/Get)** | **검색(Search)** |
| --- | --- | --- | --- | --- |
| **스택 (Stack)** | O(1) | O(1) | O(1) | O(N) |
| **큐 (Queue)** | O(1) | O(1) | O(1) | O(N) |
| **우선순위 큐 (Priority Queue)** | O(log N) | O(log N) | O(1) | O(N) |
| **덱 (Deque)** | O(1) | O(1) | O(1) | O(N) |

---

## **6. 연결 리스트(Linked List) 기반 vs 힙(Heap) 기반 차이점**

| 비교 항목 | **연결 리스트 기반 (Stack, Queue)** | **힙(Heap) 기반 (Priority Queue)** |
| --- | --- | --- |
| **구조** | **노드(Node)**들이 포인터로 연결됨 | **완전 이진 트리(Complete Binary Tree)** 구조 |
| **삽입 (Insert)** | O(1) (리스트 앞/뒤에 추가) | O(log N) (힙 재구성 필요) |
| **삭제 (Delete)** | O(1) (리스트 앞/뒤에서 제거) | O(log N) (힙 재구성 필요) |
| **조회 (Peek, Search)** | O(1) (맨 앞/뒤 조회) / O(N) (전체 검색) | O(1) (최댓값 또는 최솟값 조회) |
| **정렬 여부** | **정렬되지 않음** (삽입한 순서 유지) | **우선순위 기준으로 정렬됨** |

---

## 7. 완전 이진 트리(Complete Binary Tree)란?

### 📌 **완전 이진 트리의 특징**

- **왼쪽에서 오른쪽 순서대로 채워진 이진 트리**.
- 마지막 레벨을 제외하고, 모든 노드가 **꽉 차 있어야 함**.
- 마지막 레벨의 노드도 **왼쪽부터 차례대로 채워져야 함**.

```jsx
import java.util.PriorityQueue;

public class MinHeapExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(30);
        pq.offer(10);
        pq.offer(50);
        pq.offer(20);
        pq.offer(40);

        while (!pq.isEmpty()) {
            System.out.println(pq.poll()); // 오름차순 정렬된 값 출력 (10, 20, 30, 40, 50)
        }
    }
}
```

## ✅ **우선순위 큐의 힙(Heap) 동작 과정**

### 📌 **초기 상태 (빈 힙)**

```
(empty)
```

---

### **1️⃣ `pq.offer(30);`**

- 첫 번째 요소 `30`을 삽입 → 루트 노드가 됨.

```
    30
```

---

### **2️⃣ `pq.offer(10);`**

- `10`이 삽입됨 → 부모(30)보다 작으므로 **위로 이동(Swap)**.

```
    10
   /
  30
```

---

### **3️⃣ `pq.offer(50);`**

- `50`이 삽입됨 → 부모(10)보다 크므로 위치 유지.

```
    10
   /  \
  30   50
```

---

### **4️⃣ `pq.offer(20);`**

- `20`이 삽입됨 → 부모(30)보다 작으므로 **위로 이동(Swap)**.

```
    10
   /  \
  20   50
 /
30
```

---

### **5️⃣ `pq.offer(40);`**

- `40`이 삽입됨 → 부모(20)보다 크므로 위치 유지.

```
    10
   /  \
  20   50
 /  \
30   40
```

✅ **완전 이진 트리(Complete Binary Tree) 구조를 유지하면서, 최소 힙(Min Heap) 성질(부모 ≤ 자식)을 만족함**.

---

## ✅ **우선순위 큐에서 요소를 `poll()`할 때 힙의 변화 과정**

**`poll()`은 루트 노드(최솟값)를 제거하고, 마지막 노드를 루트로 이동한 후 재 정렬함.**

---

### **1️⃣ `pq.poll(); // 10 제거`**

- `10`이 제거됨.
- **마지막 노드 `40`을 루트로 이동한 후 재정렬**.
- `40`과 `20`을 비교 → `20`이 작으므로 **`40`과 `20`을 교체(Swap)**.

```
    20
   /  \
  40   50
 /
30
```

---

### **2️⃣ `pq.poll(); // 20 제거`**

- `20`이 제거됨.
- 마지막 노드 `30`을 루트로 이동한 후 재정렬.
- `30`과 `40` 비교 → 위치 유지.

```
    30
   /  \
  40   50
```

---

### **3️⃣ `pq.poll(); // 30 제거`**

- `30`이 제거됨.
- 마지막 노드 `50`을 루트로 이동한 후 재정렬.

```
    40
   /
  50
```

---

### **4️⃣ `pq.poll(); // 40 제거`**

- `40`이 제거됨.
- 마지막 노드 `50`을 루트로 이동 (자식이 없으므로 재정렬 필요 없음).

```
    50
```

---

### **5️⃣ `pq.poll(); // 50 제거`**

- `50`이 제거됨.
- 힙이 완전히 비어 있음.

```
(empty)
```
