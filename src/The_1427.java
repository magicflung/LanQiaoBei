import java.util.Scanner;

public class The_1427 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		int result = 0;
		for(int i = 1; i < 100000; i++) { // ��Ϊÿ����װ���ǹ���������1000������Ӧ�� 1000*1000����100000Ҳ�ԣ���֪����ô���
			if(solve(n, m, i)) {
				result = i;
			}
		}
		System.out.println(result);
	}

	private static boolean solve(int n, int m, int s) {
		if(s % n == 0 || s % m == 0) { // ��n��m �ı����Ļ�
			return false;
		}
		for(int i = 1; i * n < s; i++) { // ������� �п��� s = i * n + j * m
			if((s-i*n) % m == 0) {
				return false;
			}
		}
		return true;
	}
}
