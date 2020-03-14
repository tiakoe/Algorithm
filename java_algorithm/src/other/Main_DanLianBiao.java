package other;
class SingleList<E> {
	private static class Node<E> {
		E item;
		Node<E> next;

		public Node(E item, Node<E> next) {
			this.item = item;
			this.next = next;
		}
	}

	private Node<E> fristNode;
	private Node<E> lastNode;
	public int size;

	// ��β�����һ��Ԫ��
	public void add(E e) {
		lastNodeList(e);
	}

	// ��ĳ��λ�ò���һ��Ԫ��
	public void add(E e, int index) {
		if (index < 0 || index > size)
			return;
		if (index == size) {// ����β��
			lastNodeList(e);
		} else {
			if (index == 0) {
				Node<E> l = fristNode;
				Node<E> newNode = new Node<>(e, l);// �µ�Ԫ���ڲ���λ�õ�ǰһ��λ��
				fristNode = newNode;
			} else {
				Node<E> fNode = node(index - 1);// �ҵ�Ҫ����λ�õ�ǰһ��λ��
				Node<E> lNode = fNode.next;
				Node<E> newNode = new Node<>(e, lNode);
				fNode.next = newNode;
			}
			size++;
		}
	}

	// ɾ��ĳ���ڵ�
	public void remove(int index) {
		unLink(index);
	}

	private void unLink(int index) {
		if (index < 0 || index > size)
			return;
		if (index == size) {// ɾβ��
			Node<E> node = node(index - 1);
			node.next = null;
			lastNode = node;
		} else if (index == 0) {// ɾͷ��
			Node<E> l = this.fristNode;
			fristNode = l.next;
		} else {
			Node<E> node = node(index - 1);// Ҫɾ����ǰһ���ڵ�
			Node<E> removeNode = node.next;// Ҫɾ���Ľڵ�
			Node<E> lNode = removeNode.next;// Ҫɾ���ĺ�һ���ڵ�
			node.next = lNode;
		}
		size--;
	}

	public void remove(E e) {
		Node<E> newNode = fristNode;
		int index = -1;
		for (int i = 0; i < size; i++) {
			newNode = newNode.next;
			if (e.equals(newNode.item)) {
				index = i;
				break;
			}
		}
		if (index != -1)
			unLink(index);
	}

	private void lastNodeList(E e) {
		Node<E> newNode = new Node<>(e, null);// һ���µĽڵ�
		Node<E> l = lastNode;
		if (l == null) {
			fristNode = newNode;
		} else {
			l.next = newNode;
		}
		size++;
		lastNode = newNode;// �����һ���ڵ㸳ֵ
	}

	// ��ȡ�ڵ��ĳ��Ԫ��
	public E get(int index) {
		if (index < 0 || index > size) {
			return null;
		}
		return node(index).item;
	}

	public Node<E> node(int index) {
		Node<E> newNode = fristNode;
		for (int i = 0; i < index; i++) {
			newNode = newNode.next;
		}
		return newNode;
	}
}

public class Main_DanLianBiao {

	public static void main(String[] args) {
		SingleList<Integer> singleList = new SingleList<>();
		singleList.add(1);
		singleList.add(2);
		singleList.add(3);
		singleList.add(4);
		singleList.add(5);
		singleList.remove(3);
		for (int i = 0; i < singleList.size; i++) {
			System.out.print(singleList.get(i) + " ");
		}
	}

}
