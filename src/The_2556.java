

import java.util.Scanner;
import java.util.Stack;

/**
 * @author MUSTACHE
 * ��ŵ����
 * ����Ŀ�� n=4��������������a,b,c�������ʾ
 * �������򿴣���������4�����ӷ���cʱ����ʱbһ�������3�����ӣ���Ϊ���������ʱ��4������һ����a����c
 * 			����3�����Ӵ�b����cʱ����ʱaһ�����2������
 * 			����2�����Ӵ�a����cʱ����ʱbһ������1������
 * ���Եó����ɣ�b����һ���������ӣ���n-1�����ӷ���b,��a��ʣ�µĵ�n�����з���c��
 * 				a����һ���������ӣ���n-2�����з���a����bʣ�µĵ�n-1�����з���c��
 * 		����ÿ���Ȱ� ������µ�����������Ӷ�����һ�����������ϣ�Ȼ���ٽ�����µ������Ƶ�c��Ȼ���ٰ�ԭ�ȵ����ӵ��ɸ������ӣ���˷���
 * ��˿���дһ������
 * 	solve(n, a, b, c) ��ʾ��n�����Ӵ�a�ƶ���c��b����������
 */
public class The_2556 {
	// ��Ϊ���Ӵ��ϵ��� �ǰ���С�������У�ÿ��ȡ������������ӣ�����Ե���һ��ջ������ʹ��ջ��������
	private static Stack<Integer> stack1 = new Stack<Integer>(); // ����a
	private static Stack<Integer> stack2 = new Stack<Integer>(); // ����b
	private static Stack<Integer> stack3 = new Stack<Integer>(); // ����c
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		for(int i = n; i > 0; i--) {
			stack1.push(i);
		}
		solve(n, stack1, stack2, stack3);
	}
	// ����һ�����ж����ĸ����ӵķ���
	private static int Move(Stack<Integer> a) {
		if(a.equals(stack1)) {
			return 1;
		} else if(a.equals(stack2)) {
			return 2;
		} else if(a.equals(stack3)) {
			return 3;
		}
		return -1; // ���-1�޹ؽ�Ҫ������һ��������������֮һ
	}
	public static void solve(int n, Stack<Integer> a, Stack<Integer> b, Stack<Integer> c) {
		if(n == 0) return ;
		solve(n-1, a, c, b); // ��ʾ�����Ƚ�n-1�����Ӵ�a�ó�������b��c��Ϊ��������
		// Ȼ���a������µ������ó���
		int moveA = Move(a); // ����ֻ��Ϊ���������ʾ���
		// �ѵ�n�������ó���
		int t = a.pop(); // ����ֻ��Ϊ���������ʾ���
		c.push(t); // ����n�������ó�������c��
		int moveB = Move(c); // ����ֻ��Ϊ���������ʾ���
		System.out.println("Move " + n + " from " + moveA + " to " + moveB);
		// ����Ĳ���ִ���꣬��ô�Ͱ�a���ɸ������ӣ���b�г���׵������ⶼ�ŵ�a��Ȼ���b����͵����ӷ���c
		solve(n-1, b, a, c);
	}
}
