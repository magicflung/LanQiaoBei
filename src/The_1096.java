import java.util.Scanner;

class Point {
	int x,y;
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class The_1096 {
	private static int[] dx = new int[] {0, 1, 1,  1,  0, -1, -1, -1};
	private static int[] dy = new int[] {1, 1, 0, -1, -1, -1,  0,  1};
	private static int[][] dp = new int[][];
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n, m;
		while(input.hasNext()) {
			n = input.nextInt();
			m = input.nextInt();
			if(n == 0 && m == 0) break;
			boolean[][] arr = new boolean[n][m];
			for(int i = 0; i < n; i++) {
				String st = input.next();
				for(int j = 0; j < m; j++) {
					if(st.charAt(j) == '*') {
						arr[i][j] = true;
					}
				}
			}
//			for(int i = 0; i < n; i++) {
//				for(int j = 0; j < m; j++) {
//					System.out.print(arr[i][j]);
//				}
//				System.out.println();
//			}
			
		}
	}
	
	public static void bfs() {
		
	}
}
