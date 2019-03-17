import java.util.Scanner;

public class The_1431 {
	private static int[] candy; // 存储每个朋友的糖果数
	private static int N;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		candy = new int[N];
		for(int i = 0; i < N; i++) {
			candy[i] = input.nextInt();
		}
		solve();
	}
	public static void solve() {
		int re = 0;
		
		while(true) {
			for(int i = 0; i < N; i++) {
				if((i+1) % 2 != 0) {
					int t = candy[i] / 2;
					candy[i] = t;
					if(i+1 == N) {
						candy[0] += t;
					} else {
						candy[i + 1] += t;
					}
				} else {
					// 如果candy[i]为奇数
					while(candy[i] % 2 != 0) {
						candy[i] += ++re;
					}
				}
				if(isSame()) {
					System.out.println(re);
					return ;
				}
			}
		}
		

	}
	public static boolean isSame() {
		for(int i = 1; i < N; i++) {
			if(candy[i] != candy[i-1]) {
				return false;
			}
		}
		return true;
	}
}
