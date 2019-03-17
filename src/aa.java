import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class aa {
	private static final int N = 3;
	private static int[] dx = {-1, 0, 1, 0}; // 四个方向
	private static int[] dy = {0, -1, 0, 1};
	private static String start;
	private static String end;
	private static Set<char[]> set = new HashSet<>();
	static class Puzzle {
		char[] f; // 九宫图目前的状态
		int space; // 句点（空格）的横，纵坐标
		int path; // 步数
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

	// 交换
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
			// 找到错误，出错在这，交换句点和旧字符错误
			// 我觉得是使用 char[]时，出现引用，而不是复制
			char[] ne = new char[9];
//			char[] ne = cur.f; // 使用数组的话，这句话就会使得答案错误
			for(int j = 0; j < 9; j++) { // 一个一个字符复制的话就不会错误
				ne[j] = cur.f[j];
			}
			ne = swap(ne, cur.space, tx * N + ty);

			int space = tx * N + ty; // 更新space的位置
			
			if(! set.contains(ne)) { // 检查该状态是否出现过
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
