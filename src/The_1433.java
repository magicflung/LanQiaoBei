import java.util.Scanner;

/**
 * @author MUSTACHE
 *	该题使用 dfs 和 回溯法
 *	需要先找出起点到终点的路线，前提为如果相通的话，并且如果存在多条路线则记录
 */
public class The_1433 {
	private static int n, m;
	private static int start, end;
	private static int[][] a = new int[1002][1002]; // 存储站点间的通道，1表示为相通，0为不通
	private static boolean[] flag = new boolean[1002]; // 表示是否被访问过
	private static int[] number = new int[1002]; // number[i]!=0 表示第i个站点 是起点到终点的路线中所经过的站点
	private static int ans; // 记录多少条路线是从 起点到终点的
	private static int result; // 记录最终的危险系数（关键点）
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		m = input.nextInt();
		for(int i = 1; i <= m; i++) {
			int ti = input.nextInt();
			int ty = input.nextInt();
			a[ti][ty] = 1;
			a[ty][ti] = 1;
		}
		start = input.nextInt();
		end = input.nextInt();
		flag[start] = true;
		dfs(start);
		for(int i = 0; i <= n; i++) {
			if(ans == number[i]) { // 来判断是否为关键点，若某个站点在所有相通的路线都出现，则为关键点
				result++;
			}
		}
		if(result == 2) { // 说明只有起点和终点，则返回-1
			System.out.println("-1");
		} else {
			System.out.println(result-2); // -2是除去终点和起点
		}
	}
	
	public static void dfs(int x) {
		if(x == end) {
			ans++; // 记录一条路线
			for(int i = 1; i <= n; i++) {
				if(flag[i]) { // 表示被访问过的即为起点到终点的路线
					number[i]++; // +1 则表示该站点 为 路线所经过的站点 （有可能为关键点）
				}
			}
		}
		for(int i = 1; i <= n; i++) {
			if(!flag[i] && a[x][i] == 1) { // 未被访问过且x和i连通（这里不存在自环）
				flag[i] = true;
				dfs(i);
				flag[i] = false;
			}
		}
	}
}
