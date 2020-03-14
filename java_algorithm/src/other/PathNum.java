package other;
import java.util.Scanner;

/**
 * һ��������ֻ�����º������ƶ���ÿ��ֻ���ƶ�һ�������һ���㷨������˴ӣ�0,0������m��n���ж�����·����
 * 
 * @author ASUS
 *
 */
public class PathNum {

	static int deal(int x, int y) {
		if (x == 1 && y == 1) {
			return 1;
		} else if (x == 1) {
			return deal(x, y - 1);
		} else if (y == 1) {
			return deal(x - 1, y);
		} else {
			return deal(x - 1, y) + deal(x, y - 1);
		}
	}

	static int caculate(int num) {
		int s = 1;
		for (int i = 1; i <= num; i++) {
			s = s * i;
		}
		return s;
	}

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int m = in.nextInt();
			int n = in.nextInt();
			System.out.print(deal(m, n));
			System.out.println();
			// System.out.print(caculate(m + n - 2) / (caculate(m - 1) *
			// caculate(n - 1)));
			// System.out.println();
		}

	}

}
