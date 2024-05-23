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