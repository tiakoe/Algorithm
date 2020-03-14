package other;

import java.util.Arrays;
import java.util.Scanner;

public class Main_SouSuoShu {
	// 给定一棵满二叉树，判定该树是否为二叉搜索树，是的话打印True，不是的话打印False
	//
	// 说明：
	// a. 二叉搜索树（Binary Search Tree），它或者是一棵空树，或者是具有下列性质的二叉树：
	// 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值； 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
	// 它的左、右子树也分别为二叉搜索树。
	// b. 满二叉树，除最后一层无任何子节点外，每一层上的所有结点都有两个子结点二叉树
	// c. 树内节点数不超过 10000，非空节点值为大于0小于65536的整数，空树或空节点输入为None
	static Integer[] a;
	static String[] temp;

	static boolean judget() {
		boolean flag = true;
		for (int i = temp.length; i > 0; i--) {
			if (a[i] <= 0) {
				continue;
			}
			if (2 * i + 1 <= temp.length) {
				if (a[2 * i] > 0) {
					if (a[2 * i] >= a[i]) {
						flag = false;
						break;
					}
				}
				if (a[2 * i + 1] > 0) {
					if (a[2 * i + 1] <= a[i]) {
						flag = false;
						break;
					}
				}
			}

		}
		return flag;
	}

	public static void main(String[] args) {
		// root:i left:2*i right:2*i+1
		Scanner in = new Scanner(System.in);
		String string = in.nextLine();
		temp = string.split(",");
		if (temp.length > 10000) {
			System.out.println("False");
			return;
		}

		if (temp[0] == "None") {
			System.out.println("True");
			return;
		}
		if (temp.length % 2 == 1 && !string.contains("None")) {
			System.out.println("True");
			return;
		}
		a = new Integer[temp.length + 1];
		Arrays.fill(a, -1);
		boolean flag = false;
		int t;
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == "None") {
				a[i + 1] = -2;
				continue;
			}
			t = Integer.parseInt(temp[i]);
			if (t <= 0 || t >= 65536) {
				flag = true;
				System.out.println("False");
				break;
			}
			a[i + 1] = t;
		}
		if (flag == false) {
			System.out.println(judget() ? "True" : "False");
		}

	}

}
