import java.util.Scanner;

public class The_1429 {
	private static int m, n; // 正方形格子的行数和列数
	private static char[] dd = {'U','R','D','L'};
	private static int[] dx = {-1, 0, 1,  0};
	private static int[] dy = { 0, 1, 0, -1};
	private static int k; // 蚂蚁走的步数
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		m = input.nextInt();
		n = input.nextInt();
		int[][] arr = new int[m][n];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				arr[i][j] = input.nextInt();
			}
		}
		// x y : 蚂蚁所在行号和列号
		int x = input.nextInt();
		int y = input.nextInt();
		char s = input.next().charAt(0); // 蚂蚁的朝向
		k = input.nextInt();
		solve(arr, x, y, s);
	}
	/**
	 * @param arr 黑白矩阵
	 * @param rx 记录蚂蚁的位置
	 * @param ry 记录蚂蚁的位置
	 * @param rs 记录蚂蚁每次的朝向
	 */
	public static void solve(int[][] arr, int rx, int ry, char rs) {
		for(int i = 0; i < k; i++) {
			if(arr[rx][ry] == 1) { // 判断蚂蚁现所处的位置是否为黑格
				arr[rx][ry] = 0; // 并将黑格变为白格
				rs = directionBlack(rs);
			} else { // 否则为 白格
				arr[rx][ry] = 1; // 并将白格变为黑格
				rs = directionWhite(rs);
			}
			for(int j = 0; j < 4; j++) {
				if(rs == dd[j]) { // 找到我们目前的朝向
					// 根据朝向，向前进一步
					rx = rx + dx[j]; 
					ry = ry + dy[j];
				}
			}
		}
		System.out.println(rx + " " + ry);
	}
	// 如果目前的格子为黑色，则 会在原来的方向向右转90度
	public static char directionBlack(char rs) {
		for(int j = 0; j < 4; j++) {
			if(dd[j] == rs) {
				if(j == 3) {
					rs = dd[0];
				} else {
					rs = dd[++j];
				}
				break;
			}
		}
		return rs;
	}
	// 如果目前的格子为白色，则 会在原来的方向向左转90度
	public static char directionWhite(char rs) {
		for(int j = 0; j < 4; j++) {
			if(dd[j] == rs) {
				if(j == 0) {
					rs = dd[3];
				} else {
					rs = dd[--j];
				}
				break;
			}
		}
		return rs;
	}

}
