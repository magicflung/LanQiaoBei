import java.util.Scanner;

public class The_1094 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		String str = null;
		for(int i = 0; i <= N; i++) {
			str = input.nextLine();
			// ��Ϊ�ڵ�һ������һ������ʱ�����»س����������뻺���л���һ�����з�����������������ַ�ʱ�����Ȱѻ��з���ȡ
			// ����ֻ������ N-1�У����ԣ�ʹ�������if������Ȱ� ���з��ȶ�ȡ��
			if(i == 0) { 
				continue;
			}
			System.out.println(str + "\n");
		}
		while(input.hasNext()) {
			str = input.nextLine();
			String[] t = str.split(" ");
			for(int i = 0; i < t.length; i++) {
				System.out.println(t[i] + "\n");
			}
		}
	}
}
