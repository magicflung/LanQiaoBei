import java.util.Scanner;

public class The_1084 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		boolean[] isPrime = new boolean[N+1];
		// ��������true����ʾ������������false����ʾ
		// ɾ��0��1
		// isPrime[0] = isPrime[1] = false;
		for(int i = 2; i <= N; i++) {
			isPrime[i] = true;
		}
		int j = 0;
		for(int i = 2; i * i <= N; i++) {
			// ����i
			if(isPrime[i]) {
				j = i + i; // i �ı���
				while(j <= N) { // ɾ��i�ı���
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
