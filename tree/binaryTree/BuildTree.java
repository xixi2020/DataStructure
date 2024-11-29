package dataStructure.tree.binaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点
 * 示例 1:
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * 示例 2:
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 * 提示:
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder 和 inorder 均 无重复 元素
 * inorder 均出现在 preorder
 * preorder 保证 为二叉树的前序遍历序列
 * inorder 保证 为二叉树的中序遍历序列
 *
 */
public class BuildTree {
    //因为是无重复元素所以用map来记录每个元素的位置，来找到root的位置
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //前序遍历记录每个元素的下标值
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        //用分解发方法。找到root结点，左右节点，然后再构造二叉树。
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);

    }

    /**
     * 构造二叉树函数
     * @param preorder 前序遍历数组
     * @param preStart 左子树的构建开始
     * @param preEnd 左子树的构建结束
     * @param inorder 中序遍历数组
     * @param inStart 右子树构建开始
     * @param inEnd 右子树构建结束
     * @return
     */
    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        //遍历结束标志
        if(preStart > preEnd) return null;
        //前序遍历的第一个节点便是root
        int rootVal = preorder[preStart];
        //找到中序遍历中root的位置好构建左右子树
        int rootIndex = map.get(rootVal);
        //计算中序遍历左子树的结束节点
        int leftSize = rootIndex - inStart;
        //先构造根节点
        TreeNode root = new TreeNode(rootVal);
        //构造左右子树
        root.left = build(preorder, preStart + 1, preStart + leftSize, inorder,
                inStart, rootIndex - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd, inorder,
                rootIndex + 1, inEnd);
        return root;
    }
}
