package reetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

public class MinimumIndexSumOfTwoLists {

    // Constraints:
    // 1 <= list1.length, list2.length <= 1000
    // 1 <= list1[i].length, list2[i].length <= 30
    // list1[i] and list2[i] consist of spaces ' ' and English letters.
    // All the strings of list1 are unique.
    // All the strings of list2 are unique.
    // There is at least a common string between list1 and list2.
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < list2.length; i++) {
            map2.put(list2[i], i);
        }
        Map<String, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++) {
            if (map1.containsKey(list1[i]) && map2.containsKey(list1[i])) {
                int sum = map1.get(list1[i]) + map2.get(list1[i]);
                if (min == sum) {
                    map.put(list1[i], sum);
                    continue;
                }
                if (sum < min) {
                    map.clear();
                    min = sum;
                    map.put(list1[i], sum);
                }
            }
        }
        return map.keySet().toArray(new String[0]);
    }
}
