package other;

class TreeHeight {

    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int i = getHeight(node.left);
        int j = getHeight(node.right);
        return (i < j) ? j + 1 : i + 1;
    }

    public int getSize(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + getSize(node.left) + getSize(node.right);
    }

    public static void main(String[] args) {

    }
}
