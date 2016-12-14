package algorithm;

/**
 * Created by liupeng on 2016/12/15.
 * 初级算法学习  二叉树
 */

class TreeNode{
    private String data;
    private TreeNode lchild;
    private TreeNode rchild;

    public TreeNode(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public TreeNode getLchild() {
        return lchild;
    }

    public void setLchild(TreeNode lchild) {
        this.lchild = lchild;
    }

    public TreeNode getRchild() {
        return rchild;
    }

    public void setRchild(TreeNode rchild) {
        this.rchild = rchild;
    }
}

public class BinaryTree {
    public static void main(String arg[]){
        System.out.println("ok");
    }
}
