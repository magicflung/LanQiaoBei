

import java.util.Scanner;

public class The_2057 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		int[] arr = new int[n+1];
		for(int i = 1; i <= m; i++) {
			int l = input.nextInt();
			int r = input.nextInt();
			int c = input.nextInt();
			for(int j = l; j <= r; j++) {
				arr[j] = c;
			}
		}
		int x = input.nextInt();
		if(arr[x] == 0) {
			System.out.println("0");
		} else {
			System.out.println(arr[x]);
		}
	}
}
