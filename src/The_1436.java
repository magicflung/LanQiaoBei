import java.util.Scanner;

public class The_1436 {
	private static final int N = 1000000007;
	private static int n, m, k;
	private static int[][] maze;
	// dp[x][y][s][d] ��ʾ����Ŀǰ��(x,y)��λ�ã��Ѿ��õ�s������������Щ�����е�����ֵΪd
	private static int[][][][] dp = new int[55][55][15][15]; // ֻҪ������Ĵ����
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
	/** ���仯����:�����ȳ�ʼ��Ϊ-1����Ȼ���˻���ʱ
	 * @param x ������
	 * @param y ������
	 * @param num ���õı�����
	 * @param maxValue ��¼��󱦱��ļ�ֵ��
	 * maxValue ��Ϊ���ȴ������-1����-1����Ϊ��ֵ�п���Ϊ0����ô�ñ�0��С�ſ��ԱȽϣ������������maxValue��Ҫ��һ
	 * 	��ȻԽ����
	 */
	public static int solve(int x, int y, int num, int maxValue) {
		if(dp[x][y][num][maxValue+1] != -1) { // ˵����λ���Ѿ�������ˣ�ֱ����ֵ
			return dp[x][y][num][maxValue+1];
		}
		if(x == n-1 && y == m-1) { // ����������
			// ��ʱ�õ��ı������Ѿ�����Ҫ�� ��
			// ����õ��ı���������һ�������õ��ı������е�����ֵ�ȸø��ӵļ�ֵС
			// ���ַ���֮һ
			if(num == k || (num == k-1 && maxValue < maze[x][y])) { 
				return dp[x][y][num][maxValue+1] = 1; 
			} else { // ���򲻷���Ҫ��
				return dp[x][y][num][maxValue+1] = 0; 
			}
		}
		long s = 0;
		// ����
		if(x+1 < n) { // x+1�ж��´εݹ�ʱ�Ƿ��Խ��
			// ���벻�ö���һ�ַ���
			if(maxValue < maze[x][y]) { // ����ǰ�ĸ��ӵļ�ֵ�Ƚϣ������Ƿ������
				s += solve(x+1, y, num+1, maze[x][y]);
			}
			// Ҳ���Բ���
			s += solve(x+1, y, num, maxValue);
		}
		// ����
		if(y+1 < m) {
			// ���벻�ö���һ�ַ���
			if(maxValue < maze[x][y]) { // ����ǰ�ĸ��ӵļ�ֵ�Ƚϣ������Ƿ������
				s += solve(x, y+1, num+1, maze[x][y]);
			}
			// Ҳ���Բ���
			s += solve(x, y+1, num, maxValue);
		}
		
		return dp[x][y][num][maxValue+1] = (int) (s % N);
	}
}
