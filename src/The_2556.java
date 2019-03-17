

import java.util.Scanner;
import java.util.Stack;

/**
 * @author MUSTACHE
 * 汉诺塔：
 * 拿题目的 n=4来举例：柱子用a,b,c来方便表示
 * 我们逆向看，即看当第4个盘子放在c时，此时b一定存放着3个盘子，因为根据题意此时第4个盘子一定从a放入c
 * 			当第3个盘子从b放在c时，此时a一定存放2个盘子
 * 			当第2个盘子从a放在c时，此时b一定存在1个盘子
 * 可以得出规律：b看作一个辅助柱子，将n-1个盘子放在b,将a中剩下的第n个盘中放入c中
 * 				a看做一个辅助柱子，将n-2个盘中放入a，将b剩下的第n-1个盘中放入c中
 * 		即：每次先把 除最底下的盘子外的盘子都放在一个辅助柱子上，然后再将最底下的盘子移到c，然后再把原先的柱子当成辅助柱子，如此反复
 * 因此可以写一个方法
 * 	solve(n, a, b, c) 表示将n个盘子从a移动到c，b做辅助柱子
 */
public class The_2556 {
	// 因为盘子从上到下 是按从小到大排列，每次取出最上面的盘子，这可以当成一个栈，所以使用栈来当柱子
	private static Stack<Integer> stack1 = new Stack<Integer>(); // 柱子a
	private static Stack<Integer> stack2 = new Stack<Integer>(); // 柱子b
	private static Stack<Integer> stack3 = new Stack<Integer>(); // 柱子c
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		for(int i = n; i > 0; i--) {
			stack1.push(i);
		}
		solve(n, stack1, stack2, stack3);
	}
	// 这是一个来判断是哪根柱子的方法
	private static int Move(Stack<Integer> a) {
		if(a.equals(stack1)) {
			return 1;
		} else if(a.equals(stack2)) {
			return 2;
		} else if(a.equals(stack3)) {
			return 3;
		}
		return -1; // 这个-1无关紧要，反正一定是上面三个数之一
	}
	public static void solve(int n, Stack<Integer> a, Stack<Integer> b, Stack<Integer> c) {
		if(n == 0) return ;
		solve(n-1, a, c, b); // 表示的是先将n-1个盘子从a拿出来放入b，c作为辅助柱子
		// 然后把a中最底下的盘子拿出来
		int moveA = Move(a); // 这条只是为了下面的显示语句
		// 把第n个盘子拿出来
		int t = a.pop(); // 这条只是为了下面的显示语句
		c.push(t); // 将第n个盘子拿出来放入c中
		int moveB = Move(c); // 这条只是为了下面的显示语句
		System.out.println("Move " + n + " from " + moveA + " to " + moveB);
		// 上面的操作执行完，那么就把a当成辅助柱子，把b中除最底的盘子外都放到a，然后把b中最低的盘子放入c
		solve(n-1, b, a, c);
	}
}
