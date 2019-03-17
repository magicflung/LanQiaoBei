import java.util.Scanner;

public class The_1427 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		int result = 0;
		for(int i = 1; i < 100000; i++) { // 因为每个包装的糖果都不多于1000，本来应该 1000*1000，但100000也对，不知道怎么理解
			if(solve(n, m, i)) {
				result = i;
			}
		}
		System.out.println(result);
	}

	private static boolean solve(int n, int m, int s) {
		if(s % n == 0 || s % m == 0) { // 是n和m 的倍数的话
			return false;
		}
		for(int i = 1; i * n < s; i++) { // 这里测试 有可能 s = i * n + j * m
			if((s-i*n) % m == 0) {
				return false;
			}
		}
		return true;
	}
}
