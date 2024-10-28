### 시간복잡도
- 알고리즘의 복잡도를 나타내는 지표 중 하나
- 입력 크기에 대해 프로그램의 동작시간을 가늠해볼 수 있는 수단
- 편의상 1초에 약 1억 번 연산을 기준으로 소요시간을 가늠할 수 있다 (절대적 기준이 아닌 상대적 지표)
- O(1) > O(log N) > O(N) > O(N log N) > O(N2) > O(N^2) > O(2^N) > O(!N)

### HashSet
- unordered Collection
- 삽입/삭제/조회 연산: O(1) 시간복잡도

### TreeSet
- Binary Search Tree를 기반으로 한 ordered Collection
- 삽입/삭제/조회 연산: 0(log(size))
- null 저장 불가

### 누적합 / Prefix Sum
- N 개의 수열에서 0 ~ i 인덱스의 수를 모두 더하여 i번째 열에 저장하는 방식
- i ~ j 인덱스의 수를 모두 더한 값(구간합)을 구할 때 반복문을 사용하지 않고 값을 계산할 수 있다
- 시간 복잡도 측면에서 효율적
```java
//  누적합 배열 구하는 예시
public int[] prefixSum(int[] array) {
    int[] result = new int[array.length];
    for (int i = 0; i <= array.length; i++) {
        if (i == 0) {
            result[i] = array[i];
            continue;
        }
        result[i] = result[i - 1] + array[i];
    }
    return result;
}
```

### 이분탐색 (Binary Search)
- 정렬되어 있는 집합에서 원하는 값을 찾는 효율적인 탐색 방법
- O(log N) 시간복잡도
- 중간값을 기준으로 탐색 범위를 반으로 줄여나가는 방식
```java
// 정렬되어있는 배열에서 x값이 존재하는지 
// 이분탐색 구현 예시
boolean isExist(int[] arr, int x) {
    int l = 0;
    int r = arr.length - 1;
    while (l <= r) {
        int m = (l + r) / 2;
        if (arr[m] < x) {
            l = m + 1;
            continue;
        }
        if (arr[m] > x) {
            r = m - 1;
            continue;
        }
        return true;
    }
    return false;
}
```

### 투 포인터 (Two Pointer)
- 선형 데이터 구조에서 두 개의 인덱스를 관리하여 특정 조건을 만족하는 부분집합이나 특정 값을 찾는 알고리즘
1. 투 포인터(인덱스)를 시작점으로 초기화 한다.
2. 규칙에 따라 포인터를 이동시킨다.
    - 같은 배열에서 동일한 방햐응로 이동하는 투 포인터
    - 같은 배열에서 마주보는 방향응로 이동하는 투 포인터
    - 서로 다른 배열에서 이동하는 투 포인터
    - 여러 형태에서 효율적인 시간복잡도를 가진다.
3. 두 포인터 중 하나 혹은 둘 모두가 끝에 도달할 때까지 반복한다.

### 큐 (Queue)
- FIFO(First In First Out) 구조
```java
add (E e); // 원소를 큐에 추가 큐에 공간이 없다면 IllegalStateException 발생
offer (E e); // 원소를 큐에 추가 큐에 공간이 없다면 false 반환
remove(); // 큐의 첫 번째 원소를 제거하고 반환 큐가 비어있다면 NoSuchElementException 발생
poll(); // 큐의 첫 번째 원소를 제거하고 반환 큐가 비어있다면 null 반환
element(); // 큐의 head 원소를 반환 큐가 비어있다면 NoSuchElementException 발생
peek(); // 큐의 첫 번째 원소를 반환 큐가 비어있다면 null 반환
```