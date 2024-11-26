package dataStructure.tree.binaryTree;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 * 中等
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[1,#,2,3,#,4,5,6,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
 */
public class Connect {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    //用三叉树的思想，把左节点的右子节点和右节点的左子节点连接
    public Node connect(Node root) {
        if(root == null) return null;
        traverse(root.left, root.right);
        return root;

    }

    //用层级的遍历来连接节点
    private void traverse(Node left, Node right) {
        //遍历终止条件
        if (left == null || right == null) return;
        //连接左右节点
        left.next = right;
        //左子树左右节点连接
        traverse(left.left, left.right);
        //右子树左右节点连接
        traverse(right.left, right.right);
        //左子树右子节点和右子树左子节点
        traverse(left.right, right.left);
    }
}
