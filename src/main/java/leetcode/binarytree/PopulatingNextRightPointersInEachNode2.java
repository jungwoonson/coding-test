package leetcode.binarytree;

public class PopulatingNextRightPointersInEachNode2 {

    // Constraints:
    // The number of nodes in the tree is in the range [0, 2^12 - 1].
    // -1000 <= Node.val <= 1000

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        // 현재 루트의 자식들이 가리킬 "같은 레벨의 다음 자식"을 찾는다
        Node nextChildOnSameLevel = findNextChild(root.next);

        // 오른쪽 자식 next: 같은 레벨에서 다음 자식으로
        if (root.right != null) {
            root.right.next = nextChildOnSameLevel;
        }

        // 왼쪽 자식 next: 우선 형제(right)가 있으면 그쪽, 없으면 같은 레벨의 다음 자식
        if (root.left != null) {
            root.left.next = (root.right != null) ? root.right : nextChildOnSameLevel;
        }

        // **반드시 오른쪽을 먼저** 처리해야 왼쪽에서 next 체인을 활용할 수 있다
        connect(root.right);
        connect(root.left);

        return root;
    }

    /**
     * 현재 레벨에서 node의 오른쪽으로 진행하며
     * "왼쪽 자식 → 오른쪽 자식" 순으로 처음 발견되는 자식을 반환.
     * 없으면 null.
     */
    private Node findNextChild(Node node) {
        while (node != null) {
            if (node.left  != null) {
                return node.left;
            }
            if (node.right != null) {
                return node.right;
            }
            node = node.next; // 같은 레벨에서 오른쪽으로 이동
        }
        return null;
    }

    class Node {

        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
