# 1. 정렬

## - 선택정렬

### [개념]
- 선택정렬은 정렬되지 않은 데이터들에 대해 가장 작은 데이터를 찾아 가장 앞의 데이터와 교환해나가는 방식임.

### [과정]
1. 주어진 리스트 중 최소값을 찾는다.
2. 그 값을 리스트의 맨 앞에 위치한 값과 교체한다.
3. 교체한 위치를 제외한 나머지 리스트를 같은 방법으로 앞에서부터 교체한다.

### [시간 복잡도]
- n개의 데이터 개수가 있을 때, 2번의 for루프로 정렬을 시킨다. 따라서 (n-1)만큼 반복하고 그 안에서 (n-(i+1)) 만큼 또 반복한다. 즉, O(n^2) 로 표현할 수 있다.

### [비교]
- 같은 시간 복잡도 O(n^2)를 가진 삽입 정렬, 버블 정렬과 비교해보면
    - 버블 정렬보다 교환 횟수가 적기에 항상 선택 정렬이 우수하다.
    - 선택 정렬은 k번째 반복 후 , k+1번째 요소를 찾기 위해 나머지 요소를 탐색하지만, 삽입 정렬은 필요한 만큼만 탐색하기에 훨씬 효율적으로 실행된다.

### [선택 정렬 구현하기]
```java
public class Selection_Sort{
    public static void selection_sort(int[] a){
        selectrion_sort(a, a.length);
    }
    private static void selection_sort(int[] a, int size){
        for(int i = 0; i<size-1; i++){
            int min_index = i;
        

                //최솟값을 갖고있는 인덱스 찾기
            for(int j = i+1; j<size; j++){
                if(a[j]<a[min_index]){
                    min_index = j;
                }
            }

            // i 번째 값과 찾은 최솟값을 서로 교환
            swap(a, min_index, i_);
        }
    }
    private static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
```
## - 버블 정렬(Bubble Sort)
### [개념]
- 두 개의 인접한 원소를 비교하여 정렬하는 방식
- 선택 정렬과는 달리 버블 정렬은 앞에서부터 차례대로 비교하기 때문에 '안정 정렬' 임

### [과정]
1. 앞에서부터 현재 원소와 바로 다음의 원소를 비교한다.
2. 현재 원소가 다음 원소보다 크면 원소를 교환한다.
3. 다음 원소로 이동하여 해당 원소와 그 다음 원소를 비교한다.

### [시간 복잡도]
- 일반적으로 swap 여부를 판단할 수 있는 변수를 두지 않고 하는 구현의 경우는 O(N^2), swap 여부를 판단할 수 있는 변수를 둔 경우 O(N)임.

### [버블 정렬 구현]
```java
public class Bubble_Sort{

    public static void bubble_sort(int[] a){
        bubble_sort(a, a.length);
    }
    private static void bubble_sort(int[] a, int size){
        //round는 배열 크기 -1 만큼 진행됨
        for(int i = 1; i<size; i++){
            boolean swapped = false;

            //각 라운드별 비교횟수는 배열 크기의 현재 라운드를 뺀 만큼 비교
            for(int j = 0; j< size-1; j++){
                /**
                 * 현재 원소가 다음 원소보다 클 경우
                 * 서로 원소의 위치를 교환하고
                 * 비교수행을 했다는 표시로 swapped 변수를 true로 변경한다.
                */
               if(a[j]>a[j+1]){
                swap(a, j, j+1);
                swapped = true;
               }
            }
            /**
             * 만약 swap 된 적이 없다면 이미 정렬되었다는 의미이므로
             * 반복문을 종료한다.
            */
           if(swapped == false){
            break;
           }

        }
    }

    private static void swap(int[] a , int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
```

## - 삽입 정렬(Insertion Sort)

### [개념]
- 현재 비교하고자 하는 타겟과 그 이전의 원소들과 비교하며 자리를 교환하는 정렬방법
- 데이터를 비교하면서 찾기 때문에 '비교 정렬' 이며 정렬의 대상이 되는 데이터 외에 추가적인 공간을 필요로 하지 않기 때문에 '제자리 정렬' 이기도 함.
- 안정정렬

### [과정]
1. 현재 타겟이 되는 숫자와 이전 위치에 있는 원소들을 비교(첫 번째 타켓은 두번째 원소부터 시작)
2. 타겟이 되는 숫자가 이전 위치에 있던 원소보다 작다면 위치를 서로 교환한다.
3. 그 다음 타겟을 찾아 위와 같은 방법으로 반복.

### [시간복잡도]
- 거의 정렬된 경우, 즉 최선의 경우 O(N)의 시간복잡도를 갖는다.
    - 타겟 숫자가 이전 숫자보다 크기 전까지 반복하기 때문에 이미 정렬되어 있는 경우 항상 타겟 숫자가 이전 숫자보다 커서 값은 N번만 비교하면 됨.
- 역순에 가까울 수록, 즉 최악의 경우 O(N^2)의 시간 복잡도를 갖는다.
    - 타겟 숫자가 이전 숫지보다 항상 작기 때문에 결국 N번째 숫자에 대하여 n-1번을 비교헤야 됨.

### [삽입정렬 구현]
```java
public class Insertion_Sort{
    public static void insertion_sort(int[] a){
        insertion_sort(a, a.lenght);
    }
    private static void insertion_sort(int[] a, int size){
        for(int i = 1; i<size; i++){
            //타겟 넘버
            int target = a[i];
            int j = i-1;

            //타겟이 이전 원소보다 크기 전까지 반복
            while (j>=0 && target <a[j]){
                a[j+1] = a[j]; // 이전 원소를 한 칸씩 뒤로 미룸
                j--;
            }

            /**
             * 위 반복문에서 탈출하는 경우 앞의 원소가 타겟보다 작다는 의미이므로 
             * 타겟 원소는 j번째 원소 뒤에 와야 한다.
             * 그러므로 타겟은 j+1에 위치하게 됨.
            */
           a[j+1] = target;
        }
    }
}
```
## - 카운팅 정렬(Counting Sort)

- 기본 메커니즘은 데이터의 값이 몇 번 나왔는지를 세주는 것.

### [과정]
1. array를 한 번 순회하면서 각 값이 나올 때마다 해당 값을 index로 하는 새로운 배열(counting)의 값을 1 증가시킴
2. counting 배열의 각 값을 누적합으로 변환시킨다.
3. counting 배열의 각 값은 (시작점 - 1)을 알려줌. 해당 값에 대응되는 위치에 배정하면 됨.

### [단점]
- counting 배열이라는 새로운 배열을 선언해줘야하기 때문에 max 값의 범위가 크면 메모리가 매우 낭비됨.
### [시간복잡도도]
- O(N)

### [카운팅 정렬 구현]
```java
public class CountingSort {
	public static void main(String[] args) {
		
		int[] array = new int[100];		// 수열의 원소 : 100개
		int[] counting = new int[31];	// 수의 범위 : 0 ~ 30
		int[] result = new int[100];	// 정렬 될 배열 
		
		for(int i = 0; i < array.length; i++) {
			array[i] = (int)(Math.random()*31);	// 0 ~ 30
		}
 
		
		// Counting Sort
		// 과정 1 
		for(int i = 0; i < array.length; i++) {
			// array 의 value 값을 index 로 하는 counting 배열 값 1 증가 
			counting[array[i]]++;			
		}
		
		// 과정 2 
		for(int i = 1; i < counting.length; i++) {
			// 누적 합 해주기 
			counting[i] += counting[i - 1];
		}
		
		// 과정 3
		for(int i = array.length - 1; i >= 0; i--) {
			/*
			 *  i 번쨰 원소를 인덱스로 하는 counting 배열을 1 감소시킨 뒤 
			 *  counting 배열의 값을 인덱스로 하여 result에 value 값을 저장한다.
			 */
			int value = array[i];
			counting[value]--;
			result[counting[value]] = value;
		}
		
		
		
		/* 비교 출력 */
		
		// 초기 배열 
		System.out.println("array[]");
		for(int i = 0; i < array.length; i++) {
			if(i % 10 == 0) System.out.println();
			System.out.print(array[i] + "\t");
		}
		System.out.println("\n\n");
		
		
		// Counting 배열 
		System.out.println("counting[]");
		for(int i = 0; i < counting.length; i++) {
			if(i % 10 == 0) System.out.println();
			System.out.print(counting[i] + "\t");
		}
		System.out.println("\n\n");
		
		
		// 정렬된 배열
		System.out.println("result[]");
		for(int i = 0; i < result.length; i++) {
			if(i % 10 == 0) System.out.println();
			System.out.print(result[i] + "\t");
		}
		System.out.println();
	}
 
}
```

## - 병합 정렬(Merge Sort)

### [개념]
- 정렬해야 할 리스트가 주어지면 해당 리스트 분할을 반복하며 최대한 작게 쪼개진 시점에 부분 리스트에서 인접한 원소들끼리 비교하여 정렬하는 방식
- 비교정렬, 안정정렬

### [과정]
1. 주어진 리스트를 절반으로 분할하여 부분리스트로 나눔
2. 해당 부분리스트의 길이가 1이 아니라면 1번 과정를 되풀이함.
3. 인접한 부분리스트끼리 정렬하여 합침

### [시간 복잡도]
- O(NlogN)

### [병합 정렬 구현]
```java
//Bottom-up 형식
public class Merge_Sort {
 
	private static int[] sorted;		// 합치는 과정에서 정렬하여 원소를 담을 임시배열
	
	public static void merge_sort(int[] a) {
		
		sorted = new int[a.length];
		merge_sort(a, 0, a.length - 1);
		sorted = null;
	}
	
	// Bottom-Up 방식 구현
	private static void merge_sort(int[] a, int left, int right) {
		
		/*
		 * 1 - 2 - 4 - 8 - ... 식으로 1부터 서브리스트를 나누는 기준을 두 배씩 늘린다.
		 */
		for(int size = 1; size <= right; size += size) {
			
			/*
			 * 두 부분리스트을 순서대로 병합해준다.
			 * 예로들어 현재 부분리스트의 크기가 1(size=1)일 때
			 * 왼쪽 부분리스트(low ~ mid)와 오른쪽 부분리스트(mid + 1 ~ high)를 생각하면
			 * 왼쪽 부분리스트는 low = mid = 0 이고,
			 * 오른쪽 부분리스트는 mid + 1부터 low + (2 * size) - 1 = 1 이 된다.
			 *  
			 * 이 때 high가 배열의 인덱스를 넘어갈 수 있으므로 right와 둘 중 작은 값이
			 * 병합되도록 해야한다. 
			 */
			for(int l = 0; l <= right - size; l += (2 * size)) {
				int low = l;
				int mid = l + size - 1;
				int high = Math.min(l + (2 * size) - 1, right);
				merge(a, low, mid, high);		// 병합작업
			}
		}
		
		
		
	}
	
	/**
	 * 합칠 부분리스트는 a배열의 left ~ right 까지이다. 
	 * 
	 * @param a		정렬할 배열
	 * @param left	배열의 시작점
	 * @param mid	배열의 중간점
	 * @param right	배열의 끝 점
	 */
	private static void merge(int[] a, int left, int mid, int right) {
		int l = left;		// 왼쪽 부분리스트 시작점
		int r = mid + 1;	// 오른쪽 부분리스트의 시작점 
		int idx = left;		// 채워넣을 배열의 인덱스
		
		
		while(l <= mid && r <= right) {
			/*
			 *  왼쪽 부분리스트 l번째 원소가 오른쪽 부분리스트 r번째 원소보다 작거나 같을 경우
			 *  왼쪽의 l번째 원소를 새 배열에 넣고 l과 idx를 1 증가시킨다.
			 */
			if(a[l] <= a[r]) {
				sorted[idx] = a[l];
				idx++;
				l++;
			}
			/*
			 *  오른쪽 부분리스트 r번째 원소가 왼쪽 부분리스트 l번째 원소보다 작거나 같을 경우
			 *  오른쪽의 r번째 원소를 새 배열에 넣고 r과 idx를 1 증가시킨다.
			 */
			else {
				sorted[idx] = a[r];
				idx++;
				r++;
			}
		}
		
		/*
		 * 왼쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우 (l > mid)
		 * = 오른쪽 부분리스트 원소가 아직 남아있을 경우
		 * 오른쪽 부분리스트의 나머지 원소들을 새 배열에 채워준다.
		 */
		if(l > mid) {
			while(r <= right) {
				sorted[idx] = a[r];
				idx++;
				r++;
			}
		}
		
		/*
		 * 오른쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우 (r > right)
		 * = 왼쪽 부분리스트 원소가 아직 남아있을 경우
		 * 왼쪽 부분리스트의 나머지 원소들을 새 배열에 채워준다.
		 */
		else {
			while(l <= mid) {
				sorted[idx] = a[l];
				idx++;
				l++;
			}
		}
		
		/*
		 * 정렬된 새 배열을 기존의 배열에 복사하여 옮겨준다.
		 */
		for(int i = left; i <= right; i++) {
			a[i] = sorted[i];
		}
	}
}

```
## - 퀵 정렬(Quick Sort)

### [개념]
- 하나의 리스트를 피번(pivot)을 기준으로 두 개의 부분리스트로 나누어 하나는 피벗보다 작은 값들의 부분리스트, 다른 하나는 피벗보다 큰 값들의 부분리스트로 정렬한 다음, 각 부분리스트에 대해 다시 위 처럼 재귀적으로 수행하여 정렬하는 방법.
- 비교 정렬, 제자리 정렬, 불안정 정렬렬

### [과정]
1. 피벗을 하나 선택
2. 피벗을 기준으로 양쪽에서 피벗보다 큰 값, 혹은 작은 값을 찾는다. 왼쪽에서부터는 피벗보다 큰 값을 찾고, 오른쪽에서부터는 피벗보다 작은 값을 찾음.
3. 양 방향에서 찾은 두 원소를 교환
4. 왼쪽에서 탐색하는 위치와 오른쪽에서 탐색하는 위치가 엇갈리지 않을 때 까지 2번으로 돌아가 위 과정을 반복
5. 엇갈린 기점을 기준으로 두 개의 부분리스트로 나누어 1번으로 돌아가 해당 부분리스트의 길이가 1이 아닐때까지 1번 과정을 반복
6. 인접한 부분리스트끼리 합침.

### [시간복잡도도]
- 특정 상태가 아닌 이상 평균 시간 복잡도는 NlogN이며, 다른 NlogN 알고리즘에 비해 대체적으로 속도가 매우 빠름. 

### [구현 방식]
- 왼쪽 피벗 선택 방식
- 오른쪽 피벗 선택 방식
- 중간 피벗 선택 방식

## - 힙 정렬(Heap Sort)

### [과정]
1. 최대 힙 만들기
2. 정렬하기

### [시간 복잡도]
- 최악의 경우에도 O(NlogN)

# 2. 이분 탐색(Binary Search)

- 배열의 중앙에 있는 값을 조사하여 찾고 하는 항목이 왼쪽 또는 오른쪽 부분 배열에 있는지를 알아내어 탐색의 범위를 반으로 줄인다.
- 찾고자 하는 값이 속해있지 않은 부분은 전혀 고려할 필요가 없기 때문에, 매 단계에서 검색해야 할 리스트의 크기를 반으로 줄 일 수 있다.
- 이러한 방법을 반복적으로 사용해 탐색하는 방법이 이진 탐색이다.
- 데이터의 삽입이나 삭제가 빈번할 시에는 적합하지 않고, 주로 고정된 데이터에 대한 탐색에 적합하다.

### [시간 복잡도]
- O(logn)

### [구현]

```java
public class BinarySearch {
	static int[] arr = {1, 3, 5, 7, 8, 10, 20, 35, 99, 100};

	public static void main(String[] args) {
		System.out.println("1. 순환 호출을 이용한 이진 탐색");
		System.out.println(binarySearch1(5, 0, arr.length-1)); // 2
		
		System.out.println("\n2. 반복을 이용한 이진 탐색");
		System.out.println(binarySearch2(20, 0, arr.length-1)); // 6
		
	}
	
	// 재귀적 탐색
	static int binarySearch1(int key, int low, int high) {
		int mid;
		
		if(low <= high) {
			mid = (low + high) / 2;
			
			if(key == arr[mid]) { // 탐색 성공 
				return mid;
			} else if(key < arr[mid]) {
				return binarySearch1(key ,low, mid-1); // 왼쪽 부분 탐색 
			} else {
				return binarySearch1(key, mid+1, high); // 오른쪽 부분 탐색 
			}
		}
		
		return -1; // 탐색 실패 
	}
	
	// 반복적 탐색
	static int binarySearch2(int key, int low, int high) {
		int mid;
		
		while(low <= high) {
			mid = (low + high) / 2;
			
			if(key == arr[mid]) {
				return mid;
			} else if(key < arr[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		
		return -1; // 탐색 실패 
	}

}
```
