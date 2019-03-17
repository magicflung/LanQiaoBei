

import java.util.Scanner;

public class The_2055 {
	private static final int INF = 999999999;
	private static int n,k;
	private static double[][] time = new double[505][505];
	private static double[] dis = new double[505]; // ���洢��ʼ�㵽�������ɴ���·��������Ϊʱ�䣩
	private static int[] flag;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		k = input.nextInt();
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				time[i][j] = input.nextInt();
			}
		}
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				int t = input.nextInt();
				if(i == j) {
					continue;
				}
				time[i][j] /= t;
			}
		}
		Dijkstra(1);
		System.out.println(String.format("%.2f", dis[k]));
		
//		��������
//		for(int i = 0; i < n; i++) {
//			for(int j = 0; j < n; j++) {
//				System.out.print(time[i][j] + " ");
//			}
//			System.out.println();
//		}
//		dfs
//		flag[0] = true;
//		dfs(0, time[0][0]);
//		System.out.println(time[0][k-1]);
	}
//	// ���·�� ��ʱ
//	public static void dfs(int x, double sum) {
//		if(sum > minTime) return ;
//		if(x == k-1) {
//			if(sum < minTime) {
//				minTime = sum;
//			}
//			return ;
//		}
//			
//		for(int i = 0; i < n; i++) {
//			if(i == x || flag[i]) continue;
//			flag[i] = true;
//			dfs(i, sum+time[x][i]);
//			flag[i] = false;
//		}
//		return ;
//	}
	public static void Dijkstra(int v) {
		flag = new int[n+1];
		for(int i = 1; i <= n; i++) {
			dis[i] = time[v][i];
		}
		flag[v] = 1;
		// �ҳ���v����ĵ㣨����Ϊʱ�䣩
		for(int i = 1; i < n; i++) {
			double min = INF;
			int u = -1; // �洢������λ��
			for(int j = 1; j <= n; j++) {
				if(flag[j] == 0 && dis[j] < min) {
					min = dis[j];
					u = j;
				}
			}
			flag[u] = 1;
			// Ȼ���ɳ�
			for(int j = 1; j <= n; j++) {
				// ��Ϊ�������Ե�Կɷ��ʣ������������Ƚ��Ƿ�����ͨ
				if(time[u][j] + dis[u] < dis[j]) {
					dis[j]  = time[u][j] + dis[u];
				}
			}
		}
	}
}
