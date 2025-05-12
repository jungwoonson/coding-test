package reetcode.array;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                k++;
                continue;
            }
            nums[i - k] = nums[i];
        }
        return nums.length - k;
    }
}
