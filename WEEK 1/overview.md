# 스택, 큐, 우선순위 큐

### 💡 필수 내용

- **스택 (Stack)**
  + 후입선출(LIFO, Last In First Out). 가장 마지막에 들어온 데이터가 가장 먼저 나간다.

- **큐 (Queue)**
  + 선입선출(FIFO, First In First Out). 가장 먼저 들어온 데이터가 가장 먼저 나간다.

- **우선순위 큐 (Priority Queue)**
  + 큐의 한 종류로, 우선순위가 높은 요소가 먼저 처리된다.

<br/>

### ❓ 유용한 내용

- `Stack`과 `Queue` 클래스를 사용해야 하는가?
  + 두 클래스는 레거시 자료구조로, 사용이 권장되지 않는다.

  + **덱(Deque)** 에 대해 알아보자.
  + `ArrayDeque`, `LinkedList`는 스택과 큐의 모든 동작을 지원한다. 
    + `ArrayDeque`: 배열 기반. 더 빠르고 메모리를 효율적으로 사용한다.
    + `LinkedList`: 연결 리스트 기반. 중간 삽입/삭제에 유리하지만 메모리 사용량이 크다.

- 주요 메서드의 **시간복잡도(Big-O)** 는 확인했는가?
  + 스택과 큐에서 맨 앞 요소를 조회할 때는 O(1)이 걸리지만, 특정 값을 검색하기 위해서는 O(N)의 시간이 걸린다.

- 스택과 큐는 **연결 리스트** 기반으로 구현되고, 우선순위 큐는 **힙** 자료구조를 기반으로 구현된다는 걸 알고 있는가?
  + 완전 이진 트리 **힙(heap)** 에 대해 알아보자.

<br/>

### 📂 기본 문제

- 스택, 큐 : [백준 28279](https://www.acmicpc.net/problem/28279)
- 우선순위 큐 : [백준 11279](https://www.acmicpc.net/problem/11279)

<br/>

 ### 📂 응용 문제

- 스택, 큐
  + 실버3 | [백준 1966](https://www.acmicpc.net/problem/1966)
  + 실버2 | [백준 1874](https://www.acmicpc.net/problem/1874)

- 우선순위 큐
  + 실버1 | [백준 15903](https://www.acmicpc.net/problem/15903)
  + 골드4 | [백준 1715](https://www.acmicpc.net/problem/1715)

