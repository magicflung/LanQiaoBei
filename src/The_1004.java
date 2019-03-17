import java.util.Scanner;

public class The_1004 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n;
		int[] arr = new int[55];
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 3;
		arr[4] = 4;
		for (int i = 5; i < arr.length; i++) {
			// 推导公式错误，在n=8时，牛的总数为19
//			arr[i] = arr[i-1] + i - 4 + 1;
			// 我们用表格来列出，并找规律得到下面的式子
			arr[i] = arr[i-1] + arr[i-3];
		}
		while(input.hasNext()) {
			n = input.nextInt();
			if(n == 0) break;
			System.out.println(arr[n]);
		}
	}
}
