import java.util.Scanner;

/**
 * @author MUSTACHE
 *	����ʹ�� dfs �� ���ݷ�
 *	��Ҫ���ҳ���㵽�յ��·�ߣ�ǰ��Ϊ�����ͨ�Ļ�������������ڶ���·�����¼
 */
public class The_1433 {
	private static int n, m;
	private static int start, end;
	private static int[][] a = new int[1002][1002]; // �洢վ����ͨ����1��ʾΪ��ͨ��0Ϊ��ͨ
	private static boolean[] flag = new boolean[1002]; // ��ʾ�Ƿ񱻷��ʹ�
	private static int[] number = new int[1002]; // number[i]!=0 ��ʾ��i��վ�� ����㵽�յ��·������������վ��
	private static int ans; // ��¼������·���Ǵ� ��㵽�յ��
	private static int result; // ��¼���յ�Σ��ϵ�����ؼ��㣩
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
			if(ans == number[i]) { // ���ж��Ƿ�Ϊ�ؼ��㣬��ĳ��վ����������ͨ��·�߶����֣���Ϊ�ؼ���
				result++;
			}
		}
		if(result == 2) { // ˵��ֻ�������յ㣬�򷵻�-1
			System.out.println("-1");
		} else {
			System.out.println(result-2); // -2�ǳ�ȥ�յ�����
		}
	}
	
	public static void dfs(int x) {
		if(x == end) {
			ans++; // ��¼һ��·��
			for(int i = 1; i <= n; i++) {
				if(flag[i]) { // ��ʾ�����ʹ��ļ�Ϊ��㵽�յ��·��
					number[i]++; // +1 ���ʾ��վ�� Ϊ ·����������վ�� ���п���Ϊ�ؼ��㣩
				}
			}
		}
		for(int i = 1; i <= n; i++) {
			if(!flag[i] && a[x][i] == 1) { // δ�����ʹ���x��i��ͨ�����ﲻ�����Ի���
				flag[i] = true;
				dfs(i);
				flag[i] = false;
			}
		}
	}
}
