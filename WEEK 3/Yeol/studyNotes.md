# 투 포인터(Two Pointers) & 슬라이딩 윈도우(Sliding Window)

## 1. 투 포인터 (Two Pointers)

### 개념

- 배열이나 리스트에서 두 개의 포인터를 사용하여 문제를 해결하는 기법.
- 보통 **정렬된 배열**에서 특정 조건을 만족하는 쌍을 찾거나 구간을 탐색할 때 사용됨.
- **O(N)** 또는 **O(N log N)** 의 시간 복잡도로 문제를 해결할 수 있음.

### 예제 문제

**[합이 특정 값이 되는 두 수 찾기]**

- 정렬된 배열이 주어졌을 때, 두 수의 합이 `target`이 되는 쌍이 존재하는지 확인하는 문제.

```
배열: [1, 3, 4, 6, 8, 10, 12], target = 10
   L →                   ← R
1. nums[L] + nums[R] = 1 + 12 = 13 (너무 큼) → R 감소
   L →              ← R
2. nums[L] + nums[R] = 1 + 10 = 11 (너무 큼) → R 감소
   L →         ← R
3. nums[L] + nums[R] = 1 + 8 = 9 (너무 작음) → L 증가
      L →     ← R
4. nums[L] + nums[R] = 3 + 8 = 11 (너무 큼) → R 감소
      L →  ← R
5. nums[L] + nums[R] = 3 + 6 = 9 (정답!)
```

### 자바 코드

```java
public class TwoPointersExample {
    public static boolean hasPairWithSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) return true;
            else if (sum < target) left++;
            else right--;
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 6, 8, 10, 12};
        int target = 9;
        System.out.println(hasPairWithSum(nums, target)); // true
    }
}
```

---

## 2. 슬라이딩 윈도우 (Sliding Window)

### 개념

- 일정한 크기의 **윈도우(구간)** 를 유지하면서 배열을 탐색하는 기법.
- 윈도우를 한 칸씩 이동하면서 값을 갱신하여 **O(N)** 시간 복잡도로 최적의 값을 찾을 수 있음.
- 연속된 부분 배열의 최대/최소 값, 합, 평균 등을 구할 때 많이 사용됨.

### 예제 문제

**[연속된 K개의 숫자의 최대 합 구하기]**

- 배열에서 연속된 `k`개의 숫자의 최대 합을 구하는 문제.

```
배열: [2, 1, 5, 1, 3, 2], k = 3
윈도우: (2, 1, 5) → 합 = 8
       (1, 5, 1) → 합 = 7
       (5, 1, 3) → 합 = 9 (최댓값)
       (1, 3, 2) → 합 = 6
최댓값 = 9
```

### 자바 코드

```java
public class SlidingWindowExample {
    public static int maxSumSubarray(int[] nums, int k) {
        int maxSum = 0, windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        maxSum = windowSum;
        
        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        
        return maxSum;
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println(maxSumSubarray(nums, k)); // 9
    }
}
```

---

## 3. 투 포인터 vs 슬라이딩 윈도우 비교

| 기법           | 언제 사용?                                   | 시간 복잡도 |
| ------------ | ---------------------------------------- | ------ |
| **투 포인터**    | 정렬된 배열에서 두 개의 포인터를 사용하여 특정 조건을 만족하는 값 찾기 | O(N)   |
| **슬라이딩 윈도우** | 연속된 부분 배열의 최댓값, 최솟값, 합 등을 빠르게 구할 때       | O(N)   |
