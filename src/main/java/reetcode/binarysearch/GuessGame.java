package reetcode.binarysearch;

import java.util.Random;

public class GuessGame {

    private final int number = new Random().nextInt(Integer.MAX_VALUE);

    int guess(int num) {
        return Integer.compare(num, number);
    }

    public int guessNumber(int n) {
        int low = 0;
        int high = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int guess = guess(mid);
            if (guess == 0) {
                return mid;
            }
            if (guess == -1) {
                high = mid - 1;
                continue;
            }
            if (guess == 1) {
                low = mid + 1;
            }
        }

        return -1;
    }
}