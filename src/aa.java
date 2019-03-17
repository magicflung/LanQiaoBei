import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class aa {
	private static final int N = 3;
	private static int[] dx = {-1, 0, 1, 0}; // �ĸ�����
	private static int[] dy = {0, -1, 0, 1};
	private static String start;
	private static String end;
	private static Set<char[]> set = new HashSet<>();
	static class Puzzle {
		char[] f; // �Ź�ͼĿǰ��״̬
		int space; // ��㣨�ո񣩵ĺᣬ������
		int path; // ����
		Puzzle(char[] f, int space, int path) {
			this.f = f;
			this.space = space;
			this.path = path;
		}
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		start = input.next();
		int space = 0;
		char[] f = new char[9];
		for(int i = 0; i < start.length(); i++) {
			f[i] = start.charAt(i);
			if(f[i] == '.') {
				space = i;
			}
		}
		Puzzle p = new Puzzle(f, space, 0);
		
		end = input.next();
	
		bfs(p);
		
	}

	// ����
	public static char[] swap(char[] str, int a, int b) {
//		char aa = str.charAt(a);
//		char bb = str.charAt(b);
//		str = str.replace(aa, '-');
//		str = str.replace(bb, aa);
//		str = str.replace('-', bb);
		char t = str[a];
		str[a] = str[b];
		str[b] = t;
		return str;
	}
	public static void bfs(Puzzle p) {
	Puzzle cur;
	Queue<Puzzle> q = new LinkedList<>();
	set.add(p.f);
//	p.space = 0;
	q.add(p);
	while(! q.isEmpty()) {
		cur = q.poll();
		if(isTarget(cur)) {
			System.out.println(cur.path);
			return ;
		}
		int sx = cur.space / N;
		int sy = cur.space % N;
		for(int i = 0; i < 4; i++) {
			int tx = sx + dx[i];
			int ty = sy + dy[i];
			if(tx < 0 || tx >= N || ty < 0 || ty >= N) continue;
			// �ҵ����󣬳������⣬�������;��ַ�����
			// �Ҿ�����ʹ�� char[]ʱ���������ã������Ǹ���
			char[] ne = new char[9];
//			char[] ne = cur.f; // ʹ������Ļ�����仰�ͻ�ʹ�ô𰸴���
			for(int j = 0; j < 9; j++) { // һ��һ���ַ����ƵĻ��Ͳ������
				ne[j] = cur.f[j];
			}
			ne = swap(ne, cur.space, tx * N + ty);

			int space = tx * N + ty; // ����space��λ��
			
			if(! set.contains(ne)) { // ����״̬�Ƿ���ֹ�
				set.add(ne);
				q.add(new Puzzle(ne, space, cur.path + 1));
			}
		}
	}

	System.out.println("-1");
}

	private static boolean isTarget(Puzzle cur) {
		for(int i = 0; i < 9; i++) {
			if(cur.f[i] != end.charAt(i)) {
				return false;
			}
		}
		return true;
	}
}
