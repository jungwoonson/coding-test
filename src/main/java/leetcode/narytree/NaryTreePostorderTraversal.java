package leetcode.narytree;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePostorderTraversal {

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }

    public void postorder(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }

        for (Node child : root.children) {
            postorder(child, list);
        }
        list.add(root.val);
    }
}
