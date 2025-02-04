# 큐, 스택, 힙, 덱

## **🔹 큐 (Queue) - FIFO (First In First Out)**

### **🟢 큐의 개념**
- **선입선출(FIFO, First In First Out)**
  - 먼저 들어온 요소가 먼저 나감
  - **예시**
    ```
    입력: 1 → 2 → 3
    출력: 1 → 2 → 3
    ```

- **대표적인 활용 사례**:
  - 🚀 **BFS (너비 우선 탐색)**
  - 🖨 **프린터 작업 대기열**
  - ⏳ **프로세스 스케줄링**
  - 📡 **데이터 버퍼링**
  - 🎮 **게임 대기열**

---

## **🔹 큐의 생성**
자바에서 `Queue` 인터페이스는 **`LinkedList`** 또는 **`ArrayDeque`** 로 구현할 수 있음.

```java
// LinkedList를 사용하여 큐 생성
Queue<Integer> queue = new LinkedList<>();

// ArrayDeque를 사용하여 큐 생성 (더 빠른 성능)
Queue<Integer> queue2 = new ArrayDeque<>();
```

---

## **🔹 큐의 주요 메서드**
| 메서드       | 설명                                      | 메서드       | 설명                                      |
|-------------|-----------------------------------------|-------------|-----------------------------------------|
| `add(x)`    | 큐에 x 삽입 (`Exception` 발생 가능)      | `offer(x)`   | 큐에 x 삽입 (`false` 반환 가능)         |
| `remove()`  | 첫 번째 요소 제거 (`Exception` 발생)     | `poll()`     | 첫 번째 요소 제거 후 반환 (`null` 가능) |
| `clear()`   | 큐 초기화                                | `peek()`     | 첫 번째 요소 조회 (삭제하지 않음)       |
| `isEmpty()` | 큐가 비어 있는지 확인                    | `size()`     | 큐의 크기 반환                          |

---

## **🔹 스택 (Stack) - LIFO (Last In First Out)**

### **🟠 스택의 개념**
- **후입선출(LIFO, Last In First Out)**
  - 나중에 들어온 요소가 먼저 나감
  - **예시**
    ```
    입력: 1 → 2 → 3
    출력: 3 → 2 → 1
    ```

- **대표적인 활용 사례**:
  - 🌲 **DFS (깊이 우선 탐색)**
  - 🔄 **재귀 함수 호출 관리**
  - 🔤 **문자열 역순 처리**
  - 🧮 **수식 계산(후위 표기법 등)**
  - 🔙 **이전 페이지로 가기**
  - ⏪ **되돌리기(ctrl+z)**

---

### **🔹 스택의 생성**
자바에서 `Stack` 클래스를 사용하여 구현 가능.

```java
Stack<Integer> stack = new Stack<>();
```

---

### **🔹 스택의 주요 메서드**
| 메서드       | 설명                                      |
|-------------|-----------------------------------------|
| `push(x)`    | 스택에 x 삽입                           |
| `pop()`      | 스택에서 최상단 요소 제거 후 반환        |
| `peek()`     | 스택의 최상단 요소 조회 (삭제하지 않음)  |
| `isEmpty()`  | 스택이 비어 있는지 확인                 |
| `size()`     | 스택의 크기 반환                         |

---

## **🔹 힙 (Heap)**
### **🔵 힙의 개념**
- **우선순위 큐(Priority Queue) 기반의 자료구조**
- **최소 힙(Min Heap)**: 부모 노드가 자식 노드보다 항상 작음 → 루트 노드가 최소값
- **최대 힙(Max Heap)**: 부모 노드가 자식 노드보다 항상 큼 → 루트 노드가 최대값

---

### **🔹 힙의 생성**
자바에서 `PriorityQueue` 클래스를 사용하여 힙 구현 가능.

```java
// 최소 힙 (기본)
PriorityQueue<Integer> minHeap = new PriorityQueue<>();

// 최대 힙 (reverseOrder 사용)
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
```

---

### **🔹 힙의 주요 메서드**
| 메서드       | 설명                                      |
|-------------|-----------------------------------------|
| `add(x)`    | 힙에 x 삽입                              |
| `poll()`    | 최솟값(또는 최댓값) 제거 후 반환           |
| `peek()`    | 최솟값(또는 최댓값) 조회 (삭제하지 않음)   |
| `isEmpty()` | 힙이 비어 있는지 확인                     |
| `size()`    | 힙의 크기 반환                             |

---

## **🔹 덱 (Deque - 양방향 큐)**
### **🟣 덱의 개념**
- **양방향으로 삽입/삭제가 가능한 자료구조**
- **앞뒤에서 삽입/삭제가 모두 가능**

---

### **🔹 덱의 생성**
자바에서 `Deque` 인터페이스를 `ArrayDeque` 또는 `LinkedList`로 구현 가능.

```java
// ArrayDeque 사용
Deque<Integer> deque = new ArrayDeque<>();

// LinkedList 사용
Deque<Integer> deque2 = new LinkedList<>();
```

---

### **🔹 덱의 주요 메서드**
| 메서드        | 설명                                     | 메서드        | 설명                                     |
|--------------|--------------------------------------|--------------|--------------------------------------|
| `addFirst(x)` | 앞쪽에 x 삽입                       | `addLast(x)`  | 뒤쪽에 x 삽입                        |
| `pollFirst()` | 앞쪽 요소 제거 후 반환              | `pollLast()`  | 뒤쪽 요소 제거 후 반환               |
| `peekFirst()` | 앞쪽 요소 조회 (삭제 X)             | `peekLast()`  | 뒤쪽 요소 조회 (삭제 X)              |
| `isEmpty()`   | 덱이 비어 있는지 확인               | `size()`      | 덱의 크기 반환                        |

---

📌 **자료구조 선택 기준**
✔ **순차적으로 처리할 때 → 🟢 `Queue` 추천**  
✔ **마지막에 들어온 데이터를 먼저 처리 → 🟠 `Stack` 추천**  
✔ **우선순위 처리가 필요할 때 → 🔵 `Heap` 추천**  
✔ **양방향 삽입/삭제가 필요할 때 → 🟣 `Deque` 추천**  

## **📌 ArrayDeque vs LinkedList 비교**
ArrayDeque와 LinkedList는 모두 **큐(Queue)와 덱(Deque)**의 기능을 수행할 수 있지만, 내부 구현 방식이 다르며 성능 차이가 존재

---

## **📌 ArrayDeque<E> (배열 기반 덱)**
> **배열(Array)로 구현된 덱(Deque)**
- ArrayDeque는 **동적 크기 배열**을 사용하여 큐 및 스택 연산을 수행합니다.
- 요소가 추가될 때 **배열 크기를 자동으로 확장**합니다.

### **✅ 주요 특징**
✔ **연속적인 메모리 블록을 사용하여 빠른 접근 속도(O(1))**  
✔ **크기가 자동으로 증가하는 배열 기반 구조**  
✔ **중간 삽입/삭제가 O(N), 하지만 앞뒤 추가/삭제가 O(1)**  
✔ **null을 허용하지 않음** (LinkedList는 null 허용)  
✔ **메모리 사용량이 적고 캐시 효율이 좋음**

---

## **📌 LinkedList<E> (연결 리스트 기반 덱)**
> **이중 연결 리스트(Doubly Linked List)로 구현된 덱(Deque)**
- LinkedList는 **각 요소(Node)가 이전 및 다음 요소를 참조하는 구조**를 가짐.

### **✅ 주요 특징**
✔ **앞뒤 삽입/삭제가 O(1) (노드 포인터만 변경)**  
✔ **중간 삽입/삭제가 O(1)~O(N), 위치를 찾는 데 시간이 걸림**  
✔ **메모리 사용량이 많음 (노드당 추가적인 참조 값이 필요)**  
✔ **요소 접근 속도가 느림 (O(N), 선형 탐색 필요)**  
✔ **null을 허용**

---

## **📌 ArrayDeque vs LinkedList 비교표**
| 비교 항목 | ArrayDeque (배열 기반) | LinkedList (연결 리스트 기반) |
|------------|---------------------|---------------------|
| **내부 구현** | 동적 배열 (Array) | 이중 연결 리스트 (Doubly Linked List) |
| **메모리 사용량** | **적음** (배열만 사용) | **많음** (각 노드가 추가 메모리 사용) |
| **임의 접근 속도** | **O(1)** (빠름) | **O(N)** (느림) |
| **앞/뒤 추가** | **O(1)** | **O(1)** |
| **앞/뒤 삭제** | **O(1)** | **O(1)** |
| **중간 삽입/삭제** | **O(N)** (배열 이동 필요) | **O(1)~O(N)** (노드 탐색 필요) |
| **캐시 효율** | **좋음** (배열 구조) | **나쁨** (포인터 참조로 인해 캐시 비효율) |
| **null 허용 여부** | ❌ 허용 안됨 | ✅ 허용 |
| **빠른 탐색이 필요한 경우** | ✅ **추천** | ❌ |
| **삽입/삭제가 자주 발생하는 경우** | ❌ | ✅ **추천** |

---

## **📌 ArrayDeque와 LinkedList, 언제 선택할까?**
✅ **큐(Queue)와 덱(Deque)으로 사용하려면?**  
➡ **⚡ ArrayDeque이 최고의 선택!** (LinkedList보다 빠름)  

✅ **빠른 탐색이 필요하다면?**  
➡ **🔥 ArrayDeque 사용!** (O(1) 랜덤 접근 가능)  

✅ **중간 삽입/삭제가 많다면?**  
➡ **🔄 LinkedList가 유리!** (O(1) 삽입/삭제)  

✅ **대량 데이터 처리 시, 메모리를 절약하고 싶다면?**  
➡ **💾 ArrayDeque 추천!** (LinkedList는 추가 메모리 사용)  

---
## **📌 BFS (너비 우선 탐색, Breadth-First Search)**
> **BFS는 큐를 활용하여 "가까운 노드부터 탐색"하는 방식**

### **📌 BFS의 특징**
✔ **한 번 방문한 노드를 다시 방문하지 않도록 관리해야 함**  
✔ **큐를 사용하여 탐색을 순차적으로 진행함**  
✔ **그래프 탐색, 최단 경로 탐색 등에 활용됨**  

---

## **📌 BFS 예제 (기본 구현)**
```java
import java.util.Queue;
import java.util.LinkedList;

public class BFSExample {
    public static void main(String[] args) {
        int nodeCount = 10; 
        boolean[] visited = new boolean[nodeCount + 1]; // 방문 여부 체크

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1); // 첫 노드 추가 (시작점)
        visited[1] = true; // 시작 노드를 방문 처리

        while (!queue.isEmpty()) { // 큐가 빌 때까지 반복
            int current = queue.poll(); // 큐에서 현재 노드 가져오기
            System.out.println("방문 노드: " + current);

            // 예제: current + 1, current + 2 노드를 방문하는 방식
            for (int next : new int[]{current + 1, current + 2}) {
                if (next <= nodeCount && !visited[next]) { // 유효한 노드인지 확인
                    queue.offer(next);
                    visited[next] = true; // 방문 처리
                }
            }
        }
    }
}
```

**✅ 실행 결과**
```
방문 노드: 1
방문 노드: 2
방문 노드: 3
방문 노드: 4
방문 노드: 5
방문 노드: 6
방문 노드: 7
방문 노드: 8
방문 노드: 9
방문 노드: 10
```
---