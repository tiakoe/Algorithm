package 二叉树;

import utils.Node;

public class 前中后_递归遍历 {
    private void pre(Node root){
        if(root==null){
            return;
        }
        System.out.println(root.data);
        pre(root.left);
        pre(root.right);
    }
    private void mid(Node root){
        if(root==null){
            return;
        }
        mid(root.left);
        System.out.println(root.data);
        mid(root.right);
    }

    private void last(Node root){
        if(root==null){
            return;
        }
        last(root.left);
        last(root.right);
        System.out.println(root.data);
    }
    public static void main(String[] args) {

    }
}
