package reetcode.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {

    // Constraints:
    // The number of the nodes in the tree will be in the range [1, 5000]
    // -200 <= Node.val <= 200
    Map<String, Integer> countMap = new HashMap<>();
    List<TreeNode> result = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return result;
    }

    // 서브트리를 문자열로 직렬화 (후위 순회 사용)
    private String serialize(TreeNode node) {
        if (node == null) {
            return "#";  // null은 #로 표현
        }

        // 왼쪽, 오른쪽 서브트리를 먼저 직렬화
        String left = serialize(node.left);
        String right = serialize(node.right);

        // 현재 노드를 포함한 전체 서브트리를 문자열로 표현
        String subtree = node.val + "," + left + "," + right;

        // 해당 문자열의 등장 횟수를 기록
        countMap.put(subtree, countMap.getOrDefault(subtree, 0) + 1);

        // 중복이 처음 발견되었을 때만 결과에 추가
        if (countMap.get(subtree) == 2) {
            result.add(node);
        }

        return subtree;
    }

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
