package leetcode.binarysearchtree;

import java.util.PriorityQueue;

public class KthLargest {

    // Constraints:
    // 0 <= nums.length <= 10^4
    // 1 <= k <= nums.length + 1
    // -10^4 <= nums[i] <= 10^4
    // -10^4 <= val <= 10^4
    // At most 104 calls will be made to add.

    private final int k;
    private final PriorityQueue<Integer> pq = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int n : nums) {
            pq.offer(n);
            if (pq.size() > k) {
                pq.poll();
            }
        }
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}
