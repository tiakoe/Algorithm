package other;
import java.util.ArrayList;
import java.util.Stack;

class TreeNode {
	Integer val;
	TreeNode next;
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		this.val = val;
	}

}

public class Main_ZhiXingDaYin {

	public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		int layer = 1;
		// s1��������ڵ�
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		s1.push(pRoot);
		// s2��ż����ڵ�
		Stack<TreeNode> s2 = new Stack<TreeNode>();

		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

		while (!s1.empty() || !s2.empty()) {
			if (layer % 2 != 0) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				while (!s1.empty()) {
					TreeNode node = s1.pop();
					if (node != null) {
						temp.add(node.val);
						System.out.print(node.val + " ");
						s2.push(node.left);
						s2.push(node.right);
					}
				}
				if (!temp.isEmpty()) {
					list.add(temp);
					layer++;
					System.out.println();
				}
			} else {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				while (!s2.empty()) {
					TreeNode node = s2.pop();
					if (node != null) {
						temp.add(node.val);
						System.out.print(node.val + " ");
						s1.push(node.right);
						s1.push(node.left);
					}
				}
				if (!temp.isEmpty()) {
					list.add(temp);
					layer++;
					System.out.println();
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(-1);
		for (int i = 0; i < 10; i++) {
			TreeNode node = new TreeNode(i);
			node.next = root;
			root = node;
		}
		while (root.next != null) {
			System.out.println(root.val);
			root = root.next;
		}
	}

}
