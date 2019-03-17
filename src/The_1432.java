import java.util.Scanner;

public class The_1432 {
	private static int[][] a;
	private static boolean[][] flag;
	private static int n, m;
	private static int sum; // �洢�þ�����ܺ�
	private static int count = 100; // ��¼���ո�������Ĭ��Ϊ100����Ϊ�������Ϊ10*10
	private static int[] dx = {0, 1, 0, -1};
	private static int[] dy = {1, 0, -1, 0};
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		m = input.nextInt();
		n = input.nextInt();
		// ע�⣺m����ȣ�n���߶�
		a = new int[n][m]; 
		flag = new boolean[n][m]; // ��ǣ�����Ϊtrue��δ����Ϊfalse��Ĭ�϶��Զ���ʼ��Ϊfalse
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				a[i][j] = input.nextInt();
				sum += a[i][j];
			}
		}
		// �ж��Ƿ��ܹ��ֳ����ݣ��ܺ�Ϊ������һ�����ֵܷ�
		if(sum % 2 == 1) {
			System.out.println("0");
		} else {
			dfs(a[0][0], 0, 0, 1);
		}
		if(count == 100) { // ˵���Ҳ���
			System.out.println("0"); 
		} else { // �ҵ�
			System.out.println(count);
		}
	}

	/**
	 * @param s Ŀǰ���ܺ�,��ʼ�Ȱ�a[0][0]���ȥ
	 * @param x ������
	 * @param y ������
	 * @param p ������
	 */
	private static void dfs(int s, int x, int y, int p) {
		if(s == (sum / 2) && count > p) {
			count = p;
		}
		// ���ĸ������ƶ�
		for(int i = 0; i < 4; i++) {
			int tx = x + dx[i];
			int ty = y + dy[i];
			//  ��Խ�� �����ж� δ����ǹ� �� ��һ�ε��ܺͲ����� sum/2
			if(tx >= 0 && tx < n && ty >= 0 && ty < m && !flag[tx][ty] && (s + a[tx][ty]) <= (sum / 2)) {
				flag[tx][ty] = true;
				if(tx == 0 && ty == 0) { // ��ʱ����������������ã�����Ҫ��һ��
					dfs(s, tx, ty, p);
				} else {
					dfs(s + a[tx][ty], tx, ty, p + 1);
				}
				flag[tx][ty] = false;
			}
		}
	}
}
