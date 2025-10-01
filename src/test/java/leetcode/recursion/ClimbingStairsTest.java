package leetcode.recursion;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ClimbingStairsTest {

    @Test
    void test() {
        ClimbingStairs stairs = new ClimbingStairs();
        int actual = stairs.climbStairs(45);
        assertThat(actual).isEqualTo(3);
    }
}
