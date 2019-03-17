import java.util.Scanner;

public class The_1434 {
	private static int n;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
//		Set<Integer> set = new TreeSet<>();
		boolean flag = true;
		for(int i = 10000; i < 1000000; i++) { // 啊啊啊原来错i的范围，1000写错了。五位数到6位数
			if(isTarget(i)) {
//				set.add(i);
				flag = false;
				System.out.println(i);
				
			}
		}
		
//			直接输出也可以，调用方法体也可以
//			int t = i, sum = 0, num = 0;
//			while(t > 0) {
//				num = num * 10 + t % 10;
//				sum += t % 10;
//				t /= 10;
//			}
//			if(num == i && sum == n) {
//				flag = false;
//				System.out.println(i);
//			}
//		}
//		一开始使用set集合，但其实可以不用，使用一个flag来判断是否有符合的数就行，节省内存
//		if(set.isEmpty()) {
//			System.out.println("-1");
//		} else {
//			for(Integer i:set) {
//				System.out.println(i);
//			}
//		}
		
		if(flag) {
			System.out.println("-1");
		}
	}
	
	public static boolean isTarget(int x) {
		// 这种方法是我做的，内存占用高了，耗时也高了
//		StringBuilder sb = new StringBuilder();
//		sb.append(x);
//		int len = sb.length();
//		for(int i = 0; i < len / 2; i++) {
//			if(sb.charAt(i) != sb.charAt(len-1-i)) {
//				return false;
//			}
//		}
//		int sum = 0;
//		for(int i = 0; i < len; i++) {
//			sum += sb.charAt(i) - '0';
//			if(sum > n) {
//				return false;
//			}
//		}
//		if(sum != n) {
//			return false;
//		}
//		return true;
		
		// 另一种做法 这种做法比上面的做法：内存缩小一倍，耗时也缩小一倍
		int t = x, sum = 0, num = 0;
		while(t > 0) {
			num = num * 10 + t % 10;
			sum += t % 10;
			t /= 10;
		}
		if(num == x && sum == n) {
			return true;
		}
		return false;
	}
}
