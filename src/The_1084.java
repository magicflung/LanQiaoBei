import java.util.Scanner;

public class The_1084 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		boolean[] isPrime = new boolean[N+1];
		// 是素数用true来表示，不是素数用false来表示
		// 删除0和1
		// isPrime[0] = isPrime[1] = false;
		for(int i = 2; i <= N; i++) {
			isPrime[i] = true;
		}
		int j = 0;
		for(int i = 2; i * i <= N; i++) {
			// 留下i
			if(isPrime[i]) {
				j = i + i; // i 的倍数
				while(j <= N) { // 删除i的倍数
					isPrime[j] = false;
					j = j + i;
				}
			}
		}
		for(int i = 2; i <= N; i++) {
			if(isPrime[i]) {
				System.out.println(i);
			}
		}
	}
}
