# 투 포인터

투 포인터(Two Pointers)는 배열이나 리스트 같은 자료구조에서 두 개의 포인터를 이용해 문제를 해결하는 기법이다.

- 일반적으로 정렬된 데이터에서 사용

- 보통 $O(N)$에서 $O(NlogN)$으로 동작하며, 브루트포스 방식($O(N^2)$)에 비해 효율적으로 문제를 해결할 수 있다.

### 주요 활용 예제

- 정렬된 배열에서 특정 조건을 만족하는 두 개의 요소를 찾는 경우
  + 예) 두 수의 합이 특정 값이 되는 두 요소 찾기

- 중복을 제거하거나 특정 패턴을 유지하면서 배열을 탐색하는 경우
  + 예) 두 배열의 공통 요소 찾기, 배열을 정렬하면서 중복 요소 제거하기

- 특정 조건을 만족하는 부분 배열을 찾는 경우
  + 예) 연속된 숫자의 합이 특정 값을 넘지 않도록 하는 최적의 부분 배열 찾기

### 예제 코드
정렬된 배열에서 두 수의 합이 특정 값과 같은 경우 찾기
```java
public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 8, 11}; // 정렬된 배열
        int target = 10;
        int left = 0, right = nums.length - 1;

        boolean found = false;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                found = true;
                break;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(found); // true (2 + 8)
    }
}
```

<br/>

# 슬라이딩 윈도우

슬라이딩 윈도우(Sliding Window)는 연속된 부분 배열의 합, 곱, 길이 등의 값을 효율적으로 구하기 위한 기법이다.

- 모든 요소를 한 번만 살피기 때문에 일반적으로 $O(N)$으로 동작한다.

### 주요 활용 예제

- 고정 크기 윈도우
  + 예) 길이가 K인 부분 배열의 최댓값 또는 최솟값을 찾기

- 가변 크기 윈도우
  + 예) 특정 합 이상을 갖는 최소 길이의 부분 배열 찾기


### 예제 문제
길이가 K인 부분 배열의 최대 합 구하기

```java
public class Main {
    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 1, 3, 2};
        int k = 3;
        int maxSum = 0, windowSum = 0;
        
        // 첫 윈도우 합
        for (int i = 0; i < k; i++) windowSum += nums[i];
        maxSum = windowSum;

        for (int i = k; i < nums.length; i++) {
            // 새 요소 추가, 이전 요소 제거
            windowSum += nums[i] - nums[i - k]; 
            maxSum = Math.max(maxSum, windowSum);
        }

        System.out.println(maxSum); // 9 (5+1+3)
    }
}
```