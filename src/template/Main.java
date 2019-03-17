package template;

public class Main {
	private int[]array;
	private int[]book;
	private int sum;
	
	public Main() {
		this.array = new int[20];
		this.book = new int[20];
		this.sum = 0;
	}
	
	public void dfs(int step) {		
		if(step==12) { // ��ֹ��������Ϊ��0��ʼ�����Ե�12��ʾ�ܹ�Ϊ13����
			if(compare()) {
				sum++;
			}
			return;
		}
		for (int i = 1; i < 14; i++) {
			
			if(book[i] == 0) { // ˵����û�����ʹ�
				array[step] = i;
				
				book[i]=1;
				dfs(step+1);
				book[i]=0;
			}
		}
		return;
		
	}
	public boolean compare() {
		// ����
		int a = array[0]*array[1] + array[2]*array[3];
		int b = array[4]*array[5];
		int c = array[6]*array[7]-array[8]*array[9];
	    int d = array[10]*array[11];
		if(a==b&&c==d) {
		//	System.out.println(a+" "+c);
			return true;
		}

		return false;
	}
	public void print() {
		System.out.println(sum);
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.dfs(0);
		main.print();
	}

}

