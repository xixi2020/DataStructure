package dataStructure.tree.binaryTree;

/**
 * 114. 二叉树展开为链表
 * 中等
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [0]
 * 输出：[0
 */
public class Flatten {

    //由于主函数返回值是void原地要求变为链表
    //所以不适用直接遍历一遍的思路，可以使用分解思路
    public void flatten(TreeNode root) {
        //返回条件
        if (root == null) return;
        //先遍历左子树，把左子树拉成链表
        flatten(root.left);
        //再将右子树拉成链表
        flatten(root.right);

        //关键在于后序位置怎么拼接:将左子树拼接到右子树，再将右子树进行追加
        //记录左右节点
        TreeNode left = root.left;
        TreeNode right = root.right;
        //遍历连接，将左子树拉成root右子树
        root.left = null;
        root.right = left;
        //将右子树拼接到后面
        //临时节点
        TreeNode temp = root;
        if (temp.right != null){
            temp = temp.right;
        }
        temp.right = right;

    }
}
