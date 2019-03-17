import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;


/** 九宫图
 * @author MUSTACHE
 *
 */
public class The_1426 {
	private static final int N = 3;
	private static Set<String> set = new HashSet<>();
	private static int[] dx = {-1, 0, 1, 0}; // 四个方向
	private static int[] dy = {0, -1, 0, 1};
	private static String start;
	private static String end;
	static class Puzzle {
		String f; // 九宫图目前的状态
		int x, y; // 句点（空格）的横，纵坐标
		int path; // 步数
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

	// 交换
	public static String swap(String str, char a, char b) {
		str = str.replace(a, '-');
		str = str.replace(b, a);
		str = str.replace('-', b);
		return str;
	}

	public static void bfs() {
		// 寻找空格（句点）
		int x = 0, y = 0;
		for(int i = 0; i < start.length(); i++) {
			if(start.charAt(i) == '.') {
				// 把 句点的位置i 分成二维数组的x和y
				// 额外：通过这两条语句，可以把一个字符串转换为二维数组
				x = i / N; // 横
				y = i % N; // 纵
			}
		}
		Queue<Puzzle> q = new LinkedList<>(); // 创建队列（广度搜索）
		
		q.add(new Puzzle(start, x, y, 0)); // 加入队列
		set.add(start); // 做标记，表示已经存在该状态
		while(! q.isEmpty()) {
			Puzzle cur = q.poll();
			// 如果找到
			if(cur.f.equals(end)) {
				System.out.println(cur.path);
				return ;
			}
			// 从句点开始分四个方向走
			for(int i = 0; i < 4; i++) {
				int tx = cur.x + dx[i];
				int ty = cur.y + dy[i];
				if(tx < 0 || tx >= N || ty < 0 || ty >= N) continue;
				
				// tx * N + ty 这跟上面那两条字符串转数组一样，这句是数组转为字符串的位置
				char n = cur.f.charAt(tx * N + ty); // 获取句点将要移动到下一个位置上的旧的字符
				String t = swap(cur.f, n, '.'); // 将句点移动
				
				if(! set.contains(t)) { // 检查该状态是否出现过
					set.add(t); // 做标记
					q.add(new Puzzle(t, tx, ty, cur.path + 1)); // 再把移动的下一个新的九宫图加入队列
				}
			}
		}

		System.out.println("-1");
	}
}
