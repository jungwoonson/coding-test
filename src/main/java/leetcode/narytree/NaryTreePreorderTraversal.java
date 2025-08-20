package leetcode.narytree;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePreorderTraversal {

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    public void preorder(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        for (Node child : root.children) {
            preorder(child, list);
        }
    }
}
