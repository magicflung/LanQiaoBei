import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class The_1435 {
	private static class Node implements Comparable<Node> {
		int a, b;
		int t;
		Node(int a, int b, int t) {
			this.a = a;
			this.b = b;
			this.t = t;
		}
		@Override
		public int compareTo(Node o) {
			// ������������������
			if(this.t > o.t) {
				return -1;
			} else if(this.t < o.t) {
				return 1;
			} else {
				return 0;
			}
		}
//		public String toString() {
//			return a + " " + b + " " + t;
//		}
	}
	private static int[] f = new int[10005];
	private static int n, m;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		m = input.nextInt();
		List<Node> list = new ArrayList<>();
		for(int i = 1; i <= m; i++) {
			int a = input.nextInt();
			int b = input.nextInt();
			int t = input.nextInt();
			list.add(new Node(a, b, t));
		}
		Collections.sort(list);
//		for(Node s : list) {
//			System.out.println(s);
//		}
		int sum = 0, pre = -1; // pre����¼ǰһ�����������Ϊif������ͬ����Ҳֻ��һ�����
		init();
		for(int i = 0; i < n; i++) {
			Node temp = list.get(i);
			int flag = union(temp.a, temp.b);
			if(flag == 1 && pre != temp.t) {
				sum++;
				pre = temp.t;
			}
		}
		System.out.println(sum);
	}
	// ������� ���鼯
	// ��Ҫ����������
	// 1.��ʼ��f[]����init()
	// 2.find()  Ѱ�Ҹ����
	// 3.union() ���ϲ���������
	public static void init() {
		for(int i = 1; i <= n; i++) { // ƭ��
			f[i] = i;
		}
	}
	public static int find(int root) {
//		int x = root, temp;
//		while(root != f[root]) { // �ҵ������
//			root = f[root];
//		}
//		while(x != root) { // ѹ���㷨
//			temp = f[x];
//			f[x] = root;
//			x = temp;
//		}
//		return root;
		return f[root] == root ? root : find(f[root]);
	}
	public static int union(int a, int b) {
		int ta = find(a);
		int tb = find(b);
		if(ta != tb) {
			f[ta] = tb;
			return 1;
		}
		return 0;
	}
}
