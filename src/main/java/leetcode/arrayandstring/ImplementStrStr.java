package leetcode.arrayandstring;

public class ImplementStrStr {
    // Constraints:
    // 1 <= haystack.length, needle.length <= 10^4
    // haystack and needle consist of only lowercase English characters.

    // 처음에는 투 포인터로 접근하여 O(n)으로 풀고싶었지만
    // haystack = "sassas", needle = "ssas"
    // 반복되는 char 존재하는 경우에는 의도치않게 비교하지 않고 지나가기 때문에 사용할 수 없었음
    // 대신 O(n^2)이 되지 않게 haystack을 루프하며 needle보다 작은 길이가 남았을 때 반복을 멈출 수 있도록 구현
    public int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            if (needle.length() > haystack.length() - i) {
                return -1;
            }
            boolean flag = true;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

    // 2중 반복문 보다 substring(), equals()를 쓰는 것이 훨신 빠르다
    // 이유는 JVM에서 equals() 메서드가 빠르게 동작할 수 있도로록 최적화 되어 있기 때문에
    // charAt()으로 하나씩 비교하는 것 보다 빠르게 동작한다
    public int strStr2(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            if (needle.length() > haystack.length() - i) {
                return -1;
            }
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
