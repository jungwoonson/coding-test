package leetcode.binarysearchtree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ValidateBinarySearchTreeTest {

    @Test
    public void test() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        ValidateBinarySearchTree tree = new ValidateBinarySearchTree();

        boolean actual = tree.isValidBST(root);

        assertThat(actual).isFalse();
    }
}
