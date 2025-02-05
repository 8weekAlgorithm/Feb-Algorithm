# Stack, Queue

스택과 큐는 다음과 같은 특징을 가진다.

- **선형 자료구조 (Linear Data Structure)** : 데이터가 차례대로 저장된다.

- **제한적인 데이터 접근 방식** : 임의의 위치에 접근할 수 없으며, 삽입과 삭제는 특정한 규칙에 따라 진행된다.

<br/>

![Stack, Queue](https://gohighbrow.com/wp-content/uploads/2018/07/Computer-science-fundamentals_6.1.png)

## 스택 (Stack)

- LIFO(Last In First Out, 후입선출) 원칙을 따른다.

- 한쪽 끝에서만 데이터를 추가하거나 삭제할 수 있다.
  + 데이터를 추가할 때 가장 위에 쌓고, 데이터를 삭제할 때도 가장 위의 것을 제거한다.

- 사용 사례
  + 재귀 호출 : 가장 마지막에 호출되는 함수가 먼저 종료되는 특성 상 스택이 사용된다.
  + 웹 브라우저 뒤로 가기 : 마지막에 방문한 페이지부터 돌아가며 이전 페이지로 이동한다.
  + DFS : 내부적으로 스택을 사용하여 경로를 추적한다.

<br/>

## 큐 (Queue)

- FIFO(First in First Out, 선입선출) 원칙을 따른다.

- 양쪽 끝을 사용하며, 데이터 삽입과 삭제가 다른 끝에서 수행된다.
  + 한쪽 끝에서는 데이터를 삽입만 하고, 반대쪽 끝에서는 데이터를 삭제만 한다.

- 사용 사례
  + 프로세스 스케줄링 : 여러 프로세스가 CPU를 사용을 위해 대기할 때, 먼저 요청한 프로세스부터 실행된다.
  + 네트워크 패킷 : 데이커 패킷을 순서대로 전송한다.
  + BFS : 노드를 차례로 탐색하기 위해 큐를 사용한다.


<br/>

## 어떻게 사용할까?

자바에는 `Stack`과 `Queue`가 존재하지만, 사용이 권장되지는 않는다. 이유는 다음과 같다.

- `Stack`

  + `Stack` 클래스는 `Vector`을 상속받기 때문에 모든 메서드가 동기화 처리되어 있다. 동기화는 단일 스레드 환경에서 성능 저하를 유발한다.

  + `Vector`는 동적 배열이지만, 새 배열을 생성하고 복사하는 과정이 필요해 성능 저하가 발생한다.

  + `Stack`은 오래된 API이기 때문에, 자바 컬렉션 프레임워크와 호환성이 떨어진다.

- `Queue`

  + `Queue`는 인터페이스에 불과하기 때문에, 이를 실제로 사용하기 위해선 구현을 위한 클래스가 필요하다.

<br/>

## LinkedList vs ArrayDeque

자바에서 스택과 큐를 사용하는 대표적인 방법으로는 `LinkedList`와 `ArrayDeque`가 있다. 그중에서도 `ArrayDeque`가 더 나은 성능을 보이는데, 이유는 다음과 같다.

- 메모리 효율
  
  + `LinkedList`는 연결 리스트로, 각 노드마다 다음과 이전 노드를 참조하는 포인터를 함께 저장해야 한다.

  + `ArrayDequq`는 배열 기반으로, 추가적인 포인터 메모리 낭비가 없다.

- 연산 속도
  
  + `LinkedList`는 각 요소가 노드로 연결되어 있기 때문에 메모리 주소를 따라가며 데이터를 찾는다.
  
  + `ArrayDeque`는 배열을 사용하여 연속된 메모리에 데이터를 저장하기 때문에 CPU 캐시 적중률이 높아 속도가 빠르다.
  
  + 맨앞 맨뒤 삽입/삭제는 O(1)로 동일하지만, 임의 위치 탐색이 필요한 경우엔 `ArrayDeque`는 O(1), `LinkedList`는 O(N)의 속도를 보인다.

- 크기 조절 속도

  + `LinkedList`는 동적으로 크기가 조절되지만, 노드 추가 시마다 객체 생성과 참조 비용이 발생한다.

  + `ArrayDeque`는 내부 배열 크기를 2배 증가시키는 방법을 사용하여, 배열 복사 한 번으로 크기 문제를 해결할 수 있다.
    + 하지만 필요 이상으로 확보하여 메모리를 낭비 가능성이 있으며, 요소가 삭제되더라도 크기가 자동으로 줄어들지 않는다.

- 데이터 무결성

  + `LinkedList`는 Null 값을 허용하지만, `ArrayDeque`는 허용하지 않는다.

<br/>

## 사용 예제

덱(Deque)은 양방향에서 삽입과 삭제가 가능한 자료구조이다. 스택과 큐 모두 활용 가능하다.

```java

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeDequeExample {
    public static void main(String[] args) {

        Deque<Integer> deque = new ArrayDeque<>();

        // 앞쪽에서 추가
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        System.out.println(deque); // [3, 2, 1]

        // 뒤쪽에서 추가
        deque.addLast(4);
        deque.addLast(5);
        System.out.println(deque); // [3, 2, 1, 4, 5]

        // 앞쪽에서 제거
        System.out.println(deque.removeFirst()); // 3
        System.out.println(deque); // [2, 1, 4, 5]

        // 뒤쪽에서 제거
        System.out.println(deque.removeLast()); // 5
        System.out.println(deque); // [2, 1, 4]

        // 맨 앞/뒤 요소 확인
        System.out.println(deque.getFirst()); // 2
        System.out.println(deque.getLast()); // 4

        // 크기 확인
        System.out.println(deque.size()); // 3

        // 모든 요소 제거
        deque.clear();
        System.out.println(deque.isEmpty()); // true
    }
}
```

<br/>
<br/>
<br/>
<br/>


# Priority Queue

![Priority Queue](https://blog.kakaocdn.net/dn/bSIVIX/btsGrgVXSzw/U02CvYmjzoKX83HKfaGT01/img.png)

- 우선순위 큐는 일반적인 큐(FIFO)와 달리, 우선순위가 높은 요소를 먼저 처리한다.

- 우선순위 결정 방식은 다음과 같다.
  + 숫자가 작을수록 높은 우선순위 (Min Heap)
  + 숫자가 클수록 높은 우선순위 (Max Heap)
  + 사용자가 정한 기준에 따라 설정 (중요도, 기한 등)

- 우선순위에 따라 요소가 정렬되고, 삽입 순서와 관계 없이 우선순위가 높은 요소가 먼저 제거된다.

- 이진 힙(Binary Heap)으로 구현된다.

- 삽입과 삭제가 O(log N)으로 빠르며, 최우선순위 요소를 O(1)로 조회할 수 있다.

- 사용 사례
  + 최단 경로 탐색(Dijkstra) : 가장 짧은 경로를 먼저 탐색하기 위해 사용된다.
  + A 탐색 알고리즘 : 예상 비용이 낮은 경로를 우선적으로 탐색하기 위한 휴리스틱 알고리즘에 사용된다.
  + 데이터 스트림 : 많은 데이터가 지속적으로 입력될 때, 특정 순위의 데이터를 유지하는 문제에서 사용된다. (ex. 가장 인기있는 검색어)


<br/>

## 사용 예제

```java
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        // 기본 PriorityQueue (Min Heap)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // Max Heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        minHeap.add(10);
        minHeap.add(5);
        minHeap.add(30);
        minHeap.add(3);
        minHeap.add(8);

        // 최우선순위 요소 확인
        System.out.println(pq.peek()); // 3

        while (!minHeap.isEmpty()) {
            // 최우선순위 요소 제거 및 반환
            System.out.println(minHeap.remove());  
            // 3, 5, 8, 10, 30
        }
    }
}

```