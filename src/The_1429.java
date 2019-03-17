import java.util.Scanner;

public class The_1429 {
	private static int m, n; // �����θ��ӵ�����������
	private static char[] dd = {'U','R','D','L'};
	private static int[] dx = {-1, 0, 1,  0};
	private static int[] dy = { 0, 1, 0, -1};
	private static int k; // �����ߵĲ���
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
		// x y : ���������кź��к�
		int x = input.nextInt();
		int y = input.nextInt();
		char s = input.next().charAt(0); // ���ϵĳ���
		k = input.nextInt();
		solve(arr, x, y, s);
	}
	/**
	 * @param arr �ڰ׾���
	 * @param rx ��¼���ϵ�λ��
	 * @param ry ��¼���ϵ�λ��
	 * @param rs ��¼����ÿ�εĳ���
	 */
	public static void solve(int[][] arr, int rx, int ry, char rs) {
		for(int i = 0; i < k; i++) {
			if(arr[rx][ry] == 1) { // �ж�������������λ���Ƿ�Ϊ�ڸ�
				arr[rx][ry] = 0; // �����ڸ��Ϊ�׸�
				rs = directionBlack(rs);
			} else { // ����Ϊ �׸�
				arr[rx][ry] = 1; // �����׸��Ϊ�ڸ�
				rs = directionWhite(rs);
			}
			for(int j = 0; j < 4; j++) {
				if(rs == dd[j]) { // �ҵ�����Ŀǰ�ĳ���
					// ���ݳ�����ǰ��һ��
					rx = rx + dx[j]; 
					ry = ry + dy[j];
				}
			}
		}
		System.out.println(rx + " " + ry);
	}
	// ���Ŀǰ�ĸ���Ϊ��ɫ���� ����ԭ���ķ�������ת90��
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
	// ���Ŀǰ�ĸ���Ϊ��ɫ���� ����ԭ���ķ�������ת90��
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
