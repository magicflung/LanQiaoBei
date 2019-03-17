import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;


/** �Ź�ͼ
 * @author MUSTACHE
 *
 */
public class The_1426 {
	private static final int N = 3;
	private static Set<String> set = new HashSet<>();
	private static int[] dx = {-1, 0, 1, 0}; // �ĸ�����
	private static int[] dy = {0, -1, 0, 1};
	private static String start;
	private static String end;
	static class Puzzle {
		String f; // �Ź�ͼĿǰ��״̬
		int x, y; // ��㣨�ո񣩵ĺᣬ������
		int path; // ����
		Puzzle(String f, int x, int y, int path) {
			this.f = f;
			this.x = x;
			this.y = y;
			this.path = path;
		}
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		start = input.next();
		end = input.next();
	
		bfs();

	}

	// ����
	public static String swap(String str, char a, char b) {
		str = str.replace(a, '-');
		str = str.replace(b, a);
		str = str.replace('-', b);
		return str;
	}

	public static void bfs() {
		// Ѱ�ҿո񣨾�㣩
		int x = 0, y = 0;
		for(int i = 0; i < start.length(); i++) {
			if(start.charAt(i) == '.') {
				// �� ����λ��i �ֳɶ�ά�����x��y
				// ���⣺ͨ����������䣬���԰�һ���ַ���ת��Ϊ��ά����
				x = i / N; // ��
				y = i % N; // ��
			}
		}
		Queue<Puzzle> q = new LinkedList<>(); // �������У����������
		
		q.add(new Puzzle(start, x, y, 0)); // �������
		set.add(start); // ����ǣ���ʾ�Ѿ����ڸ�״̬
		while(! q.isEmpty()) {
			Puzzle cur = q.poll();
			// ����ҵ�
			if(cur.f.equals(end)) {
				System.out.println(cur.path);
				return ;
			}
			// �Ӿ�㿪ʼ���ĸ�������
			for(int i = 0; i < 4; i++) {
				int tx = cur.x + dx[i];
				int ty = cur.y + dy[i];
				if(tx < 0 || tx >= N || ty < 0 || ty >= N) continue;
				
				// tx * N + ty ��������������ַ���ת����һ�������������תΪ�ַ�����λ��
				char n = cur.f.charAt(tx * N + ty); // ��ȡ��㽫Ҫ�ƶ�����һ��λ���ϵľɵ��ַ�
				String t = swap(cur.f, n, '.'); // ������ƶ�
				
				if(! set.contains(t)) { // ����״̬�Ƿ���ֹ�
					set.add(t); // �����
					q.add(new Puzzle(t, tx, ty, cur.path + 1)); // �ٰ��ƶ�����һ���µľŹ�ͼ�������
				}
			}
		}

		System.out.println("-1");
	}
}
