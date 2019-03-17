import java.util.Scanner;

public class The_1083 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] a = new int[10001];
		int i = 0;
		while(input.hasNext()) {
			a[i++] = input.nextInt();
		}
		for(int j = 0; j < i; j++) {
			System.out.print((char)a[j]);
		}
	}
}
