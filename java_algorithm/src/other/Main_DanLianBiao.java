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

	// 向尾部添加一个元素
	public void add(E e) {
		lastNodeList(e);
	}

	// 在某个位置插入一个元素
	public void add(E e, int index) {
		if (index < 0 || index > size)
			return;
		if (index == size) {// 插入尾部
			lastNodeList(e);
		} else {
			if (index == 0) {
				Node<E> l = fristNode;
				Node<E> newNode = new Node<>(e, l);// 新的元素在插入位置的前一个位置
				fristNode = newNode;
			} else {
				Node<E> fNode = node(index - 1);// 找到要插入位置的前一个位置
				Node<E> lNode = fNode.next;
				Node<E> newNode = new Node<>(e, lNode);
				fNode.next = newNode;
			}
			size++;
		}
	}

	// 删除某个节点
	public void remove(int index) {
		unLink(index);
	}

	private void unLink(int index) {
		if (index < 0 || index > size)
			return;
		if (index == size) {// 删尾部
			Node<E> node = node(index - 1);
			node.next = null;
			lastNode = node;
		} else if (index == 0) {// 删头部
			Node<E> l = this.fristNode;
			fristNode = l.next;
		} else {
			Node<E> node = node(index - 1);// 要删除的前一个节点
			Node<E> removeNode = node.next;// 要删除的节点
			Node<E> lNode = removeNode.next;// 要删除的后一个节点
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
		Node<E> newNode = new Node<>(e, null);// 一个新的节点
		Node<E> l = lastNode;
		if (l == null) {
			fristNode = newNode;
		} else {
			l.next = newNode;
		}
		size++;
		lastNode = newNode;// 将最后一个节点赋值
	}

	// 获取节点的某个元素
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
