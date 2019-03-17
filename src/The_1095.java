import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class The_1095 {
	public static Map<Integer, Integer> map = new HashMap<>();
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()) {
			int i = input.nextInt();
			int j = input.nextInt();
			int a = i, b = j;
			if(a > b) {
				int t = a;
				a = b;
				b = t;
			}
			int max = 0;
			for(int k = a; k <= b; k++) {
				Integer t = map.get(k);
				if(t == null) {
					t = solve(k);
				}
				max = Math.max(max, t);
			}
			System.out.println(i + " " + j + " " + max);
		}
	}
	public static int solve(int k) {
		int count = 0;
		while(true) {
			count++; // 因为包括k和1，所以放最前面
			if(k == 1) {
				break;
			}
			if((k & 1) == 0) {
				k /= 2;
			} else {
				k = k * 3 + 1;
			}
		}

		return count;
	}
}
