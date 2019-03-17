package template;

import java.util.Scanner;

public class test1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
//		String m = input.next();
//		String n = input.next();
//		long mm, nn;
		System.out.println(change16(17));
//		int j = 0;
//		for(int i = m; i <= n; i++) {
//			arr[j++] = change16(i);
//		}
//		int k = 0, sum = 0;
//		for(int i = j-1; i >= 0; i--) {
//			sum += (arr[i] * Math.pow(16, k++));
//		}
//		System.out.println(sum%15);
	}
	private static int change16(int m) {
		int t,sum=0;
		while(true) {
			t = m % 16;
			if(t == 0) {
				break;
			}
			sum = sum*10 + t;
			m /= 16;
		}
		return sum;
	}
	
}
