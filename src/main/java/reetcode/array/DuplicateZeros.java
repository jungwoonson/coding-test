package reetcode.array;

public class DuplicateZeros {
    // Constraints:
    // 1 <= arr.length <= 10^4
    // 0 <= arr[i] <= 9

    // 시간 O(n), 공간 O(n)
    public void duplicateZeros(int[] arr) {
        int[] temp = new int[arr.length];
        int index = 0;
        for (int value : arr) {
            if (value == 0) {
                temp[index++] = value;
                if (index == temp.length) {
                    break;
                }
            }
            temp[index++] = value;
            if (index == temp.length) {
                break;
            }
        }
        System.arraycopy(temp, 0, arr, 0, arr.length);
    }

    // 시간 O(n^2), 공간 O(1)
    public void duplicateZeros2(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                for (int j = arr.length - 1; j > i; j--) {
                    arr[j] = arr[j - 1];
                }
                i++;
            }
        }
    }

    // 투포인터를 사용하면 시간 O(n), 공간 O(1) 가능
    public void duplicateZerosOptimal(int[] arr) {
        int n = arr.length;
        // 1) 배열 내 0 개수 세기
        int zeroCount = 0;
        for (int x : arr) {
            if (x == 0) {
                zeroCount++;
            }
        }

        // 2) 읽기(i)와 쓰기(j) 포인터 초기화
        int i = n - 1;
        int j = n - 1 + zeroCount;

        // 3) 뒤에서부터 복사
        while (i >= 0) {
            // j가 유효 범위에 있을 때만 복사
            if (j < n) {
                arr[j] = arr[i];
            }
            // 만약 0이었다면, 한 칸 더 당겨서 0 하나 더 복사
            if (arr[i] == 0) {
                j--;
                if (j < n) {
                    arr[j] = 0;
                }
            }
            i--;
            j--;
        }
    }
}
