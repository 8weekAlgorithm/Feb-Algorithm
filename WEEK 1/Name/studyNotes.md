# 1. 스택(Stack)

### 스택(Stack) 자료구조

**1) 스택(Stack)의 특성**
- 자료를 쌓아 올린 형태의 자료구조
- Stack에 저장된 자료는 선형구조를 가짐 ( 선형 구조 : 자료 간의 관계가 1대 1의 관계를 가짐)
- LIFO : Last-In-First_Out -> Stack에 마지막에 삽입한 자료가 가장 먼저 꺼내어짐

**2) 스택(Stack)의 구현**
- 삽입 
  - 저장소에 자료를 저장
  - push 라고 부름 : top의 위치가 증가
- 삭제
  - 저장소에서 자료를 꺼냄
  - 삽입한 자료의 역순으로 꺼냄
  - pop 이라고 부름 : top의 위치가 감소
- isEmpty
  - 스택(Stack)이 공백인지 아닌지를 확인하는 연산
- peek
  - 스택(Stack)의 top에 있는 item(원소)을 반환하는 연산

**3) 스택(Stack)의 응용**
- 괄호 검사
- 함수 호출 관리(Function call)
  - 가장 마지막에 호출된 함수가 가장 먼저 실행을 완료하고 복귀
  1) 함수 호출이 발생ㄹ하면 호출한 함수 수행에 필요한 지역변수, 매개변수 및 수행 후 복귀할 주소 등의 정보를 Stack 프레임에 저장하여 시스템 Stack에 삽입
  2) 함수의 실행이 끝나면 시스템 Stack의 top원소 (Stack 프레임)를 pop 하면서 프레임에 저장되어있던 복귀주소를 확인하고 복귀
  3) 함수 호출과 복귀에 따라 이 과정을 반복하여 전체 프로그램 수행이 종료되면 시스템 Stack은 공백 Stack이 됨
- 재귀 호출
  - Factorial
  - 피보나치 수열
- DFS(깊이우선탐색) 방법
  1) 시작 정점의 한 방향으로 갈 수 있는 경로가 있는 곳까지 깊이 탐색
  2) 더 이상 갈 곳이 없게 되면, 가장 마지막에 만났던 갈림길 간선이 있는 정점으로 돌아옴
  3) 다른 방향의 정점으로 탐색을 계속 반복하여 결국 모든 정점을 방문하여 순회

  - 가장 마지막에 만났던 갈림길의 정점으로 되돌아가서 다시 깊이우선탐색을 반복해야 하므로 후입선출 구조의 Stack을 사용
```java
import java.util.Stack;
public class Main{
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<> (); // push, pop, peek, empty, seach 지원
  }
}

//제공하는 Stack 사용하지 않고 구현하기
public class ArrayStack{
  int top;
  int size;
  int [] stack;
  public ArrayStack(int size){
    this.size = size;
    stack = new int[size];
    top = -1;
  }

  public void push(int item){
    stack[++top] = item;
    System.out.println(stack[top]+ " Push!");
  }
  public void pop(){
    System.out.println(stack[top] + " Pop!");
    int pop = stack[top];
    stack[top--] = 0;
  }
  public void peek(){
    System.out.println(stack[top]+" Peek!");
  }
}
```

# 2. 큐(Queue)

### 큐 (Queue) 자료구조

**1) 큐(Queue)의 특성**
- 삽입, 삭제의 위치가 제한적인 자료구조
  - 큐 (Queue) 뒤 : 삽입 / 큐(Queue) 앞 : 삭제
- 선입선출구조(FIFO : First In First Out)
  - 큐(Queue)에 삽입한 순서대로 원소가 저장
  - 가장 먼저 삽입(First In)된 원소는 가장 먼저 삭제(First Out) 됨
- Queue의 예 : 서비스 대기 행렬

**2) 큐(Queue)의 종류**
- 선형 Queue
  - 간단하고 기본적인 형태
  - 배열 사용
- 원형 Queue
  - 선형에서 발전된 형태
  - 배열 사용
- 연결 Queue
  - 리스트 형식 사용
- 우선순위 Queue

**3) 큐(Queue)의 활용**
- 버퍼
- BFS(너비 우선 탐색)
  - 시작점의 인접한 정점들을 모두 차례로 방문한 후 방문했던 정점을 시작점으로 하여 다시 인접한 정점들을 차례로 방문하는 방식
  - 인접한 정점들을 탐색한 후, 차례로 너비 우선 탐색을 진행해야 하므로, 선입선출 형태의 자료구조인 Queue 활용

```java
//isFull() : 큐가 꽉 찼는지 확인하는 함수
public boolean isFull(){
  return front == rear && queue[front] != null;
}

//isEmpty() : 큐가 비었는지 확인하는 함수
public boolean isEmpty(){
  return front == rear && queue[front] == null;
}

//enqueue() : 큐에 데이터를 넣는 함수
public void enqueue(Object data){
  if(isFull()){
    System.out.println("큐에 더 이상 데이터를 저장할 공간이 없습니다.");
    return;
  }
  queue[rear++] = data;
  rear = rear % queue.length;
}

//dequeue() : 큐에서 데이터를 꺼내는 함수
public Object dequeue(){
  if(isEmpty()){
    System.out.println("큐가 비어있습니다.");
    trhow new ArrayIndexOutOfBoundsException();
  }
  Object dequeueData = queue[front];
  queue[front++] = null;
  front = front % queue.length;

  return dequeueData;
}
```
# 3. 우선순위 Queue
- 우선순위를 가진 항목들을 저장하는 큐
- FIFO 순서가 아니라 우선순위가 높은 순서대로 먼저 나가게 됨

**적용 분야**
- 시뮬레이션 시스템
- 네트워크 트래픽 제어
- 운영체제의 태스크 스케줄링

**구현**
- 배열 이용한 우선순위 Queue의 구현
  - 배열을 이용하여 자료 저장
  - 원소를 삽입하는 과정에서 우선순위를 비교하여 적절한 위치에 삽입하는 구조
  - 가장 앞에 최고 우선순위의 원소가 위치하게 됨

  => 문제점 
    - 배열을 사용하므로, 삽입이나 삭제 연산이 일어날때 원소의 재배치가 발생
    - 소요되는 시간, 메모리 낭비가 큼

- 리스트를 이용한 우선순위 Queue

