import java.util.Scanner;

public class The_1094 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		String str = null;
		for(int i = 0; i <= N; i++) {
			str = input.nextLine();
			// 因为在第一次输入一个整数时，按下回车，会在输入缓存中缓存一个换行符，所以在下面接受字符时，会先把换行符读取
			// 导致只能输入 N-1行，所以，使用下面的if语句来先把 换行符先读取了
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
