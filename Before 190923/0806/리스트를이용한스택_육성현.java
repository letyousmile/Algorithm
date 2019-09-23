
public class ListStack {
	static class Node{
		int data;
		Node link;
		public Node(int data) {
			this.data = data;
		}
	}
	static Node top;
	public static void main(String[] args) {
		push(4);
		push(2);
		push(1);
		push(5);
		push(7);
		push(8);
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
	}
	public static int peek() {
		if(isEmpty()) {
			System.out.println("UNDERFLOW ERROR : 스택이 비어있습니다.");
			return -1;
		}else {
			return top.data;
		}
	}
	public static void push(int data) {
		Node newNode = new Node(data);
		if(top==null) {
			top = newNode;
		}else {
			newNode.link=top;
			top = newNode;
		}
	}
	public static boolean isEmpty() {
		if(top==null) {
			return true;
		}
		return false;
	}
	public static int pop() {
		if(isEmpty()) {
			System.out.println("UNDERFLOW ERROR : 스택이 비어있습니다.");
			return -1;
		}else {
			int data = top.data;
			top = top.link;
			return data;
		}
	}
}
