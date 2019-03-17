import java.util.Scanner;

public class The_1432 {
	private static int[][] a;
	private static boolean[][] flag;
	private static int n, m;
	private static int sum; // 存储该矩阵的总和
	private static int count = 100; // 记录最终格子数，默认为100，因为矩阵最多为10*10
	private static int[] dx = {0, 1, 0, -1};
	private static int[] dy = {1, 0, -1, 0};
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		m = input.nextInt();
		n = input.nextInt();
		// 注意：m：宽度，n：高度
		a = new int[n][m]; 
		flag = new boolean[n][m]; // 标记：访问为true，未访问为false。默认都自动初始化为false
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				a[i][j] = input.nextInt();
				sum += a[i][j];
			}
		}
		// 判断是否能够分成两份，总和为奇数是一定不能分的
		if(sum % 2 == 1) {
			System.out.println("0");
		} else {
			dfs(a[0][0], 0, 0, 1);
		}
		if(count == 100) { // 说明找不到
			System.out.println("0"); 
		} else { // 找到
			System.out.println(count);
		}
	}

	/**
	 * @param s 目前的总和,初始先把a[0][0]存进去
	 * @param x 横坐标
	 * @param y 纵坐标
	 * @param p 格子数
	 */
	private static void dfs(int s, int x, int y, int p) {
		if(s == (sum / 2) && count > p) {
			count = p;
		}
		// 向四个方向移动
		for(int i = 0; i < 4; i++) {
			int tx = x + dx[i];
			int ty = y + dy[i];
			//  不越界 再来判断 未被标记过 和 下一次的总和不超过 sum/2
			if(tx >= 0 && tx < n && ty >= 0 && ty < m && !flag[tx][ty] && (s + a[tx][ty]) <= (sum / 2)) {
				flag[tx][ty] = true;
				if(tx == 0 && ty == 0) { // 此时这种情况起到连接作用，很重要的一点
					dfs(s, tx, ty, p);
				} else {
					dfs(s + a[tx][ty], tx, ty, p + 1);
				}
				flag[tx][ty] = false;
			}
		}
	}
}
