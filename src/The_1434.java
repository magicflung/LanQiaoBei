import java.util.Scanner;

public class The_1434 {
	private static int n;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
//		Set<Integer> set = new TreeSet<>();
		boolean flag = true;
		for(int i = 10000; i < 1000000; i++) { // ������ԭ����i�ķ�Χ��1000д���ˡ���λ����6λ��
			if(isTarget(i)) {
//				set.add(i);
				flag = false;
				System.out.println(i);
				
			}
		}
		
//			ֱ�����Ҳ���ԣ����÷�����Ҳ����
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
//		һ��ʼʹ��set���ϣ�����ʵ���Բ��ã�ʹ��һ��flag���ж��Ƿ��з��ϵ������У���ʡ�ڴ�
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
		// ���ַ����������ģ��ڴ�ռ�ø��ˣ���ʱҲ����
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
		
		// ��һ������ ����������������������ڴ���Сһ������ʱҲ��Сһ��
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
