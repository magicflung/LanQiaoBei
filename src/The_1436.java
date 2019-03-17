import java.util.Scanner;

public class The_1436 {
	private static final int N = 1000000007;
	private static int n, m, k;
	private static int[][] maze;
	// dp[x][y][s][d] 表示的是目前在(x,y)的位置，已经拿到s个宝贝，在这些宝贝中的最大价值为d
	private static int[][][][] dp = new int[55][55][15][15]; // 只要比题意的大就行
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		m = input.nextInt();
		k = input.nextInt();
		maze = new int[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				maze[i][j] = input.nextInt();
			}
		}
		for(int i = 0; i < 55; i++) {
			for(int j = 0; j < 55; j++) {
				for(int v = 0; v < 15; v++) {
					for(int h = 0; h < 15; h++) {
						dp[i][j][v][h] = -1;
					}
				}
			}
		}
//		System.out.println(dp[0][0][0][0]);
		System.out.println(solve(0, 0, 0, -1));
	}
	/** 记忆化搜索:必须先初始化为-1，不然会退化超时
	 * @param x 横坐标
	 * @param y 纵坐标
	 * @param num 已拿的宝贝数
	 * @param maxValue 记录最大宝贝的价值，
	 * maxValue 因为最先传入的是-1（传-1是因为价值有可能为0，那么得比0再小才可以比较），所以下面得maxValue都要加一
	 * 	不然越界了
	 */
	public static int solve(int x, int y, int num, int maxValue) {
		if(dp[x][y][num][maxValue+1] != -1) { // 说明该位置已经计算过了，直接拿值
			return dp[x][y][num][maxValue+1];
		}
		if(x == n-1 && y == m-1) { // 如果到达出口
			// 此时拿到的宝贝数已经符合要求 或
			// 如果拿到的宝贝数还差一个并且拿到的宝贝数中的最大价值比该格子的价值小
			// 两种方案之一
			if(num == k || (num == k-1 && maxValue < maze[x][y])) { 
				return dp[x][y][num][maxValue+1] = 1; 
			} else { // 否则不符合要求
				return dp[x][y][num][maxValue+1] = 0; 
			}
		}
		long s = 0;
		// 向下
		if(x+1 < n) { // x+1判断下次递归时是否会越界
			// 拿与不拿都是一种方案
			if(maxValue < maze[x][y]) { // 跟当前的格子的价值比较，看看是否可以拿
				s += solve(x+1, y, num+1, maze[x][y]);
			}
			// 也可以不拿
			s += solve(x+1, y, num, maxValue);
		}
		// 向右
		if(y+1 < m) {
			// 拿与不拿都是一种方案
			if(maxValue < maze[x][y]) { // 跟当前的格子的价值比较，看看是否可以拿
				s += solve(x, y+1, num+1, maze[x][y]);
			}
			// 也可以不拿
			s += solve(x, y+1, num, maxValue);
		}
		
		return dp[x][y][num][maxValue+1] = (int) (s % N);
	}
}
