

import java.util.Scanner;

public class The_2055 {
	private static int n,k;
	private static double[][] time = new double[505][505];
	private static boolean[] flag;
	private static double minTime = Double.MAX_VALUE;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		k = input.nextInt();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				time[i][j] = input.nextInt();
			}
		}
		flag = new boolean[n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int t = input.nextInt();
				if(i == j) {
					continue;
				}
				time[i][j] /= t;
			}
		}
//		for(int i = 0; i < n; i++) {
//			for(int j = 0; j < n; j++) {
//				System.out.print(time[i][j] + " ");
//			}
//			System.out.println();
//		}
		flag[0] = true;
		dfs(0, time[0][0]);
		System.out.println(minTime);
	}
	// ×î¶ÌÂ·¾¶
	public static void dfs(int x, double sum) {
		if(x == k-1) {
			if(sum < minTime) {
				minTime = sum;
			}
			return ;
		}
			
		for(int i = 0; i < n; i++) {
			if(i == x || flag[i]) continue;
			flag[i] = true;
			dfs(i, sum+time[x][i]);
			flag[i] = false;
		}
		return ;
	}
}
