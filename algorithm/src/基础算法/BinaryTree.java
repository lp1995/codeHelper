package 基础算法;

/**
 * Created by liupeng on 2016/12/15.
 * 初级算法学习  二叉树
 * 递归先序遍历 查找
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


    //先序遍历
    public  static void printTree(TreeNode root){
        if(root != null){
            System.out.println(root.getData());
            if(root.getLchild()!=null){
                printTree(root.getLchild());
            }
            if(root.getRchild()!=null){
                printTree(root.getRchild());
            }
        }
    }

    public static TreeNode findNode(TreeNode root,String data){
        //建立一个用来保存找到的节点
        TreeNode node = null;
        if(root != null){
            if(root.getData().equals(data)) {
                node = root;
            }
            if(root.getLchild()!=null){
                /**
                 * 不能 return findNode() 这样不会执行后续操作
                 * 也不能root = findeNode()这样会被后续为null的覆盖
                 */
                TreeNode temp = findNode(root.getLchild(),data);
                if(temp!=null){
                    node = temp;
                }
            }

            if(root.getRchild()!=null){
                TreeNode temp = findNode(root.getRchild(),data);
                if(temp!=null){
                    node = temp;
                }
            }
        }
        return node;
    }

    public static void main(String arg[]){
        TreeNode root = new TreeNode("0");
        TreeNode n2 = new TreeNode("1");
        TreeNode n3 = new TreeNode("2");
        TreeNode n4 = new TreeNode("3");
        TreeNode n5 = new TreeNode("4");
        TreeNode n6 = new TreeNode("5");
        TreeNode n7 = new TreeNode("6");
        root.setLchild(n2);
        root.setRchild(n3);
        n3.setLchild(n4);
        n3.setRchild(n5);
        n5.setLchild(n6);
        n5.setRchild(n7);

        //测试输出
        //printTree(root);

        //测试查找
        TreeNode fnode = findNode(root,"5");
        System.out.println(fnode.getData());
    }
}
