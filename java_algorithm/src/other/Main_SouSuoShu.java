package other;
import java.util.Arrays;
import java.util.Scanner;

public class Main_SouSuoShu {
	// ����һ�������������ж������Ƿ�Ϊ�������������ǵĻ���ӡTrue�����ǵĻ���ӡFalse
	//
	// ˵����
	// a. ������������Binary Search Tree������������һ�ÿ����������Ǿ����������ʵĶ�������
	// ���������������գ��������������н���ֵ��С�����ĸ�����ֵ�� ���������������գ��������������н���ֵ���������ĸ�����ֵ��
	// ������������Ҳ�ֱ�Ϊ������������
	// b. ���������������һ�����κ��ӽڵ��⣬ÿһ���ϵ����н�㶼�������ӽ�������
	// c. ���ڽڵ��������� 10000���ǿսڵ�ֵΪ����0С��65536��������������սڵ�����ΪNone
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
