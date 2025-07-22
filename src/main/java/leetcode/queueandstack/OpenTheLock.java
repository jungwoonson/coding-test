package leetcode.queueandstack;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class OpenTheLock {

    // Constraints:
    // 1 <= deadends.length <= 500
    // deadends[i].length == 4
    // target.length == 4
    // target will not be in the list deadends.
    // target and deadends[i] consist of digits only.
    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>(List.of(deadends));
        Queue<String> queue = new LinkedList<>();
        String startNumber = "0000";
        if (deadSet.contains(startNumber)) {
            return -1;
        }

        queue.add(startNumber);
        deadSet.add(startNumber);
        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                String currentNumber = queue.poll();
                if (currentNumber.equals(target)) {
                    return count;
                }

                char[] currentNumberArray = currentNumber.toCharArray();
                for (int i = 0; i < 4; i++) {
                    char origin = currentNumberArray[i];
                    currentNumberArray[i] = origin == '9' ? '0' : (char) (origin + 1);
                    String operatedNumber = new String(currentNumberArray);
                    if (!deadSet.contains(operatedNumber)) {
                        queue.add(operatedNumber);
                        deadSet.add(operatedNumber);
                    }
                    currentNumberArray[i] = origin;
                }

                for (int i = 0; i < 4; i++) {
                    char origin = currentNumberArray[i];
                    currentNumberArray[i] = origin == '0' ? '9' : (char) (origin - 1);
                    String operatedNumber = new String(currentNumberArray);
                    if (!deadSet.contains(operatedNumber)) {
                        queue.add(operatedNumber);
                        deadSet.add(operatedNumber);
                    }
                    currentNumberArray[i] = origin;
                }
            }
            count++;
        }

        return -1;
    }
}
